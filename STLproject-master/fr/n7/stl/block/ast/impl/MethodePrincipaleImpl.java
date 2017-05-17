/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;

import fr.n7.stl.block.ast.MethodePrincipale;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;

/**
 * Implementation of the Abstract Syntax Tree node for an instruction block.
 * @author Marc Pantel
 *
 */
public class MethodePrincipaleImpl implements MethodePrincipale {

	/**
	 * Sequence of instructions contained in a block.
	 */
	protected List<Instruction> instructions;
	protected String identificateurType;
	

	/**
	 * Hierarchical structure of blocks.
	 * Link to the container block.
	 * 
	 */
    
    private int offset;
	
	/**
	 * Constructor for a block contained in a _context block.
	 * @param _context Englobing block.
	 */
	public MethodePrincipaleImpl(Block _bloc) {
		this.instructions = _bloc.getInstructions();
	}

	public void setIdentificateurType(String _id)
	{
		this.identificateurType = _id;
	}
	
	/**
	 * Constructor for a block root of the block hierarchy.
	 */
	public MethodePrincipaleImpl() {
		this.instructions = new LinkedList<Instruction>();
	}

	/* (non-Javadoc)
	 * @see fr.n7.block.ast.Block#add(fr.n7.block.ast.Instruction)
	 */
	@Override
	public void add(Instruction _instruction) {
		this.instructions.add(_instruction);
	}


	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#addAll(java.lang.Iterable)
	 */
	@Override
	public void addAll(Iterable<Instruction> _instructions) {
		for (Instruction i : _instructions) {
			this.instructions.add(i);
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
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

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#checkType()
	 */
	@Override
	public boolean checkType() {
		boolean result = true;
		Iterator<Instruction> iter = this.instructions.iterator();
		while (iter.hasNext() && result) {
			result = result && iter.next().checkType();
		}
		return result;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = _offset;
        for (Instruction i : this.instructions) {
            _local += i.allocateMemory(_register, _local);
        }
        this.offset = _local - _offset;
        return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Block#generateCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _code = _factory.createFragment();
        for (Instruction i: this.instructions) {
            _code.append(i.getCode(_factory));
        }
        _code.add(_factory.createPop(0, this.offset));
//        if (!this.context.isPresent()) {
//        	_code.add(_factory.createHalt());
//        }
        return _code;
	}


	public List<Instruction> getInstructions()
	{
		return this.instructions;
	}
}
