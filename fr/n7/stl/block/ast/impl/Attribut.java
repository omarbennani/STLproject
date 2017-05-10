package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Type;

public class Attribut implements ElementClasse {

	protected DroitAcces _droitAcces;
	protected Type _typeAtt;
	protected String _nom;
	
	public Attribut(DroitAcces _droit, Type _type, String _name) {
		this._droitAcces=_droit;
		this._typeAtt=_type;
		this._nom=_name;
	}

}
