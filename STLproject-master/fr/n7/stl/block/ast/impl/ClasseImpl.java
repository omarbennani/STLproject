package fr.n7.stl.block.ast.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;

public class ClasseImpl implements Classe
{
	protected String name;
	protected Classe heritageClasse;
	protected LinkedList<Interface> implantationInterface;
	protected LinkedList<ElementClasse> elementsClasse;

	public ClasseImpl(String _name, Classe _heritageClasse, LinkedList<Interface> _implantationInterface, LinkedList<ElementClasse> _elementsClasse)
	{
		this.name = _name;
		this.heritageClasse = _heritageClasse;
		this.implantationInterface = _implantationInterface;
		this.elementsClasse = _elementsClasse;
	}

	public String getName()
	{
		return this.name;
	}
	
	public Attribut getAttribut(String name) {
		for (ElementClasse e : this.elementsClasse) {
			if (e instanceof Attribut) {
				if (e.getName().equals(name))
					return (Attribut)e;
			}
		}
		throw new AttributUndefinedException("L'attribut " + name + " n'existe pas dans la classe " + this.name);
	}
	
	public List<Methode> getMethodes() {
		List<Methode> methodes = new LinkedList<Methode>();
		for (ElementClasse e : this.elementsClasse) {
			if (e instanceof Methode)
				methodes.add((Methode)e);
		}
		return methodes;
	}
	
	@Override
	public Type getType()
	{
		return new ClassTypeImpl(this);
	}
	
	public boolean checkType() {
		Set<Signature> methodesAImplementer = new HashSet<Signature>(); 
		if (this.implantationInterface.size() > 0) {
			for (Interface i : this.implantationInterface) {
				methodesAImplementer.addAll(i.getAllSignatures());
			}
		}
		for(Signature s : methodesAImplementer) {
			for (Methode m : this.getMethodes()) {
				
			}
		}
	}
	
	@Override
	public String toString()
	{
		String local = "class " + this.name+ " ";
		if (this.heritageClasse != null)
		{
			local += "extends ";
			this.heritageClasse.getName();
		}

		if (this.implantationInterface.size() > 0)
		{
			local += "implements ";
			Interface i;
			Iterator<Interface> itr = this.implantationInterface.iterator();
			while(itr.hasNext())
			{
				i = (Interface) itr.next();
				local+=" " + i.getName() +",";
			}
			local+="\n";
		}

		local += "{";

		if (this.elementsClasse.size() >0)
		{
			ElementClasse e;
			Iterator<ElementClasse> itr = this.elementsClasse.iterator();
			while(itr.hasNext())
			{
				e = (ElementClasse) itr.next();
				local+=" " + e.toString() +";\n";
			}
			local+="\n";
		}

		local += "}";

		return local;
	}
	
}
