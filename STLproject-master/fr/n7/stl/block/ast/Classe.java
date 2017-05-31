package fr.n7.stl.block.ast;

import java.util.List;

import fr.n7.stl.block.ast.impl.Attribut;
import fr.n7.stl.block.ast.impl.Constructeur;
import fr.n7.stl.block.ast.impl.Methode;

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

	public boolean etends(Classe _classe);
	//public boolean estEtendu(Classe _classe);


}
