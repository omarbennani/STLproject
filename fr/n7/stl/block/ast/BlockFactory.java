/**
 * 
 */
package fr.n7.stl.block.ast;

/**
 * Combines the various factories for the Bloc language.
 * @author Marc Pantel
 *
 */
public interface BlockFactory extends ExpressionFactory, InstructionFactory, TypeFactory {
	
	/**
	 * Crée une interface dans la factory
	 * @return 
	 */
	public Interface createInterface(String _name, Expression _heritage, ElementInterface _methodes);
	
}
