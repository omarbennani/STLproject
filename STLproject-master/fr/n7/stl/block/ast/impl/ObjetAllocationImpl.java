/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable declaration instruction.
 * @author Marc Pantel
 *
 */
public class ObjetAllocationImpl implements Expression {
	
	protected Type type;
	protected Arguments arguments;
	
	public ObjetAllocationImpl(Type _type, Arguments _args) {
        this.type = _type;
        this.arguments = _args;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "new " + this.type + this.arguments;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}
	
	@Override
	public Type getTypeReel() {
		return this.type;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
//		throw new SemanticsUndefinedException("getCode() not defined in ObjetAllocationImpl");
		Fragment _code = _factory.createFragment();
		_code.append(this.arguments.getCode(_factory));
		//_code.add(_factory.createJump(this));
		_code.add(_factory.createLoadL(this.type.length()));
		_code.add(Library.MAlloc);
		return _code;
	}
}
