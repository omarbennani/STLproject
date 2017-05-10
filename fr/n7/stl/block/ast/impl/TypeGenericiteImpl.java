package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ArgumentGenericite;
import fr.n7.stl.block.ast.Type;

public class TypeGenericiteImpl implements Type {
	
	protected String _name;
	protected List<ArgumentGenericite> _argGen;
	public TypeGenericiteImpl(String _name2, List<ArgumentGenericite> _argGen2) {
		this._name=_name2;
		this._argGen=_argGen2;
	}

	@Override
	public boolean equalsTo(Type _other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compatibleWith(Type _other) {
		return false;
	}

	@Override
	public Type merge(Type _other) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

}
