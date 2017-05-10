package fr.n7.stl.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.n7.stl.block.ast.Declaration;
import fr.n7.stl.block.ast.ForbiddenDeclarationException;
import fr.n7.stl.block.ast.FunctionDeclaration;
import fr.n7.stl.block.ast.HierarchicalScope;
import fr.n7.stl.block.ast.Parametre;

public class FunctionSymbolTable extends SymbolTable {
	
	private Map<Pair<String, List<Parametre>>, Declaration> declarations;
	private Optional<SymbolTable> context;
	
	public FunctionSymbolTable() {
		this.declarations = new HashMap<Pair<String, List<Parametre>>, Declaration>();
		this.context = Optional.empty();
	}
	
	public FunctionSymbolTable(SymbolTable _context) {
		this();
		if (_context != null) {
			this.context = Optional.of(_context);
		}
	}
	
	public Optional<Declaration> get(String _name) {
		return Optional.empty();
	}
	
	@Override
	public Optional<Declaration> get(String _name, List<Parametre> _params) {
		Pair<String, List<Parametre>> p = new Pair<String, List<Parametre>>(_name, _params);
		if (this.declarations.containsKey(p)) {
			return Optional.of(this.declarations.get(p));
		} else {
			if (this.context.isPresent()) {
				return this.context.get().get(_name);
			} else {
				return Optional.empty();
			}
		}
	}
	
	public boolean contains(String _name, List<Parametre> _params) {
		Pair<String, List<Parametre>> p = new Pair<String, List<Parametre>>(_name, _params);
		// System.out.println("Contains( " + _name + " )");
		return (this.declarations.containsKey(p));
	}
	
	@Override
	public boolean accepts(Declaration _declaration) {
		// System.out.println("Accepts( " + _declaration.getName() + " )");
		if (!(_declaration instanceof FunctionDeclaration))
			return false;
		return (! this.contains(((FunctionDeclaration)_declaration).getName(), ((FunctionDeclaration)_declaration).getParametres()));
	}
	
	@Override
	public void register(Declaration _declaration) throws ForbiddenDeclarationException {
		// System.out.println("Register( " + _declaration.getName() + " )");
		if (this.accepts(_declaration)) {
			FunctionDeclaration fd = ((FunctionDeclaration)_declaration);
			Pair<String, List<Parametre>> p = new Pair<String, List<Parametre>>(fd.getName(), fd.getParametres());
			this.declarations.put(p, _declaration);
		} else {
			throw new ForbiddenDeclarationException();
		}
	}

	public boolean knows(String _name, List<Parametre> _params) {
		// System.out.println("Knows( " + _name + " )");
		return this.contains(_name, _params);
	}
	
}
