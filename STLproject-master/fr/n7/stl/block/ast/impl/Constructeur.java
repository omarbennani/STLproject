package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;

public class Constructeur implements ElementClasse{

	protected String nom;
	protected List<Parametre> param;
	protected Block exp;
	protected boolean finaL, statiC;

	public Constructeur(String _name, List<Parametre> _param2, Block _exp2) 
	{
		this.nom=_name;
		this.param=_param2;
		this.exp=_exp2;
		this.finaL = false;
		this.statiC = false;
	}

	@Override
	public String toString()
	{
		String _local = "public " + this.nom + "(";
		for (Parametre p : this.param)
		{
			_local+= p.toString()+",";
		}
		_local+="){";
		_local+= exp.toString();
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
		throw new SemanticsUndefinedException("getType is undefined in Methode");
	}

	@Override
	public String getClassName() {
		return this.nom;
	}

	public List<Parametre> getParametres() {
		return this.param;
	}
}
