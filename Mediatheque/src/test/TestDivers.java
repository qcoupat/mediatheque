package test;

import dao.Dao;
import metier.Livre;

public class TestDivers {

	public static void main(String[] args) {
		Livre livreTest = new Livre("L002");
		System.out.println("egalite = " + livreTest.equals(Dao.livres.get(0)));
		
		System.out.println(Dao.livres.indexOf(livreTest));
		
		Livre livreTrouve = Dao.livres.get(Dao.livres.indexOf(new Livre("L002")));
		System.out.println("trouve : " + livreTrouve);
	}
}
