/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a function type.
 * @author Marc Pantel
 *
 */
public class FunctionTypeImpl implements Type {

	private Type result;
	protected List<Type> parameters;

	public FunctionTypeImpl(Type _result, Iterable<Type> _parameters) {
		this.result = _result;
		this.parameters = new LinkedList<Type>();
		for (Type _type : _parameters) {
			this.parameters.add(_type);
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#equalsTo(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean equalsTo(Type _other) {
	    // INCOMPLET !!!
		boolean b=true;
		int i=0;
	    if (_other instanceof FunctionTypeImpl) {
	    	while(b&&i<this.parameters.size())
	    		b=this.parameters.get(i).equalsTo(((FunctionTypeImpl)_other).parameters.get(i));
	       return (this.result.equalsTo(((FunctionTypeImpl) _other).result) && b);
	    } else {
	        return false;
	    }
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#compatibleWith(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public boolean compatibleWith(Type _other) {
		boolean b=true;
		int i=0;
	    if (_other instanceof FunctionTypeImpl) {
	    	while(b&&i<this.parameters.size())
	    		b=this.parameters.get(i).compatibleWith(((FunctionTypeImpl)_other).parameters.get(i));
	        return (this.result.compatibleWith(((FunctionTypeImpl) _other).result)&&b);
	    } else {
	        return false;
	    }
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#merge(fr.n7.stl.block.ast.Type)
	 */
	@Override
	public Type merge(Type _other) {
	    if (_other instanceof FunctionTypeImpl) {
	    	Type t=this.result.merge(((FunctionTypeImpl) _other).result);
	    	for(int i=0;i<this.parameters.size();i++)
	    		t.merge(this.parameters.get(i).merge(((FunctionTypeImpl) _other).parameters.get(i)));
	    	return t;
            } else {
                return AtomicType.ErrorType;
	    }
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Type#length(int)
	 */
	@Override
	public int length() {
		int res=this.result.length();
		for (Type t:this.parameters){
			res+=t.length();
		}
		return res;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String _result = "(";
		Iterator<Type> _iter = this.parameters.iterator();
		if (_iter.hasNext()) {
			_result += _iter.next();
			while (_iter.hasNext()) {
				_result += " ," + _iter.next();
			}
		}
		return _result + ") -> " + this.result;
	}

}
