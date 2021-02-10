package metier;

public class Abonne {

	private String 		idAbonne;
	private String 		nom;
	private String 		prenom;
	private PassWord    pw;
	private String      email;
	
	// pour utilisation de la syntaxe <jsp:useBean .. />
	public Abonne() {
	}
	
	/**
	 * constructeur incorrect  
	 * en attente de l'implementation dans la base
	 * @param idAbonne
	 */
	public Abonne(String idAbonne) {
		this.idAbonne 	= idAbonne;
		this.nom 		= "inconnu";
	}
	
	public Abonne(String idAbonne, String nom, String prenom) {
		this.idAbonne 	= idAbonne;
		this.nom 		= nom;
		this.prenom 	= prenom;
	}
	public Abonne(String idAbonne, String nom, String prenom, PassWord pw) {
		this(idAbonne, nom, prenom);
		this.pw			= pw;
	}
	public Abonne(String idAbonne, String nom, String prenom, PassWord pw, String email) {
		this(idAbonne, nom, prenom, pw);
		this.email			= email;
	}

	public String getIdAbonne() {
		return idAbonne;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public PassWord getPw() {
		return pw;
	}
	public String getEmail() {
		return email;
	}

	public void setIdAbonne(String idAbonne) {
		this.idAbonne = idAbonne;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setPw(PassWord pw) {
		this.pw = pw;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object obj) {
		boolean retour = false;
		if (obj != null && obj instanceof Abonne) {
			Abonne abonne = (Abonne)obj;
			retour = abonne.getIdAbonne().equals(this.idAbonne) ;
		}
		return retour;
	}

	// l'affichage du pw est juste pour le développement !!!
	@Override
	public String toString() {
		return "Abonne [" + idAbonne + ", " + nom + ", " + prenom + ", " + email + ", " + pw +"]";
	}
	
}
