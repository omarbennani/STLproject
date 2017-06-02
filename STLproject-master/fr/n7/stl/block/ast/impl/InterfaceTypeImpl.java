/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer type.
 * @author Marc Pantel
 *
 */
public class InterfaceTypeImpl implements Type {

	private Interface interface_;
	private LinkedList<ObjetUse> instanceGenericite;

	public InterfaceTypeImpl(Interface _interface_) {
		this.interface_= _interface_;
	}

	public InterfaceTypeImpl(Interface _interface_, LinkedList<ObjetUse> _instanceGenericite) {
		this.interface_= _interface_;
		this.instanceGenericite = _instanceGenericite;
	}
	
	public Type getType() {
		return this;
	}

	public Interface getInterface() {
		return this.interface_;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
		if (_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl _type = (InterfaceTypeImpl) _other;
			return this.interface_.getName().equals(_type.interface_.getName());
		} else {
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		if(_other instanceof InterfaceTypeImpl) {
			InterfaceTypeImpl  _type = (InterfaceTypeImpl) _other;
			Interface _interface = _type.getInterface();
			if(this.interface_.equals(_interface) || this.interface_.etends(_interface))
				return true;
		}
		return false;
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
		return 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//return this.interface_.getName();

		String resultat = this.interface_.getName() +" ";
		if(this.instanceGenericite != null) {
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
