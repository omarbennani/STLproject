/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AppelOuAcces;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.BinaryOperator;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.util.Logger;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;

/**
 * Implementation of the Abstract Syntax Tree node for a binary expression.
 * @author Marc Pantel
 *
 */
public class AccesImpl implements AppelOuAcces {

	protected Expression exp;
	protected String ident;

	public AccesImpl(Expression _exp, String _ident) // Ici Expression est potentiellement un AccesImpl
	{
		this.exp = _exp;
		this.ident = _ident;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {		
		return this.exp.toString() + "." + this.ident;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		 return this.exp.getType();
	}
	
	 @Override
	 public Type getTypeReel() {
		 return this.getType();
	 }

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		 throw new SemanticsUndefinedException("getCode is undefined in AccesImpl.java");
	}

}
