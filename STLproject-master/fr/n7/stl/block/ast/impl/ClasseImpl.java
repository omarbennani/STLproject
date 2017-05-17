package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Interface;

public class ClasseImpl implements Classe
{
	protected String name;
	protected LinkedList<Classe> heritageClasse;
	protected LinkedList<Interface> implantationInterface;
	protected LinkedList<ElementClasse> elementsClasse;

	public ClasseImpl(String _name, LinkedList<Classe> _heritageClasse, LinkedList<Interface> _implantationInterface, LinkedList<ElementClasse> _elementsClasse)
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
	
	@Override
	public Type getType()
	{
		return new ClassTypeImpl(this);
	}	
	
	@Override
	public String toString()
	{
		String local = "class " + this.name+ " ";
		if (this.heritageClasse.size() >0)
		{
			local += "extends ";
			Classe c;
			Iterator<Classe> itr = this.heritageClasse.iterator();
			while(itr.hasNext())
			{
				c = (Classe) itr.next();
				local+=" " + c.getName() +",";
			}
			local+="\n";
		}

		if (this.implantationInterface.size() >0)
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
