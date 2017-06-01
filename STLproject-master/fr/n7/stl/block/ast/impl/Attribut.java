package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

public class Attribut implements ElementClasse {

	protected DroitAcces droitAcces;
	protected Type typeAtt; 
	protected String nom;
	protected boolean finaL, statiC;
	protected Classe classe;
	private Register register;
	private int offset;
	
	public Attribut(DroitAcces _droit, Type _type, String _name) {
		this.droitAcces=_droit;
		this.typeAtt=_type;
		this.nom=_name;
		this.finaL = false;
		this.statiC = false;
	}

	@Override
	public String toString()
	{
		if(this.droitAcces == DroitAcces.publique)
			return "public "+typeAtt.toString()+" "+ nom;
		else if(this.droitAcces == DroitAcces.prive)
			return "private "+typeAtt.toString()+" "+ nom;
		else
			return "protected "+typeAtt.toString()+" "+ nom;
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
		return this.typeAtt;
	}


	public Type getTypeReel()
	{
		return this.typeAtt;
	}

	@Override
	public String getClassName()
	{
		return this.classe.getName();
	}
	
	public int getOffset() {
		return this.offset;
	}
	
	public Register getRegister() {
		return this.register;
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		if (this.statiC) {
			_code.add(_factory.createPush(this.typeAtt.length()));
		}
		return _code;
	}
	
	@Override
	public int allocateMemory(Register _register, int _offset) {
		if (this.statiC) {
			this.register = _register;
			this.offset = _offset;
			return this.getTypeReel().length();
		} else {
			return 0;
		}
	}

	@Override
	public void setThis(Parametre _this) {
	}

	@Override
	public void setClasse(Classe _classe) {
		this.classe = _classe;
	}
	
	public boolean isStatic() {
		return this.statiC;
	}

	public DroitAcces getDroitAcces()
	{
		return this.droitAcces;
	}
}
