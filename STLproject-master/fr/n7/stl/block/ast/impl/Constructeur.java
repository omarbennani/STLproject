package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.TypeClasse;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;

public class Constructeur implements ElementClasse{

	protected String nom;
	protected List<Parametre> param;
	protected Block exp;
	protected boolean finaL, statiC;
	protected Classe classe;

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
	
	public void setClasse(Classe _classe) {
		this.classe = _classe;
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code= _factory.createFragment();
		int tailleDesArguments=0;
		_code.add(_factory.createLoadA(this.nom));
		for (Parametre p:this.param){
			_code.add(_factory.createLoadI(p.getType().length()));
			tailleDesArguments+=p.getType().length();
		}
		_code.append(exp.getCode(_factory));
		_code.add(_factory.createReturn(this.classe.getType().length(), tailleDesArguments));
		return _code;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		// TODO Auto-generated method stub
		return 0;
	}
}
