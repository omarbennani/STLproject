package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class Methode implements ElementClasse,Expression {

	protected DroitAcces droitAcces;
	protected String nom;
	protected String nomClasse;
	protected LinkedList<Parametre> param;
	protected Block exp;
	protected Type typeRet;
	protected boolean finaL, statiC;
	
	public Methode(DroitAcces _droit, String _name, LinkedList<Parametre> _param2, Block _exp2, String _nomClasse) {
		this.droitAcces=_droit;
		this.nom=_name;
		this.param=_param2;
		this.exp=_exp2;		
		this.finaL = false;
		this.statiC = false;
		this.nomClasse = _nomClasse;
	}
	
	public Methode(DroitAcces _droit, Type _type, LinkedList<Parametre> _param2, String _name, Block _exp2, String _nomClasse) {
		this.droitAcces=_droit;
		this.nom=_name;
		this.param=_param2;
		this.exp=_exp2;
		this.typeRet=_type;
		this.finaL = false;
		this.statiC = false;
		this.nomClasse = _nomClasse;
	}

	@Override
	public String toString()
	{
		String _local = "";
	
		if(this.droitAcces == DroitAcces.publique)
				_local = "public " +this.typeRet.toString()+ " " +this.nom + "(";
		else if(this.droitAcces == DroitAcces.prive)
			_local = "private " +this.typeRet.toString()+ " " +this.nom + "(";
		else
			_local = "protected " +this.typeRet.toString()+ " " + this.nom + "(";

		for (Parametre p : this.param)
		{
			_local+= p.toString()+",";
		}
		_local+="){";
		_local+= this.exp.toString();
		_local+="}";
		return _local;
	}

	@Override
	public void setFinal(boolean _final)
	{
		this.finaL = _final;
	}
	
	@Override
	public void setStatic(boolean _static)
	{
		this.statiC = _static;
	}

	@Override
	public String getName()
	{
		return this.nom;
	}

	@Override
	public Type getType()
	{
		return this.typeRet;
	}

	public List<Parametre> getParametres()
	{
		return this.param;
	}
	public String getClassName()
	{
		return this.nomClasse;
	}
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _res=_factory.createFragment();
		_res.add(_factory.createLoadA(this.nom));
		for (Parametre p:this.param)
			_res.add(_factory.createLoadI(p.getType().length()));
		_res.append(exp.getCode());
		_res.add(_factory.createReturn(typeRet.getType().length(), typeRet.getType().length()));
		return _res;
	}

}
