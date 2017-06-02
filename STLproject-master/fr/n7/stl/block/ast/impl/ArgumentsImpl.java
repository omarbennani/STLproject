/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Expressions;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for the arguments of a call of a method.
 *
 */
public class ArgumentsImpl implements Arguments {

	/**
	 * Les expressions correspondant aux arguments de la méthode appelée.
	 */
	protected Expressions exp;
	
	public ArgumentsImpl() {

	}
	
	public ArgumentsImpl(Expressions _exp) {
		this.exp = _exp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  "(" + ((this.exp != null)?this.exp.toString():new String()) + ")" ;
	}

	@Override
	public Type getType() {
		// Aucun getType n'est effectué sur ArgumentsImpl.
		return null;
	}
	
	@Override
	public Type getTypeReel() {
		// Aucun getTypeReel n'est effectué sur ArgumentsImpl.
		return null;
	}
	
	/**
	 * Retourne la liste des types des arguments.
	 * @return La liste des types.
	 */
	public List<Type> getListType() {
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
}
