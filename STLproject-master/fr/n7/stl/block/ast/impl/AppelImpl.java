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

	protected Declaration methode;
	protected Arguments args;
	protected Expression exp;

	public AppelImpl(Expression _exp, Declaration _meth, Arguments _args)
	{
		this.args = _args;
		this.methode = _meth;
		this.exp = _exp;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String res = "";
		res+= this.exp.toString();
		res += ".";
		res+= this.methode.getName();
		if (args != null)
			res+= this.args.toString();
		

		return res;
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		 return ((Methode)methode).getType();
	}
	
	@Override
	public Type getTypeReel() {
		return this.getType();
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
