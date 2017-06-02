package fr.n7.stl.block.ast;

import java.util.List;

import fr.n7.stl.block.ast.impl.Attribut;
import fr.n7.stl.block.ast.impl.Constructeur;
import fr.n7.stl.block.ast.impl.Methode;
import fr.n7.stl.tam.ast.Register;

public interface Classe extends Objet {
	
	public Attribut getAttribut(String name);
	
	public List<Methode> getMethodes();
	
	public List<Attribut> getAttributs();
	
	public List<Constructeur> getConstructeurs();
	
	public void setClasseElementsClasse();
	
	public List<Methode> updateMethodes();
	
	public List<Attribut> updateAttributs();
	
	public List<Methode> getAllMethodes();
	
	public List<Attribut> getAllAttributs();
	
	public List<Methode> getMethodesMeres();
	
	public List<Attribut> getAttributsParents();

	public boolean estEtendue(Classe _classe);
	
	public List<Attribut> getAttributsStatiques();
	
	public int getTailleAttributsStatiques();
	
	public List<Attribut> getAttributsNonStatiques();
	
	public Register getRegister();
	
	public int getOffset();
	
	public boolean implemente(Interface _interface);
	
	public boolean containsMethode(ElementClasse _methode);
	
	public boolean containsAttribut(String _name);
	
	public boolean equals(Classe _classe);
}
