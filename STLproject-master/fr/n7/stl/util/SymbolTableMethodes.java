/**
 * 
 */
package fr.n7.stl.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.ForbiddenDeclarationException;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.impl.Constructeur;
import fr.n7.stl.block.ast.impl.Methode;

/**
 * @author pantel2
 *
 */
public class SymbolTableMethodes  {
	
	private List<Methode> methodes;
	private List<Signature> signatures;
	private List<Constructeur> constructeurs;
	
	public SymbolTableMethodes() {
		this.methodes = new LinkedList<Methode>();
		this.signatures = new LinkedList<Signature>();
		this.constructeurs = new LinkedList<Constructeur>();
	}

	public boolean containsMethode(String _name, String _nomClasse, List<Parametre> _parametres) 
	{
		for(Methode m : this.methodes)
		{
			if (m.getClassName().equals(_nomClasse) && m.getName().equals(_name))
			{
				List<Parametre> p = m.getParametres();
				if(p.size() == _parametres.size())
				{
					for(int i = 0; i< p.size(); i++)
					{
						if(!p.get(i).getType().equals(_parametres.get(i).getType()))
							break;
						if(i == p.size()-1)
							return true;
					}
				}
			}
		}

		return false;
	}

	public boolean containsSignature(String _name, String _nomInterface, List<Parametre> _parametres) {
		for(Signature s : this.signatures)
		{
			if (s.getName().equals(_name))
			{
				if (s.getInterfaceName().equals(_nomInterface)) {
				List<Parametre> p = s.getParametres();
				if(p.size() == _parametres.size())
				{

					for(int i = 0; i< p.size(); i++)
					{
						if(!p.get(i).getType().equals(_parametres.get(i).getType()))
							break;
						if(i == p.size()-1)
							return true;
					}
				}}
			}
		}
		return false;
	}
	
	public boolean containsConstructeur(String _name, List<Parametre> _parametres) 
	{
		for(Constructeur c : this.constructeurs)
		{
			if (c.getClassName().equals(_name) && c.getName().equals(_name))
			{
				List<Parametre> p = c.getParametres();
				if(p.size() == _parametres.size())
				{
					for(int i = 0; i< p.size(); i++)
					{
						if(!p.get(i).getType().equals(_parametres.get(i).getType()))
							break;
						if(i == p.size()-1)
							return true;
					}
				}
			}
		}

		return false;
	}
	
	public Optional<Methode> getMethode(String _name, String _nomClasse, Arguments _arguments) {

		System.out.println("get " +_nomClasse + "." + _name);
		List<Methode> resultat  = new LinkedList<Methode>();
		for(Methode m : this.methodes)
		{
			if (m.getClassName().equals(_nomClasse) && m.getName().equals(_name))
			{
				List<Parametre> p = m.getParametres();
				List<Type> t = _arguments.getListType();
				if(p.size() == t.size())
				{
					if (p.size() == 0) {
						resultat.add(m);
					} else {
						for(int i = 0; i< p.size(); i++)
						{
							if(!p.get(i).getType().compatibleWith(t.get(i)))
								break;
							if(i == p.size()-1)
								resultat.add(m);
						}
					}
				}
			}
		}
	
		if(resultat.size() == 1)
		{
			System.out.println("getMethode " + _name + " OK");
			return Optional.of(resultat.get(0));
		}
		else if (resultat.size() == 0)
		{
			System.out.println("getMethode " + _name + " PAS OK 0");
			return Optional.empty();
		}
		else
		{
			System.out.println("Appel à la methode " + _nomClasse + "." + _name + " ambigu");
			return Optional.empty();
		}

	}
	public Optional<Signature> getSignature(String _name, String _nomInterface, Arguments _arguments) {

		System.out.println("get " +_nomInterface + "." + _name);
		List<Signature> resultat  = new LinkedList<Signature>();
		for(Signature s : this.signatures)
		{
			if (s.getInterfaceName().equals(_nomInterface) && s.getName().equals(_name))
			{
				List<Parametre> p = s.getParametres();
				List<Type> t = _arguments.getListType();
				if(p.size() == t.size())
				{
					if (p.size() == 0) {
						resultat.add(s);
					} else {
						for(int i = 0; i< p.size(); i++)
						{
							if(!p.get(i).getType().compatibleWith(t.get(i)))
								break;
							if(i == p.size()-1)
								resultat.add(s);
						}
					}
				}
			}
		}
	
		if(resultat.size() == 1)
		{
			return Optional.of(resultat.get(0));
		}
		else if (resultat.size() == 0)
		{
			return Optional.empty();
		}
		else
		{
			System.out.println("Appel à la methode " + _nomInterface + "." + _name + " ambigu");
			return Optional.empty();
		}

	}
	
