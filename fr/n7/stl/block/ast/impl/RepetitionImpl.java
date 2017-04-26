/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a repetition instruction.
 * @author Marc Pantel
 *
 */
public class RepetitionImpl implements Instruction {

	protected Expression condition;
	protected Block body;

	public RepetitionImpl(Expression _condition, Block _body) {
		this.condition = _condition;
		this.body = _body;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "while (" + this.condition + ") " + this.body;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return condition.getType().equalsTo(AtomicType.BooleanType) && body.checkType();
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
        this.body.allocateMemory(_register, _offset);
        return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		int labelNumber = _factory.createLabelNumber();
		Fragment _code = this.condition.getCode(_factory);
		_code.add(_factory.createJumpIf("fin_boucle_" + labelNumber, 0));
		_code.addPrefix("debut_boucle_" + labelNumber + ":");
		_code.append(this.body.getCode(_factory));
		_code.add(_factory.createJump("debut_boucle_" + labelNumber));
		_code.addSuffix("fin_boucle_" + labelNumber + ":");
		return _code;
	}

}
