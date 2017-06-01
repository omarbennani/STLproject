/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable declaration instruction.
 * @author Marc Pantel
 *
 */
public class VariableDeclarationImpl implements VariableDeclaration {

	private String name;
	protected Type type;
	protected Expression value;
	protected Register register;
	protected int offset;
	
	/**
	 * Creates a variable declaration instruction node for the Abstract Syntax Tree.
	 * @param _name Name of the declared variable.
	 * @param _type Type of the declared variable.
	 * @param _value Value of the declared variable.
	 */
	public VariableDeclarationImpl(String _name, Type _type, Expression _value) {
		this.name = _name;
		this.type = _type;
		this.value = _value;
	}
	
	public VariableDeclarationImpl(String _name) {
		this.name = _name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.type + " " + this.name + " = " + this.value + ";\n";
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.VariableDeclaration#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public void setValue(Expression _value) {
		this.value = _value;
	}
	
	@Override
	public Expression getValue() {
		return this.value;
	}
	
	@Override
	public void setType(Type _type) {
		this.type = _type;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getRegister()
	 */
	@Override
	public Register getRegister() {
		return this.register;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.VariableDeclaration#getOffset()
	 */
	@Override
	public int getOffset() {
		return this.offset;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		return this.value.getType().compatibleWith(type);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.register = _register;
        this.offset = _offset;
        if (this.getType() instanceof ClassTypeImpl)
        	return 1;
        else
        	return this.type.length();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		if (this.value instanceof ObjetAllocationImpl) {
			_code.add(_factory.createPush(1));
			_code.add(_factory.createLoadL(((ClassTypeImpl)this.getTypeReel()).getTaillePointee()));
			_code.add(Library.MAlloc);
			_code.add(_factory.createStore(this.register, this.offset, 1));
			_code.add(_factory.createLoad(this.register, this.offset, 1));
			_code.append(this.value.getCode(_factory));
		} else {
			_code.add(_factory.createPush(type.length()));
			_code.append(this.value.getCode(_factory));
			_code.add(_factory.createStore(this.register, this.offset, this.type.length()));
		}
        return _code;
	}

	public Type getTypeReel() 
	{
		return this.value.getTypeReel();
	}

}
