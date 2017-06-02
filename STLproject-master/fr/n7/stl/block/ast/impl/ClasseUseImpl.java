/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class ClasseUseImpl implements ObjetUse {

	protected Classe classe;
	protected LinkedList<ObjetUse> instanceGenericite;
	
	/**
	 * Creates a class use expression Abstract Syntax Tree node.
	 * @param _classe : Declaration of the used class.
	 */
	public ClasseUseImpl(Classe _classe) {
		this.classe = _classe;
	}

	/**
	 * Creates a class use expression Abstract Syntax Tree node.
	 * @param _classe : Declaration of the used class.
	 * @param _instanceGenericite : List of 
	 */
	public ClasseUseImpl(Classe _classe, LinkedList<ObjetUse> _instanceGenericite) {
		this.classe = _classe;
		this.instanceGenericite = _instanceGenericite;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {

		if (this.instanceGenericite == null)
			return ("@{" + this.classe.getName() + "}");
		else
		{
			String result = "@{" + this.classe.getName()+"<";
			for (ObjetUse o : this.instanceGenericite)
			{
				result += o.toString()+",";
			}
			result += ">}";
			return result;
		}
	}


	@Override
	public Objet getObjet()
	{
		return this.classe;
	}
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return classe.getType();
	}
	
	@Override
	public Type getTypeReel() {
		return classe.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.add(_factory.createLoad(this.classe.getRegister(), this.classe.getOffset(), this.classe.getTailleAttributsStatiques()));
		return _code;
	}

}
