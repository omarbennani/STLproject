/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class ObjetTypeImpl implements Type {

	private String identificateur;

	public ObjetTypeImpl(String _identificateur) {
		this.identificateur = _identificateur;
	}
	
	public Type getType() {
		return this;
	}

	public String getIdentificateur()
	{
		return this.identificateur;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof ObjetTypeImpl) {
			return this.identificateur.equals(((ObjetTypeImpl)_other).getIdentificateur());
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
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
		//throw new SemanticsUndefinedException("merge is undefined in ObjetTypeImpl.java");
		return this;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		          throw new SemanticsUndefinedException("length is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new String("Objet " + identificateur);
	}
}
