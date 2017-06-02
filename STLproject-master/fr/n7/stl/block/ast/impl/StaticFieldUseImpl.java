/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class StaticFieldUseImpl implements Expression {

	protected Declaration declaration;
	protected Expression exp;
	
	protected Type typeReel;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public StaticFieldUseImpl(Declaration _declaration) {
		this.declaration = _declaration;
	}
	
	public StaticFieldUseImpl(Declaration _declaration, Expression _exp) {
		this.declaration = _declaration;
		this.exp = _exp;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (exp == null)
			return ("@{" + this.declaration.getName() + "}");
		else
			return exp.toString()+"."+this.declaration.getName();
		
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		StaticFieldImpl stf = null;
		if (this.declaration instanceof StaticFieldImpl)
			stf = (StaticFieldImpl) this.declaration;
		return stf.getType();
		//throw new SemanticsUndefinedException("getType is undefined in StaticFieldUseImpl");
	}
	
	public Type getTypeReel() {
		return this.typeReel;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		/*Fragment _code = _factory.createFragment();
		_code.add(_factory.createLoad(this.declaration.getRegister(),
				this.declaration.getOffset(),
				this.declaration.getType().length()));
		return _code;*/

		throw new SemanticsUndefinedException("getCode is undefined in AttributUseImpl");
	}

}
