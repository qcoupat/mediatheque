package dao;

import java.util.ArrayList;

import metier.Abonne;
import metier.Emprunt;
import metier.Livre;
import metier.PassWord;

public class Dao {
	
	public static ArrayList<Emprunt> emprunts = new ArrayList<Emprunt>();
	public static ArrayList<Abonne>  abonnes  = initAbonnes();
	public static ArrayList<Livre>   livres   = initLivres();

	public static boolean supressionAbonne(String idAbonne) {
		boolean ok = false;
		Abonne abonne = new Abonne(idAbonne);
		int index = abonnes.indexOf(abonne);
		if (index != -1) {
			abonnes.remove(index);
			ok = true;
			// TODO : si abonne est celui de la session, remettre à jour la session
		}
		return ok;
	}
	
	
	public static boolean modifAbonne(Abonne abonne) {
		boolean ok = false;
		int index = abonnes.indexOf(abonne);
		if (index != -1) {
			abonnes.set(index, abonne);
			ok = true;
			// TODO : si abonne est celui de la session, remettre à jour la session
		}
		return ok;
	}
	
	public static Abonne getAbonne(String idAbonne) {
		Abonne abonne = new Abonne(idAbonne);
		return getAbonne(abonne);
	}
	public static Abonne getAbonne(Abonne abonne) {
		Abonne trouve = null;
		if (abonnes.contains(abonne)) trouve = abonnes.get(abonnes.indexOf(abonne));
		return trouve;
	}
	
	public static Abonne getAbonne(String nom, PassWord pw) {

		Abonne trouve = null;
		
		// recherche de l'abonne dans la liste
		// il faut coder la methode equals dans Abonne
		if (nom != null && pw != null) {
			for (Abonne abo : Dao.abonnes) {
				if (abo != null && nom.equals(abo.getNom()) && pw.verifPW(abo.getPw())) trouve = abo;
			}
		}
		return trouve;
	}
	
	public static Livre getLivre(String cote) {
		Livre livreTrouve = null;
		
		// recherche du livre dans la liste
		// il faut coder la methode equals dans Livre
		if (cote != null) {
			int index = livres.indexOf(new Livre(cote));
			if (index != -1) livreTrouve = livres.get(index);
		}
		
		// 2nd methode : recherche du livre dans la liste
		// pas besoin de equals
//		for (Livre livre : livres) {
//			if (livre.getCote().equals(cote)) livreTrouve = livre;
//		}
		
		return livreTrouve;
	}
	
	private static ArrayList<Livre> initLivres() {
		ArrayList<Livre> liste 	= new ArrayList<Livre>();
		liste.add(new Livre("L001", "Java pour les experts"));
		liste.add(new Livre("L002", "UML pour les experts"));
		liste.add(new Livre("L003", "Les tests pour les experts"));
		liste.add(new Livre("L004", "Vive les servlets"));
		liste.add(new Livre("L005", "POO pour tous"));
		return liste;
	}
	
	private static ArrayList<Abonne> initAbonnes() {
		ArrayList<Abonne> liste 	= new ArrayList<Abonne>();
		liste.add(new Abonne("A1", "Muller", "Dominique", new PassWord("1234"), "email1@test.fr"));
		liste.add(new Abonne("A2", null, "Paul", new PassWord("1234"), "email2@test.fr"));
		liste.add(new Abonne("A3", "Durand", "Jean Pierre", new PassWord("1234"), "email3@test.fr"));
		liste.add(new Abonne("A4", "LaChose", "Gertrude", new PassWord("1234"), "email4@test.fr"));
		liste.add(new Abonne("A5", "LeMachin", "Jacques", new PassWord("1234"), "email5@test.fr"));
		liste.add(new Abonne("A6", "root", "root", new PassWord("4321"), "root@test.fr"));
//		liste.add(null);
		return liste;
	}
}
