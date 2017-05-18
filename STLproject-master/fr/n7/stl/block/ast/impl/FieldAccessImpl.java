/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.BlockFactory;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing a field in a record.
 * @author Marc Pantel
 *
 */
public class FieldAccessImpl implements Expression {

	protected Expression record;
	protected String name;
	protected FieldDeclaration field;

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _name Name of the field in the record field access expression.
	 */
	public FieldAccessImpl(Expression _record, String _name) {
		this.record = _record;
		this.name = _name;
	}

	/**
	 * Construction for the implementation of a record field access expression Abstract Syntax Tree node.
	 * @param _record Abstract Syntax Tree for the record part in a record field access expression.
	 * @param _field Abstract Syntax Tree for the field declaration in a record field access expression.
	 */
	public FieldAccessImpl(Expression _record, FieldDeclaration _field) {
		this.record = _record;
		this.field = _field;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.record + "." + this.name;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type recordType = this.record.getType();
		if (recordType instanceof RecordTypeImpl) {
            if (this.field == null) {
                BlockFactory factory = new BlockFactoryImpl();
                this.field = factory.createFieldDeclaration(name, ((RecordTypeImpl)recordType).get(name).get().getType());
            }
            return this.field.getType();
		} else {
			System.err.println(this.record.toString() + " n'est pas un enregistrement.");
			return AtomicType.ErrorType;
		}
	}

	@Override
	public Type getTypeReel() 
	{
		return this.getType();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		int position = 0;
		Expression e = this;
		while (e instanceof FieldAccessImpl) {
			for (FieldDeclaration f: ((RecordTypeImpl)((FieldAccessImpl)e).record.getType()).getFields()) {
				if (f.getName().equals(((FieldAccessImpl)e).field.getName())) {
					break;
				} else {
					position += f.getType().length();
				}
			}
			e = ((FieldAccessImpl)e).record;
		}
		_code.add(_factory.createLoad(((VariableUseImpl)e).declaration.getRegister(),
									  ((VariableUseImpl)e).declaration.getOffset() + position,
									   this.field.getType().length()));
		return _code;
	}

}
