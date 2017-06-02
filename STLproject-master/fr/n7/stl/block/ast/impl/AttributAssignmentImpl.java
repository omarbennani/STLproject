/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Assignable;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Library;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * @author Marc Pantel
 *
 */
public class AttributAssignmentImpl extends AttributUseImpl implements Assignable {

	/**
	 * Creates a variable assignment expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the assigned variable.
	 */
	public AttributAssignmentImpl(ElementClasse _declaration, Expression _expression) {
		super(_declaration);
		this.exp = _expression;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.impl.VariableUseImpl#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		int aPop = 0;
		boolean attributVu = false;
		if (!((Attribut)this.declaration).statiC) {
			List<Attribut> attributs = ((ClassTypeImpl)this.exp.getType()).getClasse().getAttributs();
			for (Attribut a : attributs) {
				attributVu = attributVu | this.declaration.getName().equals(a.getName());
				if (!attributVu) {
					aPop += a.getType().length();
				}
			}
			_code.append(this.exp.getCode(_factory));
			_code.add(_factory.createLoadL(aPop));
			_code.add(Library.IAdd);
		} else {
			int position = 0;
			Expression e = this;
			while (!(e instanceof ClasseUseImpl)) {
				for (Attribut a: ((ClassTypeImpl)((AttributUseImpl)e).exp.getType()).getClasse().getAttributsStatiques()) {
					if (a.getName().equals(((AttributUseImpl)e).declaration.getName())) {
						break;
					} else {
						position = ((Attribut)((AttributUseImpl)e).declaration).getOffset();
					}
				}
				e = ((AttributUseImpl)e).exp;
			}
			_code.add(_factory.createLoadA(((ClasseUseImpl)e).classe.getRegister(),
										   position));
		}
		return _code;
	}
}
