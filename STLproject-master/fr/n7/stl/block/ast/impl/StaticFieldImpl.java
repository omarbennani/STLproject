/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.StaticField;
import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer access expression.
 * @author Marc Pantel
 *
 */
public class StaticFieldImpl implements StaticField {

	protected String identificateur ;
	protected Boolean _final;
	protected Type type;
	protected Expression expression;

	public StaticFieldImpl(){}
	
	public StaticFieldImpl(Type _type, String _identificateur, Expression _expression)
	{
		this.identificateur = _identificateur;
		this.type = _type;
		this.expression = _expression;
	}

	@Override
	public String getName()
	{
		return this.identificateur;
	}

	@Override
	public String toString()
	{
		if (this._final)
			return new String("final static " +this.type.toString() + " "+ this.identificateur+"; \n");
		else
			return new String("static " +this.type.toString() + " "+ this.identificateur+"; \n");
	}

	@Override
	public void setFinal(boolean b)
	{
		this._final = b;
	}

	@Override
	public boolean isFinal()
	{
		return this._final;
	}

	public Type getType()
	{
		return this.type;
	}
	
	@Override
	public String getInterfaceName() {
		InterfaceTypeImpl iType = (InterfaceTypeImpl)this.type;
		return iType.getInterface().getName();
	}

}
