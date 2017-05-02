package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class InterfaceImpl implements Interface {

	protected String _name;
	protected Expression _heritageInterface;
	protected Iterable<ElementInterface> _methodes;

	public InterfaceImpl(String _name, Expression _heritageInterface, Iterable<ElementInterface> _methodes) {
		this._name=_name;
		this._heritageInterface=_heritageInterface;
		if (_heritageInterface == null) {
			this._methodes = new ArrayList<ElementInterface>();
		} else {
			this._methodes = new ArrayList<ElementInterface>((ArrayList<ElementInterface>)_methodes);
		}
	}

}
