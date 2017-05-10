package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FunctionDeclaration;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class FunctionDeclarationImpl implements FunctionDeclaration{

	protected String _name;
	protected List<Parametre> _param;
	protected Expression _exp;
	protected Type _type;
	@Override
	public String getName() {
		return this._name;
	}

	@Override
	public Type getType() {
		List<Type> lType=new ArrayList<Type>();
		for (Parametre p:_param)
			lType.add(p.getType());
		return new FunctionTypeImpl(_type, lType);
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.append(this._exp.getCode(_factory));
		//Prendre le premier elt de la pile pour chaque parametre
		for (Parametre p:_param)
			_code.add(_factory.createCallI(p.getType().length()) );
		//bof
		return _code;
	}

}
