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
	public Interface createInterface(String _identificateurType,LinkedList<ParametreGenericite> _genericite, LinkedList<ObjetUse> _heritageInterface, LinkedList<ElementInterface> _elements);

	public Signature createSignature(String _identificateur,LinkedList<Parametre> _param, String _interfaceName);

	public Signature createSignature(Type _type_retour, String _identificateur,LinkedList<Parametre> _param, String _interfaceName);
	
	public StaticField createStaticField(Type _type, String _identificateur, Expression _expression);

	public Expressions createExpressions();

	public Arguments createArguments();

	public Arguments createArguments(Expressions _exp);

	public Expression createObjetAllocation(Type _type, Arguments _args);
	
	public Parametre createParametre(Type _type, String _name);
	
	public Parametre createParametre(String _name);
	
	public Classe createClasse(String _name, LinkedList<ParametreGenericite> _genericite, ObjetUse _heritageClasse, LinkedList<ObjetUse> _implantationInterface, LinkedList<ElementClasse> _elementsClasse);

	public DroitAcces createDroitAcces(int i );

	public ElementClasse createMethode(DroitAcces _droit,String _name,LinkedList<Parametre> _param, Block _exp , String _nomClasse);

	public ElementClasse createAttribut(DroitAcces _droit,Type _type,String _name);

	public ElementClasse createMethode(DroitAcces _droit,Type _type,String _name,LinkedList<Parametre> _param, Block _exp , String _nomClasse);

	public ElementClasse createConstructeur(String _name,LinkedList<Parametre> _param,Block _exp);

	public Instruction createReturnInstruction(Expression _exp, Type _typeRetour);


	public Type createClassType(Classe _class);

	public Type createClassType(Classe _class, LinkedList<ObjetUse> _instanceGenericite);

	public Type createInterfaceType(Interface _interface);

	public Type createInterfaceType(Interface _interface, LinkedList<ObjetUse> _instanceGenericite);

	public AppelOuAcces createAppel(Expression _exp, Declaration _meth, Arguments _args);
	
	public AppelOuAcces createAppel(Declaration _meth, Arguments _args);
	
	public Expression createAttributUse(ElementClasse _declaration);

	public Expression createAttributUse(ElementClasse _declaration, Expression _exp);
	
	public ObjetUse createClasseUse(Classe _classe);

	public ObjetUse createClasseUse(Classe _classe, LinkedList<ObjetUse> _instanceGenericite);

	public ObjetUse createInterfaceUse(Interface _interface);

	public ObjetUse createInterfaceUse(Interface _interface, LinkedList<ObjetUse> _instanceGenericite);
	
	public Assignable createAttributAssignment(ElementClasse _attribut, Expression _expression);
	
	public Expression createParametreUse(Parametre _parametre);
	
	public ParametreGenericite createParametreGenericite(String _name, LinkedList<Type> _param );

	public ParametreGenericite createParametreGenericite(LinkedList<Type> _param );
	
	public VariableDeclaration createVariableDeclaration(String _name);
	
	public Type createGenericParameterType(ParametreGenericite parametreGenericite, LinkedList<ObjetUse> instanceGenericite);
}
