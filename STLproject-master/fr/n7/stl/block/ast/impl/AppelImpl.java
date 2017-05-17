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
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Arguments;

import fr.n7.stl.tam.ast.Register;

/**
 * Implementation of the Abstract Syntax Tree node for a binary expression.
 * @author Marc Pantel
 *
 */
public class AppelImpl implements AppelOuAcces, Instruction {

	protected boolean statiC;
	protected Declaration decl;
	protected Interface i;
	protected Classe c;
	protected Arguments args;
	protected Expression exp;
	//protected String nomMethode;

	public AppelImpl(Declaration _decl, Arguments _args)//, String _nomMethode) 
	{
		this.args = _args;
		//this.nomMethode = _nomMethode;
		this.statiC = false;
		this.decl = _decl;
		this.i = null;
		this.c = null;
		this.exp = null;
	}

	public AppelImpl(Expression _exp, Arguments _args)//, String _nomMethode) 
	{
		this.args = _args;
		this.exp = _exp;
		//this.nomMethode = _nomMethode;
		this.statiC = false;
		this.decl = null;
		this.i = null;
		this.c = null;
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
			res+= this.i.getName() +".";

		if(this.c != null)
			res+= this.c.getName() +".";

		if(this.exp != null)
			res+= this.exp.toString();

		if(this.decl != null)
			res+= this.decl.getName();


	//	res+= this.ident +" ";
		//if(this.nomMethode!=null)
			//res+=this.nomMethode+ " ";

		res+= this.args.toString() +" ";
		

		return res;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		 throw new SemanticsUndefinedException("getType is undefined in AppelImpl.java");
	}

	@Override
	public boolean checkType() {
		 throw new SemanticsUndefinedException("checkType is undefined in AppelImpl.java");
	}


	@Override
	public int allocateMemory(Register _register, int _offset) {
		 throw new SemanticsUndefinedException("allocateMemory is undefined in AppelImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		 throw new SemanticsUndefinedException("getCode is undefined in AppelImpl.java");
	}

}
