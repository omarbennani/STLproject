package fr.n7.stl.block.ast.impl;

import java.util.List;
import java.util.LinkedList;

import fr.n7.stl.block.ast.Type;
import fr.n7.stl.block.ast.ParametreGenericite;

public class ParametreGenericiteImpl implements ParametreGenericite{

	protected String name;
	protected LinkedList<Type> param;

	public ParametreGenericiteImpl(String _name, LinkedList<Type> _param) {
		this.name=_name;
		this.param=_param;
	}
	public ParametreGenericiteImpl(LinkedList<Type> _param2) {
		this.param=_param2;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof ParametreGenericiteImpl)
		{
			ParametreGenericiteImpl p = (ParametreGenericiteImpl) o;
			if(this.name.equals(p.getName()))
			{
				//On pourrait ici vérifier si ils étendent les même objets mais cette méthode a été redéfinie au départ pour pouvoir vérifier que dans une regle généricité, un identifiant de paramètres ne soit pas défini deux fois. cad pour interdire 
//Class Voiture <T, S, T> 2 X T
				return true;
			}
			else
				return false;
		}
		else
			return false;
	}

	public String toString() 
	{
		String res= this.name+" ";
		if(this.param != null)
		{
			res += "extends ";
			for (Type o:this.param)
			{
				res+=o.toString()+" ";
			}
		}
		return res;
	}
}
