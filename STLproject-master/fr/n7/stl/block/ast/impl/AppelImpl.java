/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AppelOuAcces;
import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a call of a method.
 * 
 */
public class AppelImpl implements AppelOuAcces, Instruction {

	/**
	 * La déclaration de la méthode qui est appelée.
	 */
	protected Declaration methode;
	/**
	 * Les arguments de la méthode qui est appelée.
	 */
	protected Arguments args;
	/**
	 * L'expression sur laquelle la méthode est appelée.
	 */
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
		if (this.exp != null)
			res += this.exp.toString();
		else
			res += "this";
		res += ".";
		res += this.methode.getName();
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
		// On verifie le nombre d'argument 
		Boolean _res=(this.args.getListType().size()== ((Methode) this.methode).getParametres().size());
		// On verifie tous les types de la liste et leur ordre
		for(int i=0;i<this.args.getListType().size();i++){
			_res=_res && ((Methode) this.methode).getParametres().get(i).getType().equals(this.args.getListType().get(i));
		}
		//Verfier que le radical (exp) contient la methode
		return _res;
	}


	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.append(this.exp.getCode(_factory));
		_code.append(this.args.getCode(_factory));
		_code.add(_factory.createCall(((Methode)this.methode).getEtiquette(), Register.LB));
		return _code;
	}

}
