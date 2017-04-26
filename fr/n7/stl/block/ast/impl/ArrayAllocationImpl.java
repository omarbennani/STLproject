package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer access expression.
 * @author Marc Pantel
 *
 */
public class ArrayAllocationImpl implements Expression {

	protected Expression arraySize;
    protected Type type;
	
	public ArrayAllocationImpl(Expression _array, Type _type) {
        this.arraySize = _array;
        this.type = _type;
        if (!_array.getType().compatibleWith(AtomicType.IntegerType)) {
            System.err.println("La taille du tableau doit être de type entier. Ici, la taille du talbeau est : " + _array);
        }
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "new " + this.type + "[" + this.arraySize + "]";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return new ArrayTypeImpl(type);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = this.arraySize.getCode(_factory);
		_code.add(_factory.createLoadL(this.type.length()));
		_code.add(Library.IMul);
		_code.add(Library.MAlloc);
		return _code;
	}

}
