package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.ElementInterface;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class SignatureImpl implements ElementInterface{
	protected Type _type;
	protected String _name;
	protected List<Parametre> _param;

	public SignatureImpl(Type _type, String _name, List<Parametre> _param) {
		this._type=_type;
		this._name=_name;
		this._param=_param;
	}

	public SignatureImpl(String _name2, List<Parametre> _param2) {
		this._name=_name2;
		this._param=_param2;
	}	
}
