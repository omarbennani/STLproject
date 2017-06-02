package fr.n7.stl.block.ast.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.impl.TAMFactoryImpl;

public class Constructeur implements ElementClasse {

	protected String nom;
	protected List<Parametre> param;
	protected Block exp;
	protected boolean finaL, statiC;
	protected Classe classe;
	private String etiquette;
	private Parametre thiS;

	public Constructeur(String _name, List<Parametre> _param2, Block _exp2) {
		this.nom=_name;
		this.param=_param2;
		this.exp=_exp2;
		this.finaL = false;
		this.statiC = false;
		TAMFactory _factory = new TAMFactoryImpl();
		int _labelNumber = _factory.createLabelNumber();
		this.etiquette = this.nom + _labelNumber;
		_factory = null;
	}

	@Override
	public String toString() {
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
	public void setFinal(boolean _final) {
		this.finaL = _final;
	}
	
	@Override
	public void setStatic(boolean _static) {
		this.statiC = _static;
	}

	@Override
	public String getName() {
		return this.nom;
	}

	@Override
	public Type getType() {
		return this.classe.getType();
	}

	@Override
	public String getClassName() {
		return this.nom;
	}

	public String getEtiquette() {
		return this.etiquette;
	}

	public List<Parametre> getParametres() {
		return this.param;
	}
	
	public void setClasse(Classe _classe) {
		this.classe = _classe;
		this.thiS.setType(this.classe.getType());
	}
	
	@Override
	public void setThis(Parametre _this) {
		this.thiS = _this;
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _res=_factory.createFragment();
		int tailleDesArguments = 0;
		for (Parametre p : this.param) {
			tailleDesArguments += p.getType().length();
		}
		_res.append(exp.getCode(_factory));
		_res.add(_factory.createReturn(classe.getType().length(), tailleDesArguments));
		_res.addPrefix(this.etiquette + ":");
		return _res;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = -1;
		List<Parametre> parametres = new LinkedList<Parametre>(this.param);
		Collections.reverse(parametres);
		for (Parametre p : parametres) {
			_local -= p.allocateMemory(Register.LB, _local);
		}
		_local -= this.thiS.allocateMemory(Register.LB, _local);
		this.exp.allocateMemory(_register, _offset);
		return 0;
	}
}
