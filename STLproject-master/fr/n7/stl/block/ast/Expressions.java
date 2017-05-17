package fr.n7.stl.block.ast;

public interface Expressions extends Expression {

	public void addExpression(Expression _expr);
	public List<Expression> getExpressions();
}
