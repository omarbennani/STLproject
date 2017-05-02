package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Interface;

public class InterfaceImpl implements Interface {

	protected String _name;
	protected Expression _heritageInterface;
	protected Iterable<ElementInterface> _methodes;

	public InterfaceImpl(String _name, List<ElementInterface> _methodes) {
		this._name=_name;
		this._methodes = new ArrayList<ElementInterface>();
	}

}
