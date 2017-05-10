package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.TypeObjet;

public class TypeObjetImpl implements TypeObjet {

	protected Declaration _decl;
	public TypeObjetImpl(Declaration _decl2) {
		this._decl=_decl2;
	}

	@Override
	public boolean equalsTo(Type _other) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean compatibleWith(Type _other) {
		// TODO Auto-generated method stub
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
