package fr.n7.stl.block.ast;

import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

public interface ElementClasse extends Declaration {

	public void setFinal(boolean _final);
	
	public void setStatic(boolean _static);
	
	public Type getType();
	
	public String getClassName();
	
	public Fragment getCode(TAMFactory _factory);
}
