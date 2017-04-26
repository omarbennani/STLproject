/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for accessing an array element.
 * @author Marc Pantel
 *
 */
public class ArrayAccessImpl implements Expression {

	protected Expression array;
	protected Expression index;

	/**
	 * Construction for the implementation of an array element access expression Abstract Syntax Tree node.
	 * @param _array Abstract Syntax Tree for the array part in an array element access expression.
	 * @param _index Abstract Syntax Tree for the index part in an array element access expression.
	 */
	public ArrayAccessImpl(Expression _array, Expression _index) {
		this.array = _array;
		this.index = _index;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return (this.array + "[ " + this.index + " ]");
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		Type tab = this.array.getType();
		Type idx = this.index.getType();
		if (!idx.equalsTo(AtomicType.IntegerType)) {
			System.err.println("L'index doit être un entier");
			return AtomicType.ErrorType;
		} else {
			if (tab instanceof ArrayTypeImpl) {
				return ((ArrayTypeImpl) tab).getType();
			} else {
				System.err.println("Vous devez fournir un tableau");
				return AtomicType.ErrorType;
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.append(this.array.getCode(_factory));
		_code.append(this.index.getCode(_factory));
		_code.add(_factory.createLoadL(this.getType().length()));
		_code.add(Library.IMul);
		_code.add(Library.IAdd);
		_code.add(_factory.createLoadI(this.getType().length()));
		return _code;
	}

}
