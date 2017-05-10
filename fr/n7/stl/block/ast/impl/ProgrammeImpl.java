package fr.n7.stl.block.ast.impl;

import java.util.ArrayList;
import java.util.List;

import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.Interface;
import fr.n7.stl.block.ast.Programme;

public class ProgrammeImpl implements Programme{

	protected List<Interface> _interfaces;
	protected List<Classe> _classes;
	
	public ProgrammeImpl(List<Interface> _interfaces2,List<Classe> _classes2) {
		this._interfaces=new ArrayList<Interface>();
		if (_interfaces2!=null)
			this._interfaces=_interfaces2;
		this._classes=new ArrayList<Classe>();
		if (_classes2!=null)
			this._classes=_classes2;
	}
	public void addClasse(Classe _classe){
		this._classes.add(_classe);
	}
	public void addInterface(Interface _interface){
		this._interfaces.add(_interface);
	}

}
