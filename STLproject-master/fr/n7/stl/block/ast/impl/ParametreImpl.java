package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Register;

public class ParametreImpl implements Parametre {

	protected Type type;
	protected String nom;
	private Register register;
	private int offset;
	
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

	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.offset = _offset;
		this.register = _register;
		return this.type.length();
	}

}
