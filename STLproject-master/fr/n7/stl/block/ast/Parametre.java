package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Register;

public interface Parametre extends Declaration{

	public Type getType();
	
	public int allocateMemory(Register _register, int _offset);

}