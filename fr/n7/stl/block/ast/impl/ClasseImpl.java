package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Classe;

public class ClasseImpl implements Classe{

	protected String _name;
	@Override
	public String getName() {
		return this._name;
	}

}
