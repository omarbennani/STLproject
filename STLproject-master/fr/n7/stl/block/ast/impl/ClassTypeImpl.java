/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class ClassTypeImpl implements Type {

	private Classe classe;
	private LinkedList<ObjetUse> instanceGenericite;

	public ClassTypeImpl(Classe _classe) {
		this.classe = _classe;
	}

	public ClassTypeImpl(Classe _classe, LinkedList<ObjetUse> _instanceGenericite) {
		this.classe = _classe;
		this.instanceGenericite = _instanceGenericite;
	}
	
	public Type getType() {
		return this;
	}

	public Classe getClasse()
	{
		return this.classe;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof ClassTypeImpl) {
			return this.classe.getName().equals(((ClassTypeImpl)_other).getClasse().getName());
		} else {
			return false;
}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if(_other instanceof ClassTypeImpl)
		{
			ClassTypeImpl _type = (ClassTypeImpl) _other;
			Classe _classe = _type.getClasse();
			if(this.classe.equals(_classe) || _classe.estEtendue(this.classe))
				return true;
		} else if (_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl _type = (InterfaceTypeImpl) _other;
			Interface _interface = _type.getInterface();
			if (this.classe.implemente(_interface))
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
	
	public int getTaillePointee() {
		int taille = 0;
		List<Attribut> attributs = this.classe.getAttributsNonStatiques();
		for (Attribut a : attributs) {
			taille += a.getType().length();
		}
		return taille;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
	//	private LinkedList<ObjetUse> instanceGenericite;
		String resultat = this.classe.getName() +" ";
		if(this.instanceGenericite != null)
		{
			resultat +="<";
			for(ObjetUse o : this.instanceGenericite)
			{
				resultat += o.getObjet().getName()+",";
			}
			resultat +="> ";
		}
		return resultat;
	}
}
