/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FieldDeclaration;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a variable use expression.
 * @author Marc Pantel
 *
 */
public class AttributUseImpl implements Expression {

	protected ElementClasse declaration;
	protected Expression exp;
	
	/**
	 * Creates a variable use expression Abstract Syntax Tree node.
	 * @param _declaration Declaration of the used variable.
	 */
	public AttributUseImpl(ElementClasse _declaration) {
		this.declaration = _declaration;
	}
	
	public AttributUseImpl(ElementClasse _declaration, Expression _exp) {
		this.declaration = _declaration;
		this.exp = _exp;
	}

	public Attribut getAttribut() {
		return (Attribut)this.declaration;
	}
	
	public Expression getExpression() {
		return this.exp;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (this.exp == null) {
			return this.declaration.getName();
		}
		else
			return this.exp.toString() + "." + this.declaration.getName();		
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		return declaration.getType();
	}
	
	@Override
	public Type getTypeReel() {
		return ((Attribut)this.declaration).getTypeReel();
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		int taille = this.declaration.getType().length();
		int aPop = 0;
		boolean attributVu = false;
		if (!((Attribut)this.declaration).statiC) {
			List<Attribut>attributs = new ArrayList<Attribut>(((ClassTypeImpl)this.exp.getType()).getClasse().getAttributsNonStatiques());
			Collections.reverse(attributs);
			for (Attribut a : attributs) {
				attributVu = attributVu | this.declaration.getName().equals(a.getName());
				if (!attributVu) {
					aPop += a.getType().length();
				}
			}
			_code.append(this.exp.getCode(_factory));
			_code.add(_factory.createLoadI(((ClassTypeImpl)this.exp.getType()).getTaillePointee()));
			_code.add(_factory.createPop(0, aPop));
			_code.add(_factory.createPop(taille, ((ClassTypeImpl)this.exp.getType()).getTaillePointee() - taille - aPop));
		} else {
			int position = 0;
			Expression e = this;
			while (e instanceof AttributUseImpl) {
				for (Attribut a : ((ClassTypeImpl)((AttributUseImpl)e).exp.getType()).getClasse().getAttributs()) {
					if (a.getName().equals(((AttributUseImpl)e).declaration.getName())) {
						break;
					} else {
						position = ((Attribut)((AttributUseImpl)e).declaration).getOffset();
					}
				}
				e = ((AttributUseImpl)e).exp;
			}
			_code.add(_factory.createLoad(((ClasseUseImpl)e).classe.getRegister(),
										   position,
										   this.declaration.getType().length()));
		}

	
		return _code;

	}

}
