package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Instruction;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Programme;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import sun.font.CreatedFontTracker;
import fr.n7.stl.block.ast.MethodePrincipale;

public class ProgrammeImpl implements Programme {

	protected LinkedList<Interface> interfaces;
	protected LinkedList<Classe> classes;
	protected MethodePrincipale princ;
	
    private int offset;

	
	public ProgrammeImpl(LinkedList<Interface> _interfaces,LinkedList<Classe> _classes, MethodePrincipale _princ) 
	{
			this.interfaces=_interfaces;
			this.classes=_classes;
			this.princ = _princ;
			ParametreImpl p;
	}
	
	public void addClasse(Classe _classe){
		this.classes.add(_classe);
	}
	
	public void addInterface(Interface _interface){
		this.interfaces.add(_interface);
	}

	@Override
	public String toString()
	{
		String _local = "";
		for (Interface _interface : this.interfaces) {
			_local += _interface;
		}

		_local += "\n";
		
		for (Classe _classe : this.classes) {
			_local += _classe;
			_local += "\n";
		}

		_local += "\n";
		
		_local += this.princ.toString();

		return _local;
	}
	
	@Override
	public boolean checkType() {
		boolean result = true;
		for (Interface i : this.interfaces)
			result = result && i.checkType();
		for (Classe c : this.classes)
			result = result && c.checkType();
		result = result && princ.checkType();
		return princ.checkType();
	}
	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = _offset;
		for (Interface i : this.interfaces) {
			_local += i.allocateMemory(_register, _local);
		}
		for (Classe c : this.classes) {
			_local += c.allocateMemory(_register, _local);
		}
		_local += this.princ.allocateMemory(_register, _local);
		this.offset = _local - _offset;
		return 0;
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment code = _factory.createFragment();
		for (Interface i : this.interfaces) {
			code.append(i.getCode(_factory));
		}
		for (Classe c : this.classes) {
			code.append(c.getCode(_factory));
		}
		code.append(princ.getCode(_factory));
		return code;
	}

}