	public Optional<Constructeur> getConstructeur(String _name, Arguments _arguments) {

		System.out.println("get " +_name + "." + _name);
		List<Constructeur> resultat  = new LinkedList<Constructeur>();
		for(Constructeur c : this.constructeurs)
		{
			if (c.getClassName().equals(_name) && c.getName().equals(_name))
			{
				List<Parametre> p = c.getParametres();
				List<Type> t = _arguments.getListType();
				if(p.size() == t.size())
				{
					if (p.size() == 0) {
						resultat.add(c);
					} else {
						for(int i = 0; i< p.size(); i++)
						{
							if(!p.get(i).getType().compatibleWith(t.get(i)))
								break;
							if(i == p.size()-1)
								resultat.add(c);
						}
					}
				}
			}
		}
	
		if(resultat.size() == 1)
		{
			return Optional.of(resultat.get(0));
		}
		else if (resultat.size() == 0)
		{
			return Optional.empty();
		}
		else
		{
			System.out.println("Appel à la methode " + _name + "." + _name + " ambigu");
			return Optional.empty();
		}

	}


	public boolean acceptsMethode(String _name, String _nomClasse, List<Parametre> _parametres) {
		// System.out.println("Accepts( " + _declaration.getName() + " )");
		return (!this.containsMethode(_name, _nomClasse, _parametres));
	}
	
	public boolean acceptsSignature(String _name, String _nomInterface, List<Parametre> _parametres) {
		// System.out.println("Accepts( " + _declaration.getName() + " )");
		return (!this.containsSignature(_name, _nomInterface, _parametres));
	}
	
	public boolean acceptsConstructeur(String _name, List<Parametre> _parametres) {
		// System.out.println("Accepts( " + _declaration.getName() + " )");
		return (!this.containsConstructeur(_name, _parametres));
	}


	public void registerMethode(String _name, String _nomClasse, List<Parametre> _parametres, Methode _methode) throws ForbiddenDeclarationException {
		 System.out.println("Register( " + _nomClasse + "."+ _name + " )");
		if (this.acceptsMethode(_name, _nomClasse, _parametres)) {
			this.methodes.add(_methode);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}
	
	public void registerSignature(String _name, String _nomInterface, List<Parametre> _parametres, Signature _signature) throws ForbiddenDeclarationException {
		 System.out.println("Register( " + _nomInterface + "."+ _name + " )");
		if (this.acceptsSignature(_name, _nomInterface, _parametres)) {
			this.signatures.add(_signature);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}
	
	public void registerConstructeur(String _name, List<Parametre> _parametres, Constructeur _constructeur) throws ForbiddenDeclarationException {
		 System.out.println("Register( " + _name + "."+ _name + " )");
		if (this.acceptsConstructeur(_name, _parametres)) {
			this.constructeurs.add(_constructeur);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}

	public void setClasseConstructeur(SymbolTable stClasse) {
		for (Constructeur c : this.constructeurs) {
			Optional<Declaration> ocl = stClasse.get(c.getName());
			Classe cl = (Classe)ocl.get();
			c.setClasse(cl);
		}
	}
}
