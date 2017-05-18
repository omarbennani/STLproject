/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.n7.stl.block.ast.Expression;
import fr.n7.stl.block.ast.FunctionCall;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for a function call expression.
 * @author Marc Pantel
 *
 */
public class FunctionCallImpl implements FunctionCall {

	private Expression function;
	private List<Expression> parameters;

	public FunctionCallImpl(Expression _function) {
		this.function = _function;
	}

	@Override
	public String toString() {
		String _result = function + "( ";
		Iterator<Expression> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
		}
		while (_iter.hasNext()) {
			_result += " ," + _iter.next();
		}
		return  _result + ")";
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.FunctionCall#add(fr.n7.stl.block.ast.Expression)
	 */
	@Override
	public void add(Expression _parameter) {
		this.parameters.add(_parameter);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getType()
	 */
	@Override
	public Type getType() {
		List<Type> lres=new ArrayList<Type>();
		for(Expression t:this.parameters){
			lres.add(t.getType());
		}
		return new FunctionTypeImpl(this.function.getType(), lres);
	}

	@Override
	public Type getTypeReel() {
		List<Type> lres=new ArrayList<Type>();
		for(Expression t:this.parameters){
			lres.add(t.getTypeReel());
		}
		return new FunctionTypeImpl(this.function.getType(), lres);
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Expression#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
		for(Expression e:this.parameters)
			_res.append(e.getCode());
		_res.add(_factory.createJump(e.getNom()));
		return _code;
	}

}
