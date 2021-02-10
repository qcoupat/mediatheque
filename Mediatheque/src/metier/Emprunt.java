package metier;

import java.time.LocalDate;
import java.util.ArrayList;

public class Emprunt {
	
	private int 				idEmprunt;
	private Abonne 				abonne;
	private ArrayList<Livre> 	livres;
	private LocalDate 			dateEmprunt;	
	
	public Emprunt(int idEmprunt, Abonne abonne) {
		this.idEmprunt 		= idEmprunt;
		this.abonne 		= abonne;
	//	this.setLivres(new ArrayList<Livre>());
		this.livres = new ArrayList<Livre>();
		this.dateEmprunt 	= LocalDate.now();
	}

	public Emprunt(int idEmprunt) {
		this.idEmprunt 		= idEmprunt;
		this.livres = new ArrayList<Livre>();
		this.dateEmprunt = LocalDate.now();
	}

	public int getIdEmprunt() {
		return idEmprunt;
	}

	public Abonne getAbonne() {
		return abonne;
	}

	public LocalDate getDateEmprunt() {
		return dateEmprunt;
	}

	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}

	public void setAbonne(Abonne abonne) {
		this.abonne = abonne;
	}

	public void setDateEmprunt(LocalDate dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}


	public ArrayList<Livre> getLivres() {
		return livres;
	}

	public void setLivres(ArrayList<Livre> livres) {
		this.livres = livres;
	}
	

	@Override
	public String toString() {
		return "Emprunt [ " + idEmprunt + ", Abonne=" + abonne
				+ ", livres=" + livres + ", dateEmprunt=" + dateEmprunt 
				+ "]";
	}
}

	
