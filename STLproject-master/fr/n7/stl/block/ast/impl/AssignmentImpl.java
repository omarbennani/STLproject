/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.impl.BlockFactoryImpl;
import fr.n7.stl.block.ast.BlockFactory;
import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an array type.
 * @author Marc Pantel
 *
 */
public class AssignmentImpl implements Instruction , Assignable{

	protected VariableDeclaration declaration;
	protected Expression value;
	protected Assignable assignable;

	/**
	 * Create an assignment instruction implementation from the assigned variable declaration
	 * and the assigned value.
	 * @param _declaration Assigned variable declaration.
	 * @param _value Assigned value.
	 */
	public AssignmentImpl(VariableDeclaration _declaration, Expression _value) {
		this.declaration = _declaration;
		this.value = _value;
	}

	/**
	 * Create an assignment instruction implementation from the assignable expression
	 * and the assigned value.
	 * @param _assignable Expression that can be assigned a value.
	 * @param _value Value assigned to the expression.
	 */
	public AssignmentImpl(Assignable _assignable, Expression _value) {
		this.assignable = _assignable;
		this.value = _value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return ((this.declaration != null)?this.declaration.getName():this.assignable) + " = " + this.value.toString() + ";\n";
		return ((this.declaration != null)?this.declaration.getName():this.assignable) + " = " + this.value.toString() + ";\n";	
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
        if (this.assignable != null) {
            return this.value.getType().compatibleWith(assignable.getType());
        } else {
		    return this.value.getType().compatibleWith(declaration.getType());
        }
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
		Fragment _code = this.value.getCode(_factory);
		_code.append(this.assignable.getCode(_factory));
		_code.add(_factory.createStoreI(this.value.getType().length()));
		return _code;
	}


	@Override
	public Type getType()
	{
		return this.assignable.getType();
	}

	@Override
	public Type getTypeReel()
	{
		return this.assignable.getTypeReel();
	}
}
