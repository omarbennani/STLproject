package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.util.Pair;

public class Methode implements ElementClasse {

	protected DroitAcces _droitAcces;
	protected String _nom;
	protected List<Parametre> _param;
	protected Expression _exp;
	protected Type _typeAtt;
	
	public Methode(DroitAcces _droit, String _name, List<Parametre> _param2, Expression _exp2) {
		this._droitAcces=_droit;
		this._nom=_name;
		this._param= new ArrayList<Parametre>();
		if( _param2!=null)
			this._param=_param2;
		this._exp=_exp2;		
	}
	
	public Methode(DroitAcces _droit, Type _type,List<Parametre> _param2, String _name, Expression _exp2) {
		this._droitAcces=_droit;
		this._nom=_name;
		this._param= new ArrayList<Parametre>();
		if( _param2!=null)
			this._param=_param2;
		this._exp=_exp2;
		this._typeAtt=_type;
	}

}
