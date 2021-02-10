package metier;

public class Livre {

	private String 		cote;
	private String 		titre;

	/**
	 * constructeur incorrect  
	 * en attente de l'implementation dans la base
	 * @param cote
	 */
	public Livre(String cote) {
		this.setCote(cote);
		this.setTitre("titre inconnu");
	}
	
	public Livre(String cote, String titre) {
		this.setCote(cote);
		this.setTitre(titre);
	}

	
	@Override
	public String toString() {
		return "Livre [" + getCote() 		+ "," + getTitre() 		 +  "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj != null && obj instanceof Livre) {
			Livre livre = (Livre)obj;
			retour = livre.getCote().equals(this.cote) ;
		}
		return retour;
	}

	
	// Getter et Setter   =================================================
	
	public String getCote() {
		return cote;
	}

	public void setCote(String cote) {
		this.cote = cote;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}