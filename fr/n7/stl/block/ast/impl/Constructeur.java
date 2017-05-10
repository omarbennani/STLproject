package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;

public class Constructeur implements ElementClasse{

	protected String _nom;
	protected List<Parametre> _param;
	protected Expression _exp;
	public Constructeur(String _name, List<Parametre> _param2, Expression _exp2) {
		this._nom=_name;
		this._param=new ArrayList<Parametre>();
		if (_param2 !=null)
		  this._param=_param2;
		this._exp=_exp2;
	}

}
