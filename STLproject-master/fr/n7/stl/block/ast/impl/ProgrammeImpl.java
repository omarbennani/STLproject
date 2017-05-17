package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Programme;
import fr.n7.stl.block.ast.MethodePrincipale;

public class ProgrammeImpl implements Programme{

	protected LinkedList<Interface> interfaces;
	protected LinkedList<Classe> classes;
	protected MethodePrincipale princ;
	
	public ProgrammeImpl(LinkedList<Interface> _interfaces,LinkedList<Classe> _classes, MethodePrincipale _princ) 
	{
			this.interfaces=_interfaces;
			this.classes=_classes;
			this.princ = _princ;
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

}
