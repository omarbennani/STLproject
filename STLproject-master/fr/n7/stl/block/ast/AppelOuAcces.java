package fr.n7.stl.block.ast;

public interface AppelOuAcces extends Expression {

	public void setStatic(boolean _b);
	public void setDeclaration(Declaration _d);
	public void setInterface(Interface _i);
	public void setClasse(Classe _c);

}
