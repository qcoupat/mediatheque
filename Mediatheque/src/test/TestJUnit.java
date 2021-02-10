package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dao.Dao;
import metier.Abonne;
import metier.Livre;

class TestJUnit {

	@DisplayName("Test equals dans Livre - cas nominal")
	@Test
	void test1() {
		Livre livreTest = new Livre("L002");
		assertTrue(livreTest.equals(Dao.livres.get(1)));
	}
	@DisplayName("Test equals dans Livre - alternatif")
	@Test
	void test1a() {
		Livre livreTest = new Livre("L002");
		assertFalse(livreTest.equals(Dao.livres.get(2)));
	}
	
	@DisplayName("Test methode getLivre dans Dao")
	@Test
	void test2() {
		Livre livreTest = new Livre("L002");
		assertEquals(livreTest, Dao.getLivre("L002"));
	}
	
	@DisplayName("Test equals dans Abonne")
	@Test
	void test3() {
		Abonne abonne = new Abonne("A1");
		assertTrue(abonne.equals(Dao.abonnes.get(0)));
	}
	
	
	@DisplayName("Test methode getAbonne dans Dao")
	@Test
	void test4() {
		Abonne abonne = new Abonne("A1");
		assertEquals(abonne, Dao.getAbonne("A1"));
	}

	@DisplayName("Test methode getAbonne(String idAbonne) dans Dao")
	@Test
	void test5() {
		Abonne abonne = new Abonne("A1");
		assertEquals(abonne, Dao.getAbonne("A1"));
	}
	@DisplayName("Test methode getAbonne(String idAbonne) dans Dao avec idAbonne inexistant")
	@Test
	void test6() {
		assertEquals(null, Dao.getAbonne("99"));
	}
}
