/**
 * 
 */
package fr.n7.stl.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.ForbiddenDeclarationException;
import fr.n7.stl.block.ast.HierarchicalScope;

/**
 * @author pantel2
 *
 */
public class SymbolTableMethodes  {
	
	private List<Methode> methodes;

	public SymbolTable() {
		this.methodes = new LinkedList<Methode>();
	}

	public boolean containsMethode(String _name, String _nomClasse, List<Parametre> _parametres) 
	{
		//boolean resultat = true;
		for(Methode m : this.methodes)
		{
			if (m.getClassName().equals(_nomClasse) && m.getName().equals(_name))
			{
				List<Parametre> p = m.getParametres();
				if(p.size() == _parametres.size())
				{
					for(int i = 0; i< p.size(); i++)
					{
						if(!p.get(i).getType().equals(_parametres.get(i).getType()))
							break;
						if(i == p.size()-1)
							return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public Optional<Methode> getMethode(String _name, String _nomClasse, Arguments _arguments) {

		System.out.println("get " +_nomClasse + "." + _name);
		List<Methode> resultat  = new LinkedList<Methode>();
		for(Methode m : this.methodes)
		{
			if (m.getClassName().equals(_nomClasse) && m.getName().equals(_name))
			{
				List<Parametre> p = m.getParametres();
				List<Type> t = _arguments.getListType();
				if(p.size() == t.size())
				{
					for(int i = 0; i< p.size(); i++)
					{
						if(!p.get(i).getType().compatibleWith(t.get(i)))
							break;
						if(i == p.size()-1)
							resultat.add(m);
					}
				}
			}
		}
	
		if(resultat == 1)
		{
			return Optional.of(m);
		}
		else if (resultat == 0)
		{
			return Optional.empty();
		}
		else
		{
			System.out.println("Appel à la methode " + _nomClasse + "." + _name + " ambigu");
			return Optional.empty();
		}

	}


	public boolean acceptsMethode(String _name, String _nomClasse, Arguments _arguments) {
		// System.out.println("Accepts( " + _declaration.getName() + " )");
		return (! this.contains(_ name, _ nomClasse, _arguments);
	}

	@Override
	public void registerMethode(String _name, String _nomClasse, Arguments _arguments, Methode _methode) throws ForbiddenDeclarationException {
		 System.out.println("Register( " + _nomClasse + "."+ _name + " )");
		if (this.accepts(_ name, _ nomClasse, _arguments)) {
			this.methodes.add(m);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}

}
