package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.CharValue;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class CharValueImpl implements CharValue {
	
	private char value;
	
	public CharValueImpl(String _text) {
		this.value = _text.charAt(1);
	}
	
	public String toString() {
		return new String("'"+ this.value + "'");
	}

	@Override
	public Type getType() {
		return AtomicType.CharacterType;
	}

	@Override
	public Type getTypeReel() {
		return this.getType();
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		_code.add(_factory.createLoadL(this.value));
		return _code;
	}

}
