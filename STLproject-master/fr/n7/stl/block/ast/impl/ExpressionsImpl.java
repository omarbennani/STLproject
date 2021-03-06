/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Expressions;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a list of expressions.
 * @author Marc Pantel
 *
 */
public class ExpressionsImpl implements Expressions {

	protected LinkedList<Expression> expressions;
	
	public ExpressionsImpl() {
		this.expressions = new LinkedList<Expression>();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String local = new String();
		Iterator<Expression> itr = this.expressions.iterator();
      
  		while(itr.hasNext()) {
     		Expression element = (Expression) (itr.next());
     		local+=element.toString();
  		}

		return local;
	}

	public void addExpression(Expression _expr){
		this.expressions.addFirst(_expr);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		// getType n'est pas appelé dans Expressions
		return null;
	}
	
	@Override
	public Type getTypeReel() {
		// getTypeReel n'est pas appelé dans Expressions
		return null;
	}
	
	public List<Expression> getExpressions() {
		return this.expressions;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() not defined in ExpressionsImpl");
	}
}
