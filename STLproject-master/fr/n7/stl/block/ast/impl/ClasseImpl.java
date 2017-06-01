package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.ObjetUse;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.ParametreGenericite;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class ClasseImpl implements Classe
{
	protected String name;
	protected ObjetUse heritageClasse;
	protected LinkedList<ParametreGenericite> genericite;
	protected LinkedList<ObjetUse> implantationInterface;
	protected LinkedList<ElementClasse> elementsClasse;
	protected Register register;
	protected int offset;


	public ClasseImpl(String _name, LinkedList<ParametreGenericite> _genericite, ObjetUse _heritageClasse, LinkedList<ObjetUse> _implantationInterface, LinkedList<ElementClasse> _elementsClasse)
	{
		this.name = _name;
		this.heritageClasse = _heritageClasse;
		this.genericite = _genericite;
		this.implantationInterface = _implantationInterface;
		this.elementsClasse = _elementsClasse;
	}

	public String getName()
	{
		return this.name;
	}
	
	@Override
	public List<Methode> updateMethodes() {
		List<Methode> methodes = new LinkedList<Methode>();
		List<Methode> methodesMeres = this.getMethodesMeres();
		for (Methode m : methodesMeres) {
			Methode _m = new Methode(m.droitAcces, m.typeRet, m.getParametres(), m.getName(), m.exp, this.name);
			_m.setThis(new ParametreImpl("this"));
			_m.setClasse(this);
			if (!this.containsMethode(_m)) {
				elementsClasse.add(_m);
				methodes.add(_m);
			}
		}
		return methodes;
	}
	
	@Override
	public List<Attribut> updateAttributs() {
		List<Attribut> attributs = new LinkedList<Attribut>();
		List<Attribut> attributsParents = this.getAttributsParents();
		for (Attribut a : attributsParents) {
			Attribut _a = new Attribut(a.droitAcces, a.getType(), a.getName());
			_a.setClasse(this);
			if (!this.containsAttribut(_a.getName())) {
				System.out.println("UPDATE ATTRIBUT " + _a.getName());
				elementsClasse.add(_a);
				attributs.add(_a);
			}
		}
		return attributs;
	}
	
	public boolean containsMethode(Methode _methode) {
		for (Methode m : this.getMethodes()) {
			if (m.getName().equals(_methode.getName())) {
				if (m.getType().equals(_methode.getType())) {
					List<Parametre> paramsM1 = m.getParametres();
					int size = paramsM1.size();
					List<Parametre> paramsM2 = _methode.getParametres();
					if (size == paramsM2.size()) {
						if (size == 0) {
							return true;
						}
						for (int i = 0; i < size; i++) {
							if (paramsM1.get(i).getType().equals(paramsM2.get(i).getType())) {
								if (i == size - 1) {
									return true;
								}
							} else {
								break;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public boolean containsAttribut(String _name) {
		for (Attribut a : this.getAttributs()) {
			if (a.getName().equals(_name)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void setClasseElementsClasse() {
		for (ElementClasse e : this.elementsClasse)
			e.setClasse(this);
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
	public List<Methode> getAllMethodes() {
		List<Methode> methodes = new LinkedList<Methode>(this.getMethodes());
		if (this.heritageClasse != null) {
			Classe c = ((ClasseUseImpl)this.heritageClasse).classe;
			
			methodes.addAll(c.getAllMethodes());
		}
		return methodes;
	}
	
	@Override
	public List<Methode> getMethodesMeres() {
		List<Methode> methodesMeres = new LinkedList<Methode>();
		for (Methode m : this.getAllMethodes()) {
			if (!m.getClassName().equals(this.name)) {
				if (m.droitAcces != DroitAcces.prive) {
					methodesMeres.add(m);
				}
			}
		}
		return methodesMeres;
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
		boolean result = true;

		for(ElementClasse e : elementsClasse)
		{
			if(e instanceof Methode)
			{
				Methode m = (Methode) e;
				result = result && m.checkType();
			}

		} 

		/*Set<Signature> methodesAImplementer = new HashSet<Signature>(); 
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
		}*/
		return result;
	}
	
	@Override
	public String toString()
	{
		String local = "class " + this.name+ " ";

		//LinkedList<ParametreGenericite> genericite
		if(this.genericite != null)
		{
			local +="<";
			for(ParametreGenericite p : this.genericite)
			{
				local+= p .toString()+",";
			}
			local +="> ";
		}

		if (this.heritageClasse != null)
		{
			local += "extends " + this.heritageClasse.toString() + " ";
		}

		if (this.implantationInterface.size() > 0)
		{
			local += "implements ";
			ObjetUse i;
			Iterator<ObjetUse> itr = this.implantationInterface.iterator();
			while(itr.hasNext())
			{
				i = (ObjetUse) itr.next();
				local+=" " + i.toString() +",";
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
	public Register getRegister() {
		return this.register;
	}
	
	@Override
	public int getOffset() {
		return this.offset;
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		for (Methode m : this.getMethodes())
			_code.append(m.getCode(_factory));
		return _code;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = 0;
        for (Attribut as : this.getAttributsStatiques()) {
            _local += as.allocateMemory(_register, _local);
        }
        this.offset = _offset;
        this.register = _register;
		return this.getTailleAttributsStatiques();
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
	public List<Attribut> getAllAttributs() {
		List<Attribut> attributs = new LinkedList<Attribut>(this.getAttributs());
		if (this.heritageClasse != null) {
			Classe c = ((ClasseUseImpl)this.heritageClasse).classe;
			attributs.addAll(c.getAllAttributs());
		}
		return attributs;
	}
	
	@Override
	public List<Attribut> getAttributsParents() {
		List<Attribut> attributsParents = new LinkedList<Attribut>();
		for (Attribut a : this.getAllAttributs()) {
			if (!a.getClassName().equals(this.name)) {
				if (a.droitAcces != DroitAcces.prive) {
					attributsParents.add(a);
				}
			}
		}
		return attributsParents;
	}

	@Override
	public List<Constructeur> getConstructeurs() 
	{
		List<Constructeur> constructeurs = new LinkedList<Constructeur>();
		for (ElementClasse e : this.elementsClasse) {
			if (e instanceof Constructeur)
				constructeurs.add((Constructeur)e);
		}
		return constructeurs;
	}

	public boolean equals(Classe _classe)
	{
		boolean result = true;
		result = result && (this.name.equals(_classe.getName()));
		/*ClasseImpl c = (ClasseImpl) _classe;
		//VERIFICATION QUE LES DEUX CLASSES ONT LES MEME ATTRIBUTS GENERIQUES
		ArrayList<ParametreGenericite> arraylist = new ArrayList<>(c.getGenericite());
		for(ParametreGenericite pg : genericite)
		{
			result = result && arraylist.contains(pg);
		}
		//VERIFICATION QUE LES DEUX CLASSES IMPLANTENT LES MEMES INTERFACES
		ArrayList<ObjetUse> arraylistOU = new ArrayList<>(c.getImplantationInterface());
		for(ObjetUse ou : implantationInterface)
		{
			result = result && arraylistOU.contains(ou);
		}
		//VERIFICATION QUE LES DEUX CLASSES ONT LES MEME ELEMENTS CLASSE
		ArrayList<ElementClasse> arraylistEC = new ArrayList<>(c.getElementsClasse());
		for(ElementClasse ec : elementsClasse)
		{
			result = result && arraylistEC.contains(ec);
		}*/

		return result;
	}

	//VERIFIE QUE LA CLASSE THIS EST ETENDUE PAR LA CLASSE EN PARAMETRE
	public boolean etends(Classe _classe)
	{
		Classe c = (Classe)((((ClasseImpl) _classe).getHeritageClasse()).getObjet());
		return (c.getName().equals(this.getName()));
	}
	
	@Override
	public List<Attribut> getAttributsStatiques() {
		List<Attribut> attributsStatiques = new LinkedList<Attribut>();
		for (Attribut a : this.getAttributs()) {
			if (a.statiC) {
				attributsStatiques.add(a);
			}
		}
		return attributsStatiques;
	}
	
	@Override
	public List<Attribut> getAttributsNonStatiques() {
		List<Attribut> attributsNonStatiques = new LinkedList<Attribut>();
		for (Attribut a : this.getAttributs()) {
			if (!a.statiC) {
				attributsNonStatiques.add(a);
			}
		}
		return attributsNonStatiques;
	}
	
	@Override
	public int getTailleAttributsStatiques() {
		int taille = 0;
		for (Attribut as : this.getAttributsStatiques()) {
			taille += as.getType().length();
		}
		return taille;
	}
	

	public ObjetUse getHeritageClasse()
	{
		return this.heritageClasse;
	}

	public LinkedList<ParametreGenericite> getGenericite()
	{
		return this.genericite;
	}
	
	public LinkedList<ObjetUse> getImplantationInterface()
	{
		return this.implantationInterface;
	}

	public LinkedList<ElementClasse> getElementsClasse()
	{
		return this.elementsClasse;
	}
	
}
