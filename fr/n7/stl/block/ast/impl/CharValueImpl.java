package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.CharValue;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public class CharValueImpl implements CharValue {
	
	private char value;
	
	public CharValueImpl(String _text) {
		this.value = _text.charAt(0);
	}
	
	public String toString() {
		return "" + this.value;
	}

	@Override
	public Type getType() {
		return AtomicType.CharacterType;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		// TODO Auto-generated method stub
		return null;
	}

}
