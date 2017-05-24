/**
 * 
 */
package fr.n7.stl.block.ast.impl;


import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class ClassTypeImpl implements Type {

	private Classe classe;

	public ClassTypeImpl(Classe _classe) {
		this.classe = _classe;
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
		return true;
		//throw new SemanticsUndefinedException("compatibleWith is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
	    return this;
	    //throw new SemanticsUndefinedException("merge is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		int taille = 0;
		List<Attribut> attributs = this.classe.getAttributs();
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
		return new String( this.classe.getName());
	}
}
