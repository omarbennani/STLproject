/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class VariableUseImpl implements Expression {

	protected String ident;
	protected VariableDeclaration declaration;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public VariableUseImpl(VariableDeclaration _declaration) {
		this.declaration = _declaration;
	}

	public VariableUseImpl(String _ident) {
		this.ident = _ident;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.declaration != null)
			return ("@{" + this.declaration.getName() + "}");
		else
			return ("@{" + this.ident + "}"+"warning not a declaration"); 
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return declaration.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.add(_factory.createLoad(this.declaration.getRegister(),
				this.declaration.getOffset(),
				this.declaration.getType().length()));
		return _code;
	}


	@Override
	public Type getTypeReel() 
	{
		return this.declaration.getTypeReel();
	}
}
