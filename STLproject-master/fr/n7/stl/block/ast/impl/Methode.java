package fr.n7.stl.block.ast.impl;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.Classe;
import fr.n7.stl.block.ast.DroitAcces;
import fr.n7.stl.block.ast.ElementClasse;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.impl.TAMFactoryImpl;

/**
 * Implementation of the Abstract Syntax Tree node for a method declaration instruction.
 *
 */
public class Methode implements ElementClasse {

	protected DroitAcces droitAcces;
	protected String nom;
	protected String nomClasse;
	protected List<Parametre> param;
	protected Block exp;
	protected Type typeRet;
	protected boolean finaL, statiC;
	protected String etiquette;
	private Parametre thiS;
	private Classe classe;
	
	public Methode(DroitAcces _droit, String _name, List<Parametre> _param2, Block _exp2, String _nomClasse) {
		this.droitAcces=_droit;
		this.nom=_name;
		this.param=_param2;
		this.exp=_exp2;		
		this.typeRet = AtomicType.VoidType;
		this.finaL = false;
		this.statiC = false;
		this.nomClasse = _nomClasse;
		TAMFactory _factory = new TAMFactoryImpl();
		int _labelNumber = _factory.createLabelNumber();
		this.etiquette = this.nom + _labelNumber;
		_factory = null;
	}
	
	public Methode(DroitAcces _droit, Type _type, List<Parametre> _param2, String _name, Block _exp2, String _nomClasse) {
		this.droitAcces=_droit;
		this.nom=_name;
		this.param=_param2;
		this.exp=_exp2;
		this.typeRet=_type;
		this.finaL = false;
		this.statiC = false;
		this.nomClasse = _nomClasse;
		TAMFactory _factory = new TAMFactoryImpl();
		int _labelNumber = _factory.createLabelNumber();
		this.etiquette = this.nom + _labelNumber;
		_factory = null;
	}
	
	@Override
	public String toString() {
		String _local = "";
	
		if(this.droitAcces == DroitAcces.publique)
				_local = "public " +this.typeRet.toString()+ " " +this.nom + "(";
		else if(this.droitAcces == DroitAcces.prive)
			_local = "private " +this.typeRet.toString()+ " " +this.nom + "(";
		else
			_local = "protected " +this.typeRet.toString()+ " " + this.nom + "(";

		for (Parametre p : this.param) {
			_local+= p.toString()+",";
		}
		_local+="){";
		_local+= this.exp.toString();
		_local+="}";
		return _local;
	}
	
	@Override
	public void setThis(Parametre _this) {
		this.thiS = _this;
	}
	
	public Parametre getThis() {
		return this.thiS;
	}

	@Override
	public void setFinal(boolean _final) {
		this.finaL = _final;
	}
	
	@Override
	public void setStatic(boolean _static) {
		this.statiC = _static;
	}

	@Override
	public String getName() {
		return this.nom;
	}

	@Override
	public Type getType() {
		return this.typeRet;
	}
	
	public boolean checkType() {
		return this.exp.checkType();
	}
	
	public Type getTypeReel() {
		return this.getType();
	}

	public List<Parametre> getParametres() {
		return this.param;
	}
	
	public String getClassName() {
		return this.nomClasse;
	}
	
	public boolean signatureEquals(Signature s) {
		boolean result = true;
		if (s.getName().equals(nom)) {
			List<Parametre> parametresS = s.getParametres();
			int size = parametresS.size();
			if (size == this.param.size()) {
				if (size == 0)
					return true;
				for (int i = 0; i < size && result; i++) {
					if (!parametresS.get(i).getType().equals(this.param.get(i)))
						result = false;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}
	
	public String getEtiquette(){
		return this.etiquette;
	}
	
	@Override
	public void setClasse(Classe _classe) {
		this.classe = _classe;
		this.thiS.setType(this.classe.getType());
	}
	
	public boolean isStatic() {
		return this.statiC;
	}
	
	@Override
	public Fragment getCode(TAMFactory _factory) {
		Fragment _res=_factory.createFragment();
		int tailleDesArguments = 0;
		for (Parametre p : this.param) {
			tailleDesArguments += p.getType().length();
		}
		if (!this.statiC) {
			tailleDesArguments += 1;
		}
		_res.append(exp.getCode(_factory));
		_res.add(_factory.createReturn(typeRet.length(), tailleDesArguments));
		_res.addPrefix(this.etiquette + ":");
		return _res;
	}

	@Override
	public int allocateMemory(Register _register, int _offset) {
		int _local = -1;
		List<Parametre> parametres = new LinkedList<Parametre>(this.param);
		Collections.reverse(parametres);
		for (Parametre p : parametres) {
			_local -= p.allocateMemory(Register.LB, _local);
		}
		_local -= this.thiS.allocateMemory(Register.LB, _local);
		this.exp.allocateMemory(Register.LB, 0);
        return 0;
	}
}
