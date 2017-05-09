package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;

public class FinalStaticFieldImpl extends VariableDeclarationImpl implements ElementInterface {

	private String name;
	private Type type;
	private Expression value;
	
	public FinalStaticFieldImpl(String _name, Type _type, Expression _expr) {
		super(_name, _type, _expr);
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public Type getType() {
		return type;
	}
	
	public Expression getExpression() {
		return value;
	}
	
	@Override
	public boolean checkType() {
		return value.getType().compatibleWith(type);
	}
	
	@Override
	public String toString() {
		return this.type + " " + this.name + " = " + this.value + ";\n";
	}
	
}