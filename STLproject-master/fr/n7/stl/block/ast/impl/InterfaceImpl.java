/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.Interface;
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
public class InterfaceImpl implements Interface {

	protected String identificateurType ;
	protected LinkedList<Interface> heritageInterface;
	protected LinkedList<ElementInterface> elements;

	public InterfaceImpl(){}
	public InterfaceImpl(String _identificateurType, LinkedList<Interface> _heritageInterface, LinkedList<ElementInterface> _elements)
	{
		this.identificateurType = _identificateurType;
		this.heritageInterface = _heritageInterface;
		this.elements = _elements;
	}

	@Override
	public String getName()
	{
		return this.identificateurType;
	}

	@Override
	public Type getType()
	{
		return new InterfaceTypeImpl(this);
	}	

	@Override
	public String toString()
	{
		Iterator<Interface> itr = this.heritageInterface.iterator();
		String heritages = new String();
    		while (itr.hasNext())
    		{
      			if(heritages.length() == 0)
				heritages += " extends " + (itr.next()).getName();
			else
				heritages += ", "+ (itr.next()).getName();
    		}

		String elts = new String();
		Iterator<ElementInterface> itr1 = this.elements.iterator();
    		while (itr1.hasNext())
    		{
				elts += (itr1.next()).toString()+"\n";
    		}


		return new String("interface " + this.identificateurType + heritages +"{\n"+elts+"} \n");
	}

}
