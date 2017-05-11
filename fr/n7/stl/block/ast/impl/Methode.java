package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
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

	protected DroitAcces _droitAcces;
	protected String _nom;
	protected List<Parametre> _param;
	protected Block _bloc;
	protected Type _typeAtt;
	
	public Methode(DroitAcces _droit, String _name, List<Parametre> _param2, Block _bloc2) {
		this._droitAcces=_droit;
		this._nom=_name;
		this._param= new ArrayList<Parametre>();
		if( _param2!=null)
			this._param=_param2;
		this._bloc=_bloc2;		
	}
	
	public Methode(DroitAcces _droit, Type _type,List<Parametre> _param2, String _name, Block _bloc2) {
		this._droitAcces=_droit;
		this._nom=_name;
		this._param= new ArrayList<Parametre>();
		if( _param2!=null)
			this._param=_param2;
		this._bloc=_bloc2;
		this._typeAtt=_type;
	}

	@Override
	public Type getType() {
		List<Type> lType=new ArrayList<Type>();
		for (Parametre p:_param)
			lType.add(p.getType());
		return new FunctionTypeImpl(this._typeAtt, lType);
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.append(this._bloc.getCode(_factory));
		//Prendre le premier elt de la pile pour chaque parametre
		for (Parametre p:_param)
			_code.add(_factory.createCallI(p.getType().length()) );
		//bof
		return _code;
	}
}
