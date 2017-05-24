package fr.n7.stl.block.ast.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ClasseImpl implements Classe
{
	protected String name;
	protected Classe heritageClasse;
	protected LinkedList<Interface> implantationInterface;
	protected LinkedList<ElementClasse> elementsClasse;
	protected Register register;
	protected int offset;

	public ClasseImpl(String _name, Classe _heritageClasse, LinkedList<Interface> _implantationInterface, LinkedList<ElementClasse> _elementsClasse)
	{
		this.name = _name;
		this.heritageClasse = _heritageClasse;
		this.implantationInterface = _implantationInterface;
		this.elementsClasse = _elementsClasse;
	}

	@Override
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public Attribut getAttribut(String name) {
		for (ElementClasse e : this.elementsClasse) {
			if (e instanceof Attribut) {
				if (e.getName().equals(name))
					return (Attribut)e;
			}
		}
		throw new AttributUndefinedException("L'attribut " + name + " n'existe pas dans la classe " + this.name);
	}
	
	@Override
	public List<Methode> getMethodes() {
		List<Methode> methodes = new LinkedList<Methode>();
		for (ElementClasse e : this.elementsClasse) {
			if (e instanceof Methode)
				methodes.add((Methode)e);
		}
		return methodes;
	}
	
	@Override
	public List<Attribut> getAttributs() {
		List<Attribut> attributs = new LinkedList<Attribut>();
		for (ElementClasse e : this.elementsClasse) {
			if (e instanceof Attribut)
				attributs.add((Attribut)e);
		}
		return attributs;
	}
	
	@Override
	public Type getType()
	{
		return new ClassTypeImpl(this);
	}
	
	@Override
	public boolean checkType() {
		boolean result = true;
		Set<Signature> methodesAImplementer = new HashSet<Signature>(); 
		if (this.implantationInterface.size() > 0) {
			for (Interface i : this.implantationInterface) {
				methodesAImplementer.addAll(i.getAllSignatures());
			}
		}
		for(Signature s : methodesAImplementer) {
			boolean signatureImplementee = false;
			for (Methode m : this.getMethodes()) {
				if (m.signatureEquals(s))
					signatureImplementee = true;
					break;
			}
			if (!signatureImplementee)
				return false;
		}
		for (Methode m : this.getMethodes()) {
			result = result && m.checkType();
		}
		return result;
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

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		for (ElementClasse e:this.elementsClasse)
			_code.append(e.getCode(_factory));
		return _code;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = _offset;
        for (ElementClasse ec : this.elementsClasse) {
            _local += ec.allocateMemory(_register, _local);
        }
        this.offset = _local - _offset;
        this.register = _register;
		return _local;
	}
	
}
