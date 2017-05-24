package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;

public class ParametreImpl implements Parametre {

	protected Type type;
	protected String nom;
	protected Methode methode;
	
	public ParametreImpl(Type _type, String _name) {
		this.type = _type;
		this.nom = _name;
	}

	@Override
	public String getName() {
		return this.nom;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	@Override
	public String toString() {
		return this.type.toString() + " " + this.nom;
	}
	
	public Methode getMethode() {
		return this.methode;
	}

}
