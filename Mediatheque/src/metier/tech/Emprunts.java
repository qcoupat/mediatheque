package metier.tech;

import java.util.ArrayList;

import metier.Emprunt;

public class Emprunts extends ArrayList<Emprunt> {

	public Emprunts() {
	}
	
	public Emprunts(ArrayList<Emprunt> emprunts) {
		this.addAll(emprunts);
	}

	private static final long serialVersionUID = 1L;
}
