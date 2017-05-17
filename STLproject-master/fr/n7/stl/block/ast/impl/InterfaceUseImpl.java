/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
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
public class InterfaceUseImpl implements Expression {

	protected Interface interface_;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public InterfaceUseImpl(Interface _interface_) {
		this.interface_ = _interface_;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
			return ("@{" + this.interface_.getName() + "}");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
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
