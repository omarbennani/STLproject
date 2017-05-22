package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.StringValue;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp.Factory;

public class StringValueImpl implements StringValue{
	
	private String value;
	
	public StringValueImpl(String _text) {
		this.value = _text;
	}

	public String toString() {
		return this.value;
	}
	
	@Override
	public Type getType() {
		return AtomicType.StringType;
	}

	@Override
	public Type getTypeReel() {
		return this.getType();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.add(_factory.createStoreI(value.length()));
		return _code;
	}

}
