package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Interface;

public class ClasseImpl implements Classe{

	protected String _name;
	protected List<ElementClasse> _elts;
	protected Interface _interface;
	public ClasseImpl(String _name2, List<ElementClasse> _elts2) {
		this._name=_name2;
		this._elts=_elts2;
	}
	@Override
	public String getName() {
		return this._name;
	}

}
