/**
 * 
 */
package fr.n7.stl.block.ast.impl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.n7.stl.block.ast.AtomicType;
import fr.n7.stl.block.ast.Parametre;
import fr.n7.stl.block.ast.Signature;
import fr.n7.stl.block.ast.Type;

/**
 * Implementation of the Abstract Syntax Tree node for a pointer access expression.
 * @author Marc Pantel
 *
 */
public class SignatureImpl implements Signature {

	protected String identificateur ;
	protected Boolean _final;
	protected Type type_retour;
	protected List<Parametre> parametres;
	protected String interfaceName;

	public SignatureImpl()
	{
		this.parametres = new LinkedList<Parametre> ();
	}
	public SignatureImpl(String _identificateur, LinkedList<Parametre> _parametres, String _interfaceName)
	{
		this.identificateur = _identificateur;
		this.type_retour = AtomicType.VoidType;
		this.parametres = _parametres;
		this.interfaceName = _interfaceName;
	}

	public SignatureImpl(Type _type_retour, String _identificateur, LinkedList<Parametre> _parametres, String _interfaceName)
	{
		this.identificateur = _identificateur;
		this.type_retour = _type_retour;
		this.parametres = _parametres;
		this.interfaceName = _interfaceName;
	}

	@Override
	public String getName()
	{
		return this.identificateur;
	}
	
	@Override
	public String getInterfaceName()
	{
		return this.interfaceName;
	}

	@Override
	public List<Parametre> getParametres()
	{
		return this.parametres;
	}
	@Override
	public String toString()
	{
		String local = new String();
		Iterator<Parametre> itr= this.parametres.iterator();
		while(itr.hasNext())
		{
			Parametre p = itr.next();
			local += p.toString() + ",";
		}
		return new String(this.type_retour.toString()+" "+ this.identificateur+"("+ local +"); \n");
	}

	@Override
	public void setFinal(boolean b)
	{
		this._final = b;
	}

}
