package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class Attribut implements ElementClasse,Expression {

	protected DroitAcces _droitAcces;
	protected Type _typeAtt;
	protected String _nom;
	protected Expression _val;
	
	public Attribut(DroitAcces _droit, Type _type, String _name) {
		this._droitAcces=_droit;
		this._typeAtt=_type;
		this._nom=_name;
	}

	@Override
	public Type getType() {
		return _typeAtt;
	}

	public void setValeur(Expression val){
		if (_val.getType().compatibleWith(val.getType())){
			this._val=val;
		}else{
			new Exception("Erreur de Type");
		}
			
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		return _val.getCode(_factory);
	}
	
	public String toString(){
		String res=this._nom+" ";
		res+=_typeAtt.toString()+" ";
		res+=_val.toString()+" ";
		res+=_droitAcces.toString();
		return res;
	}

}
