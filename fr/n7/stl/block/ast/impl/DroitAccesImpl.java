package fr.n7.stl.block.ast.impl;

import fr.n7.stl.block.ast.DroitAcces;

public class DroitAccesImpl implements DroitAcces{

	protected String droit;
	public DroitAccesImpl(int i) {
		switch (i)
		{
		case 0:
			droit="public";
		case 1:
			droit="protected";
		case 2:
			droit="private";
		}
	}

}
