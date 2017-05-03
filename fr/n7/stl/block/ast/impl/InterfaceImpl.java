package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.ParametreGenericite;
import fr.n7.stl.block.ast.Type;

public class InterfaceImpl implements Interface {

	protected String _name;
	protected List<ParametreGenericite> _heritageInterface;
	protected Iterable<ElementInterface> _methodes;

	public InterfaceImpl(String _name, List<ElementInterface> _methodes) {
		this._name=_name;
		this._methodes = new ArrayList<ElementInterface>();
	}

	public InterfaceImpl(String _name2, List<Type> _types, List<ElementInterface> _elts) {
		this._name=_name2;
		this._methodes=_elts;
	}

	public InterfaceImpl(String _name2, List<ParametreGenericite> _param, List<Type> _types,List<ElementInterface> _elts) {
		this._name=_name2;
		this._heritageInterface=_param;

	}

	@Override
	public String getName() {
		return this._name;
	}

}
