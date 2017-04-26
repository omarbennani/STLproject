/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Optional;

import fr.n7.stl.block.ast.AtomicType;
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
public class ConditionalImpl implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Optional<Block> elseBranch;

	public ConditionalImpl(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.of(_else);
	}

	public ConditionalImpl(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = Optional.empty();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch + ((this.elseBranch.isPresent())?(" else " + this.elseBranch.get()):"");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean result = condition.getType().equalsTo(AtomicType.BooleanType) && thenBranch.checkType();
		if (elseBranch.isPresent()) {
			return result && elseBranch.get().checkType();
		} else {
			return result;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.thenBranch.allocateMemory(_register, _offset);
        if (this.elseBranch.isPresent()) {
            this.elseBranch.get().allocateMemory(_register, _offset);
        }
        return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		int labelNumber = _factory.createLabelNumber();
		Fragment _code = this.condition.getCode(_factory);
		if (this.elseBranch.isPresent()) {
			Fragment _codeElse = this.elseBranch.get().getCode(_factory);
			_code.add(_factory.createJumpIf("else_cond_" + labelNumber, 0));
			_code.append(this.thenBranch.getCode(_factory));
			_code.add(_factory.createJump("fin_cond_" + labelNumber));
			_codeElse.addPrefix("else_cond_" + labelNumber + ":");
			_codeElse.addSuffix("fin_cond_" + labelNumber + ":");
			_code.append(_codeElse);
		} else {
			_code.add(_factory.createJumpIf("fin_cond_" + labelNumber, 0));
			_code.append(this.thenBranch.getCode(_factory));
			_code.addSuffix("fin_cond_" + labelNumber + ":");
		}
		return _code;
	}

}
