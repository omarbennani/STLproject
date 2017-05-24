package fr.n7.stl.block.ast;

import fr.n7.stl.block.ast.impl.Methode;

public interface Parametre extends Declaration{

	public Type getType();
	
	public Methode getMethode();
}
