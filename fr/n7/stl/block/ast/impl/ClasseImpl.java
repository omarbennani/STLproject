package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.ParametreGenericite;
import fr.n7.stl.block.ast.TypeInterface;
import fr.n7.stl.block.ast.TypeObjet;

public class ClasseImpl implements Classe{

	protected String _name;
	protected List<ElementClasse> _elts;
	protected List<TypeInterface> _interfaces;
	protected List<TypeObjet> _parents;
	List<ParametreGenericite> _gene;
	public ClasseImpl(String _name2, List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		this._parents=new ArrayList<TypeObjet>();
		this._gene=new ArrayList<ParametreGenericite>();
	}
	public ClasseImpl(String _name2,List<TypeInterface> _interfaces2, List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		if (_interfaces2!=null)
			this._interfaces=_interfaces2;
		this._parents=new ArrayList<TypeObjet>();
		this._gene=new ArrayList<ParametreGenericite>();

	}
	
	public ClasseImpl(List<ParametreGenericite> _heritage,String _name2,  List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		this._parents=new ArrayList<TypeObjet>();
		this._gene=new ArrayList<ParametreGenericite>();

		}
	public ClasseImpl(String _name2,List<TypeObjet> _heritage,List<TypeInterface> _interfaces2,  List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		if (_interfaces2!=null)
			this._interfaces=_interfaces2;
		this._parents=new ArrayList<TypeObjet>();
		if (_heritage!=null)
			this._parents=_heritage;
		this._gene=new ArrayList<ParametreGenericite>();

		}
	
	public ClasseImpl(List<ParametreGenericite> _genericite, List<ElementClasse> _elts2, String _name2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		this._parents=new ArrayList<TypeObjet>();
		this._gene=new ArrayList<ParametreGenericite>();
		if (_genericite!=null)
			this._gene=_genericite;
	}
	public ClasseImpl(List<ParametreGenericite> _genericite, List<TypeInterface> _interfaces2,List<ElementClasse> _elts2, String _name2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		if (_interfaces2!=null)
			this._interfaces=_interfaces2;
		this._parents=new ArrayList<TypeObjet>();
		this._gene=new ArrayList<ParametreGenericite>();
		if (_genericite!=null)
			this._gene=_genericite;
	}
	public ClasseImpl(List<ParametreGenericite> _genericite, List<TypeObjet> _heritage, String _name2,List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		this._parents=new ArrayList<TypeObjet>();
		if (_heritage!=null)
			this._parents=_heritage;
		this._gene=new ArrayList<ParametreGenericite>();
		if (_genericite!=null)
			this._gene=_genericite;
	}
	public ClasseImpl(String _name2, List<ParametreGenericite> _genericite, List<TypeObjet> _heritage,List<TypeInterface> _interfaces2, List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=new ArrayList<ElementClasse>();
		if (_elts2!=null)
		  this._elts=_elts2;
		this._interfaces= new ArrayList<TypeInterface>();
		if (_interfaces2!=null)
			this._interfaces=_interfaces2;
		this._parents=new ArrayList<TypeObjet>();
		if (_heritage!=null)
			this._parents=_heritage;
		this._gene=new ArrayList<ParametreGenericite>();
		if (_genericite!=null)
			this._gene=_genericite;
	}
	@Override
	public String getName() {
		return this._name;
	}

}
