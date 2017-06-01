/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Optional;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class ReturnInstructionImpl implements Instruction {

	protected Expression ret;
	protected Type typeRetour;
	public ReturnInstructionImpl(Expression _ret, Type _typeRetour) {
		this.ret = _ret;
		this.typeRetour = _typeRetour;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "return " + this.ret.toString();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		if(this.typeRetour.equalsTo(this.ret.getType()))
			return true;
		else
			return false;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.append(this.ret.getCode(_factory));
		return _code;
	}

}
