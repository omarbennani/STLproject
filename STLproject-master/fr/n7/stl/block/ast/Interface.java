package fr.n7.stl.block.ast;

import java.util.Set;

public interface Interface extends Objet {

	public Set<Signature> getSignatures();
	
	public Set<Signature> getAllSignatures();
	
}