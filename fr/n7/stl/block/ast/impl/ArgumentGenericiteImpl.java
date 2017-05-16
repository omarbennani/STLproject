package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.ArgumentGenericite;

public class ArgumentGenericiteImpl implements ArgumentGenericite{

	protected String _name;
	protected List <ArgumentGenericite> _inst;
	public ArgumentGenericiteImpl(String _name2) {
		this._name=_name2;
	}
	public ArgumentGenericiteImpl(String _name2, List<ArgumentGenericite> _inst2) {
		this._name=_name2;
		this._inst=new ArrayList<ArgumentGenericite>();
		if (_inst2 != null)
			this._inst=_inst2;
	}
	public String toString() {
		String res=this._name+" ";
		for(ArgumentGenericite arg:_inst)
			res+=arg.toString()+" ";
		return res;
	}

}
