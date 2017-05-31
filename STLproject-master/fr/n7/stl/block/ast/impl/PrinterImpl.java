/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a printer instruction.
 * @author Marc Pantel
 *
 */
public class PrinterImpl implements Instruction {

	private Expression parameter;

	public PrinterImpl(Expression _value) {
		this.parameter = _value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "print " + this.parameter + ";";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return (parameter.getType() instanceof AtomicType);
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
		Fragment _code = this.parameter.getCode(_factory);
		if (this.parameter.getType().compatibleWith(AtomicType.IntegerType)) {
			_code.add(Library.IOut);
		} else if(this.parameter.getType().compatibleWith(AtomicType.BooleanType)) {
			_code.add(Library.BOut);
		} else if (this.parameter.getType().compatibleWith(AtomicType.StringType)) {
			_code.add(Library.SOut);
		} else if (this.parameter.getType().compatibleWith(AtomicType.CharacterType)) {
			_code.add(Library.COut);
		}
		_code.add(Library.Ln);
		return _code;
	}

}
