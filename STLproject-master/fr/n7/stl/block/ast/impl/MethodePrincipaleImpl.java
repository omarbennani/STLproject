/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.MethodePrincipale;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for the main method.
 *
 */
public class MethodePrincipaleImpl implements MethodePrincipale {

	/**
	 * Sequence of instructions contained in the main method.
	 */
	protected List<Instruction> instructions;
	
	/**
	 * Nom de la classe principale.
	 */
	protected String identificateurType;
	
    private int offset;
	
	/**
	 * Constructor for the main method.
	 * @param _block : The block of the method.
	 */
	public MethodePrincipaleImpl(Block _bloc) {
		this.instructions = _bloc.getInstructions();
	}
	
	/**
	 * Constructor for the main method.
	 */
	public MethodePrincipaleImpl() {
		this.instructions = new LinkedList<Instruction>();
	}

	public void setIdentificateurType(String _id) {
		this.identificateurType = _id;
	}
	
	@Override
	public void add(Instruction _instruction) {
		this.instructions.add(_instruction);
	}

	@Override
	public void addAll(Iterable<Instruction> _instructions) {
		for (Instruction i : _instructions) {
			this.instructions.add(i);
		}
	}

	@Override
	public String toString() {
		System.out.println(this.instructions.size());
		String _local = "public class "+ this.identificateurType+"{\n";
		_local += "\tpublic static void main( String [] args){\n";


		for (Instruction _instruction : this.instructions) 			{
			_local += _instruction;
		}

		_local+="\t}\n}";
		return _local ;
	}

	@Override
	public boolean checkType() {
		boolean result = true;
		Iterator<Instruction> iter = this.instructions.iterator();
		while (iter.hasNext() && result) {
			result = result && iter.next().checkType();
		}
		return result;
	}
	
	@Override
	public List<Instruction> getInstructions() {
		return this.instructions;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = _offset;
        for (Instruction i : this.instructions) {
            _local += i.allocateMemory(_register, _local);
        }
        this.offset = _local - _offset;
        return 0;
	}

	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
        for (Instruction i: this.instructions) {
            _code.append(i.getCode(_factory));
        }
        _code.add(_factory.createPop(0, this.offset));
        _code.add(_factory.createHalt());
        return _code;
	}
}
