/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.ObjetDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.VariableDeclaration;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable declaration instruction.
 * @author Marc Pantel
 *
 */
public class ObjetDeclarationImpl implements ObjetDeclaration {

	protected Type type;
	protected Arguments args;
	
	/**
	 * Creates a variable declaration instruction node for the Abstract Syntax Tree.
	 * @param _name Name of the declared variable.
	 * @param _type Type of the declared variable.
	 * @param _value Value of the declared variable.
	 */
	public ObjetDeclarationImpl(Type _type, Arguments _args) 
	{
		this.type = _type;
		this.args = _args;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() 
	{
	return "new " +this.type  + this.args ;
	}

	/*@Override
	public String getName() {
		return "Object" + this.type;
	}*/

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		throw new SemanticsUndefinedException("getCode() not defined in ExpressionsImpl");
	}

}
