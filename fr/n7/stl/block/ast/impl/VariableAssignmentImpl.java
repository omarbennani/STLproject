/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class VariableAssignmentImpl extends VariableUseImpl implements Assignable {

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the assigned variable.
	 */
	public VariableAssignmentImpl(VariableDeclaration _declaration) {
		super(_declaration);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		if (this.declaration.getType() instanceof ArrayTypeImpl || this.declaration.getType() instanceof PointerTypeImpl) {
			_code.add(_factory.createLoad(this.declaration.getRegister(), this.declaration.getOffset(), 1));
		} else {
			_code.add(_factory.createLoadA(this.declaration.getRegister(), this.declaration.getOffset()));
		}
		return _code;
	}

}
