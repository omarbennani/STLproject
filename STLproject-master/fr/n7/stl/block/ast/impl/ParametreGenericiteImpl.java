package fr.n7.stl.block.ast.impl;

import java.util.List;

import fr.n7.stl.block.ast.Objet;
import fr.n7.stl.block.ast.ParametreGenericite;

public class ParametreGenericiteImpl implements ParametreGenericite{

	protected String _name;
	protected List<Objet> _param;
	public ParametreGenericiteImpl(String _name, List<Objet> _param) {
		this._name=_name;
		this._param=_param;
	}
	public ParametreGenericiteImpl(List<Objet> _param2) {
		this._param=_param2;
	}
	@Override
	public String getName() {
		return _name;
	}

	@Override
	public boolean equals(Object o)
	{
		if (o instanceof ParametreGenericiteImpl)
		{
			ParametreGenericiteImpl p = (ParametreGenericiteImpl) o;
			if(this.name.equals(p.getName))
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

	public String toString() {
		String res= this._name+" ";
		for (Objet o:this._param){
			res+=o.toString()+" ";
		}
		return res;
	}
}
