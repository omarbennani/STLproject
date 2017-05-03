package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.ParametreGenericite;

public class ParametreGenericiteImpl implements ParametreGenericite{

	protected String _name;
	protected List<Objet> _param;
	public ParametreGenericiteImpl(String _name, List<Objet> _param) {
		this._name=_name;
		this._param=_param;
	}
	public ParametreGenericiteImpl(List<Objet> _param2) {
		this._param=_param2;
	}
	@Override
	public String getName() {
		return _name;
	}

}
