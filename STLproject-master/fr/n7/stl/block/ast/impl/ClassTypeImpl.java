/**
 * 
 */
package fr.n7.stl.block.ast.impl;


import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.AtomicType;
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
		return this.classe;}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
           throw new SemanticsUndefinedException("equalsTo is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		throw new SemanticsUndefinedException("equalsTo is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
	               throw new SemanticsUndefinedException("equalsTo is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		           throw new SemanticsUndefinedException("equalsTo is undefined in ObjetTypeImpl.java");
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new String( this.classe.getName());
	}
}
