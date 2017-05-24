/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class InterfaceUseImpl implements ObjetUse {

	protected Interface interface_;
	protected LinkedList<ObjetUse> instanceGenericite;

	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public InterfaceUseImpl(Interface _interface_) {
		this.interface_ = _interface_;
	}

	public InterfaceUseImpl(Interface _interface_, LinkedList<ObjetUse> _instanceGenericite) {
		this.interface_ = _interface_;
		this.instanceGenericite = _instanceGenericite;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
			if (this.instanceGenericite == null)
				return ("@{" + this.interface_.getName() + "}");
			else
			{
				String result = "@{" + this.interface_.getName()+"<";
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
		return this.interface_;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return interface_.getType();
	}
	
	@Override
	public Type getTypeReel() {
		return interface_.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode is not defined in InterfaceUseImpl");
	}

}
