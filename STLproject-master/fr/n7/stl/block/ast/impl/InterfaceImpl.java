/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.ParametreGenericite;
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
	protected LinkedList<ObjetUse> heritageInterface;
	protected LinkedList<ElementInterface> elements;
	protected LinkedList<ParametreGenericite> genericite;

	public InterfaceImpl(){}
	public InterfaceImpl(String _identificateurType,LinkedList<ParametreGenericite> _genericite, LinkedList<ObjetUse> _heritageInterface, LinkedList<ElementInterface> _elements)
	{
		this.identificateurType = _identificateurType;
		this.heritageInterface = _heritageInterface;
		this.genericite = _genericite;
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
		/*Set<Signature> signatures = this.getSignatures();
		for (Interface i : this.heritageInterface) {
			signatures.addAll(i.getAllSignatures());
		}
		return signatures;*/
		throw new SemanticsUndefinedException(" method getAllSignaturesgetAllSignatures is not defined in InterfaceImpl.java  ");
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
		String result = "interface "+ this.identificateurType + " ";
		
		//LinkedList<ParametreGenericite> genericite
		if(this.genericite != null)
		{
			result +="<";
			for(ParametreGenericite p : this.genericite)
			{
				result+= p .toString()+",";
			}
			result +="> ";
		}

		Iterator<ObjetUse> itr = this.heritageInterface.iterator();
		String heritages = new String();
    		while (itr.hasNext())
    		{
      			if(heritages.length() == 0)
				heritages += " extends " + (itr.next()).toString();
			else
				heritages += ", "+ (itr.next()).toString();
    		}

		String elts = new String();
		Iterator<ElementInterface> itr1 = this.elements.iterator();
    		while (itr1.hasNext())
    		{
				elts += (itr1.next()).toString()+"\n";
    		}


		return new String(result + heritages +"{\n"+elts+"} \n");
	}
	@Override
	public Fragment getCode(TAMFactory _factory) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean checkType() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public int allocateMemory(Register _register, int _offset) {
		// TODO Auto-generated method stub
		return 0;
	}

}
