/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.*;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class GenericParameterTypeImpl implements Type {

	private ParametreGenericite parametreGenericite;
	private LinkedList<ObjetUse> instanceGenericite;

	public GenericParameterTypeImpl(ParametreGenericite _parametreGenericite) {
		this.parametreGenericite = _parametreGenericite;
	}

	public GenericParameterTypeImpl(ParametreGenericite _parametreGenericite, LinkedList<ObjetUse> _instanceGenericite) {
		this.parametreGenericite = _parametreGenericite;
		this.instanceGenericite = _instanceGenericite;
	}
	
	public Type getType() {
		return this;
	}

	public ParametreGenericite getParametreGenericite()
	{
		return this.parametreGenericite;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof GenericParameterTypeImpl) {
			return this.parametreGenericite.getName().equals(((GenericParameterTypeImpl)_other).getParametreGenericite().getName());
		} else {
			return false;
}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		System.out.println("CompatibleWith INCOMPLETE in ClassTypeImpl.java");
		if(_other instanceof GenericParameterTypeImpl)
		{
			GenericParameterTypeImpl _type = (GenericParameterTypeImpl) _other;
			ParametreGenericite _parametreGenericite = _type.getParametreGenericite();
			if(this.parametreGenericite.equals(_parametreGenericite))
				return true;
		}	
		return false;	

	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		throw new SemanticsUndefinedException("merge is undefined in ClassTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		return 1;
	}
	
	/*public int getTaillePointee() {
		int taille = 0;
		List<Attribut> attributs = this.classe.getAttributs();
		for (Attribut a : attributs) {
			taille += a.getType().length();
		}
		return taille;
	}*/

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	//	private LinkedList<ObjetUse> instanceGenericite;
		/*String resultat = this.classe.getName() +" ";
		if(this.instanceGenericite != null)
		{
			resultat +="<";
			for(ObjetUse o : this.instanceGenericite)
			{
				resultat += o.getObjet().getName()+",";
			}
			resultat +="> ";
		}*/
		return this.parametreGenericite.getName();
	}
}
