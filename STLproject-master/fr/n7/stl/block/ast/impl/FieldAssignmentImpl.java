/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Collections;
import java.util.List;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class FieldAssignmentImpl extends FieldAccessImpl implements Assignable {

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _name Name of the field in the record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, String _name) {
		super(_record, _name);
	}

	/**
	 * Construction for the implementation of a record field assignment expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field assignment expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field assignment expression.
	 */
	public FieldAssignmentImpl(Expression _record, FieldDeclaration _field) {
		super(_record, _field);
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.FieldAccessImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		int position = 0;
		Expression e = this;
		while (e instanceof FieldAssignmentImpl) {
			for (FieldDeclaration f: ((RecordTypeImpl)((FieldAssignmentImpl)e).record.getType()).getFields()) {
				if (f.getName().equals(((FieldAssignmentImpl)e).field.getName())) {
					break;
				} else {
					position += f.getType().length();
				}
			}
			e = ((FieldAssignmentImpl)e).record;
		}
		_code.add(_factory.createLoadA(((VariableAssignmentImpl)e).declaration.getRegister(),
									   ((VariableAssignmentImpl)e).declaration.getOffset() + position));
		return _code;
	}
	
}
