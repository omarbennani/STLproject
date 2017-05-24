/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

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
	
	public Set<Signature> getAllSignatures() {
		Set<Signature> signatures = this.getSignatures();
		for (Interface i : this.heritageInterface) {
			signatures.addAll(i.getAllSignatures());
		}
		return signatures;
	}
	
	public Set<Signature> getSignatures() {
		Set<Signature> signatures = new HashSet<Signature>();
		for (ElementInterface e : this.elements) {
			if (e instanceof Signature)
				signatures.add((Signature)e);				
		}
		return signatures;
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
	@Override
	public Fragment getCode(TAMFactory _factory) {
		return _factory.createFragment();
	}
	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int allocateMemory(Register _register, int _offset) {
		return 0;
	}

}
