package fr.n7.stl.block.ast;

public interface ElementClasse extends Declaration {

	public void setFinal(boolean _final);
	
	public void setStatic(boolean _static);
	
	public Type getType();
	
	public String getClassName();
}
