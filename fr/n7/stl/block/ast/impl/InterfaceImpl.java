package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class InterfaceImpl implements Interface {

	protected String _name;
	protected Expression _heritageInteface;
	protected Iterable<ElementInterface> _methodes;

	public InterfaceImpl(String _name, Expression _heritageInteface, Iterable<ElementInterface> _methodes) {
		this._name=_name;
		this._heritageInteface=_heritageInteface;
		this._methodes=_methodes;
	}

}
