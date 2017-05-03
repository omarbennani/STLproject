package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ParametreGenericite;

public class ParametreGenericiteImpl implements ParametreGenericite{

	protected String _name;
	protected List<String> _param;
	public ParametreGenericiteImpl(String _name, List<String> _param) {
		this._name=_name;
		this._param=_param;
	}
	public ParametreGenericiteImpl(List<String> _param2) {
		this._param=_param2;
	}
	@Override
	public String getName() {
		return _name;
	}

}
