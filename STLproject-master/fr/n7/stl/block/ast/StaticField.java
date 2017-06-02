package fr.n7.stl.block.ast;

public interface StaticField extends ElementInterface {
	
	public boolean isFinal();
	
	public Expression getValue();
}
