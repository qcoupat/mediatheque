package metier.tech;

import java.util.ArrayList;

import metier.Livre;

public class Livres extends ArrayList<Livre>{

	public Livres() {
	}
	public Livres(ArrayList<Livre> livres) {
		this.addAll(livres);
	}

	private static final long serialVersionUID = 1L;

}
