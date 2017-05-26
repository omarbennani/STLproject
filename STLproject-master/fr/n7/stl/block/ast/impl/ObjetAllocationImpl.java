/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.Arguments;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable declaration instruction.
 * @author Marc Pantel
 *
 */
public class ObjetAllocationImpl implements Expression {
	
	protected Type type;
	protected Arguments arguments;
	
	public ObjetAllocationImpl(Type _type, Arguments _args) {
        this.type = _type;
        this.arguments = _args;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "new " + this.type + this.arguments;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return this.type;
	}
	
	@Override
	public Type getTypeReel() {
		return this.type;
	}
	
	public String findEtiquette() {
		String res = null;
		boolean find;
		for (Constructeur c : ((ClassTypeImpl)this.type).getClasse().getConstructeurs()){
			find = true;
			if (c.getParametres().size() == this.arguments.getListType().size()) {
				for (int i = 0; i < c.param.size(); i++){
					find = find && c.param.get(i).getType().compatibleWith(this.arguments.getListType().get(i));
				}
			} else {
				find = false;
			}
			if (find)
				res = c.getEtiquette();
			break;
		}
		return res;
		
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		if (this.arguments != null)
			_code.append(this.arguments.getCode(_factory));
		_code.add(_factory.createCall(this.findEtiquette(), Register.LB));
		return _code;
	}
}
