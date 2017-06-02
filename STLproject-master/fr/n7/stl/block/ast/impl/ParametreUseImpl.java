/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a parameter use expression.
 *
 */
public class ParametreUseImpl implements Expression {

	protected Parametre parametre;
	
	/**
	 * Creates a parameter use expression Abstract Syntax Tree node.
	 * @param _parametre Declaration of the parameter used.
	 */
	public ParametreUseImpl(Parametre _parametre) {
		this.parametre = _parametre;
	}


	public Parametre getParametre() {
		return this.parametre;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return ("@{" + this.parametre.getName() + "}");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return parametre.getType();
	}

	@Override
	public Type getTypeReel() {
		return this.parametre.getType();
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		if (this.parametre.getType() instanceof ClassTypeImpl) {
			_code.add(_factory.createLoad(this.parametre.getRegister(),
					this.parametre.getOffset(),
					1));
		}
		else {
			_code.add(_factory.createLoad(this.parametre.getRegister(),
					this.parametre.getOffset(),
					this.parametre.getType().length()));
		}
		return _code;
	}
}
