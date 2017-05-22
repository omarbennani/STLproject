package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public interface Objet extends Declaration {

	public Type getType();
	
	public Fragment getCode(TAMFactory _factory);
}
