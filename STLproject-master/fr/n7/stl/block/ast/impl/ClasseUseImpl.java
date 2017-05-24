/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.VariableDeclaration;
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
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public ClasseUseImpl(Classe _classe) {
		this.classe = _classe;
	}

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
		throw new SemanticsUndefinedException("getCode is not defined in ClasseUseImpl");
	}

}
