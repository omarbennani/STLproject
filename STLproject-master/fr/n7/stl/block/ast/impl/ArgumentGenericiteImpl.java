package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;

import fr.n7.stl.block.ast.ArgumentGenericite;
import fr.n7.stl.block.ast.Type;

public class ArgumentGenericiteImpl implements ArgumentGenericite{

	protected String _name;
	protected LinkedList <Type> _inst;

	public ArgumentGenericiteImpl(String _name2) {
		this._name=_name2;
	}
	
	public ArgumentGenericiteImpl(String _name2, LinkedList<Type> _inst2) {

		this._name=_name2;
		this._inst=new LinkedList<Type>();
		if (_inst2 != null)
			this._inst=_inst2;
	}
	
	public String toString() {
		String res=this._name+" ";
		for(Type arg:_inst)
			res+=arg.toString()+" ";
		return res;
	}

}
