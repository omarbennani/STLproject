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

}
