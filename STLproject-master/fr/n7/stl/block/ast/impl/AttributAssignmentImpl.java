/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class AttributAssignmentImpl extends AttributUseImpl implements Assignable {

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the assigned variable.
	 */
	public AttributAssignmentImpl(ElementClasse _declaration, Expression _expression) {
		super(_declaration);
		this.exp = _expression;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		int position = 0;
		Expression e = this;
		while (e instanceof AttributAssignmentImpl) {
			for (Attribut a: ((ClassTypeImpl)((AttributAssignmentImpl)e).exp.getType()).getClasse().getAttributs()) {
				if (a.getName().equals(((AttributAssignmentImpl)e).declaration.getName())) {
					break;
				} else {
					position += a.getType().length();
				}
			}
			e = ((AttributAssignmentImpl)e).exp;
		}
		_code.add(_factory.createLoadA(((VariableUseImpl)e).declaration.getRegister(),
									   ((VariableUseImpl)e).declaration.getOffset() + position));
		return _code;
	}
}
