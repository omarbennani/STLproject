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

	protected boolean statiC;
	protected Declaration decl; //declaration
	protected Declaration decl1;
	protected Interface i;
	protected Classe c;
	protected Expression exp;

	public AccesImpl() 
	{
		this.exp = null;
		this.statiC = false;
		this.decl = null;
		this.decl1 = null;
		this.i = null;
		this.c = null;
	}

	public AccesImpl(Declaration _decl) 
	{
		this.exp = null;
		this.statiC = false;
		this.decl = _decl;
		this.decl1 = null;
		this.i = null;
		this.c = null;
	}



	public AccesImpl(Interface _i) 
	{
		this.exp = null;
		this.statiC = false;
		this.decl = null;
		this.decl1 = null;
		this.i = _i;
		this.c = null;
	}

	public AccesImpl(Expression _exp) // Ici Expression est potentiellement un AccesImpl
	{
		this.exp = _exp;
		this.statiC = false;
		this.decl = null;
		this.decl1 = null;
		this.i = null;
		this.c = null;
	}

	public AccesImpl(Expression _exp, Declaration _decl) // Ici Expression est potentiellement un AccesImpl
	{
		//System.out.println(_exp.toString() + " " + _decl.toString());
		this.exp = _exp;
		this.statiC = false;
		this.decl = _decl;
		this.decl1 = null;
		this.i = null;
		this.c = null;
	}

	public AccesImpl(Declaration _decl, Declaration _decl1)
	{
		//System.out.println(_exp.toString() + " " + _decl.toString());
		this.exp = null;
		this.statiC = false;
		this.decl1 = _decl1;
		this.decl = _decl;
		this.i = null;
		this.c = null;
	}

	public AccesImpl(Classe _c) // Ici Expression est potentiellement un AccesImpl
	{
		this.c = _c;
	
		this.statiC = false;
		this.decl = null;
		this.decl1 = null;
		this.i = null;
		this.exp = null;
	}

	@Override
	public void setStatic(boolean _b)
	{
		this.statiC = _b;
	}
	
	@Override
	public void setDeclaration(Declaration _d)
	{
		this.decl = _d;
	}
	
	@Override
	public void setInterface(Interface _i)
	{
		this.i = _i;
	}

	@Override
	public void setClasse(Classe _c)
	{
		this.c = _c;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = "";

		if(this.statiC)
			res+=" static ";

		if(this.i != null)
			res+= this.i.toString() +".";

		if(this.c != null)
			res+= this.c.toString() +".";

		if( this.exp != null)
			res+= this.exp.toString() +".";

		if(this.decl != null)
			res+= this.decl.getName() +" ";
		else
			res+="decl is null ";

		if(this.decl1 != null)
			res+= this.decl1.getName() +" ";


		
		//else
			//res+="exp is null for "+this.decl.getName() + " " ;
		
		return res;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		 throw new SemanticsUndefinedException("getType is undefined in AccesImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		 throw new SemanticsUndefinedException("getCode is undefined in AccesImpl.java");
	}

}
