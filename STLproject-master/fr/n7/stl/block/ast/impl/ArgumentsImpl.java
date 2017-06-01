/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Expressions;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Implementation of the Abstract Syntax Tree node for a variable declaration instruction.
 * @author Marc Pantel
 *
 */
public class ArgumentsImpl implements Arguments {

	protected Expressions exp;
	
	public ArgumentsImpl() 
	{

	}
	public ArgumentsImpl(Expressions _exp) 
	{
		this.exp = _exp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
		return  "(" + ((this.exp != null)?this.exp.toString():new String()) + ")" ;
	}

	@Override
	public Type getType()
	{
		throw new SemanticsUndefinedException("getType() not defined in ArgumentsImpl");
	}
	
	@Override
	public Type getTypeReel()
	{
		throw new SemanticsUndefinedException("getTypeReel() not defined in ArgumentsImpl");
	}
	
	
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		if (this.exp != null) {
			List<Expression> expressions = this.exp.getExpressions();
			for (Expression e : expressions) {
				_code.append(e.getCode(_factory));
			}
		}
		return _code;
	}

	public List<Type> getListType()
	{
		List<Type> t = new LinkedList<Type> ();
		if (exp != null) {
			List<Expression> expr = this.exp.getExpressions();
			for(Expression e : expr)
			{
				t.add (e.getType());
			}
		}
		return t;
	}
}
