/**
 * 
 */
package fr.n7.stl.block.ast;

import java.util.LinkedList;


public interface ObjetFactory {

	/*
	Create a node for the declaration of an interface in the Abstract Syntax Tree.
	@param _identificateurType name of the interface created.
	*/
	public Interface createInterface(String _identificateurType, LinkedList<Interface> _heritageInterface, LinkedList<ElementInterface> _elements);

	public Signature createSignature(String _identificateur,LinkedList<Parametre> _param);

	public Signature createSignature(Type _type_retour, String _identificateur,LinkedList<Parametre> _param);
	
	public StaticField createStaticField(Type _type, String _identificateur, Expression _expression);

	public Type createObjetType(String _name);

	public Expressions createExpressions();

	public Arguments createArguments();

	public Arguments createArguments(Expressions _exp);

	public ObjetDeclaration createObjet(Type _type, Arguments _args);
	public Parametre createParametre(Type _type,String _name);
	
	public Classe createClasse(String _name, LinkedList<Classe> _heritageClasse, LinkedList<Interface> _implantationInterface, LinkedList<ElementClasse> _elementsClasse);

	public DroitAcces createDroitAcces(int i );

	public ElementClasse createMethode(DroitAcces _droit,String _name,LinkedList<Parametre> _param, Block _exp , String _nomClasse);

	public ElementClasse createAttribut(DroitAcces _droit,Type _type,String _name);

	public ElementClasse createMethode(DroitAcces _droit,Type _type,String _name,LinkedList<Parametre> _param, Block _exp , String _nomClasse);

	public ElementClasse createConstructeur(String _name,LinkedList<Parametre> _param,Block _exp);

	public Instruction createReturnInstruction(Expression _exp);


	public Type createClassType(Classe _class);

	public Type createInterfaceType(Interface _interface);

	public AppelOuAcces createAppel(Expression _exp, Declaration _meth, Arguments _args);
	
	public AppelOuAcces createAcces(Expression _expr, String _ident);

	public Expression createAttributUse(ElementClasse _declaration);

	public Expression createStaticFieldUse(Declaration _declaration);

	public Expression createClasseUse(Classe _classe);

	public Expression createInterfaceUse(Interface _interface);
	

}
