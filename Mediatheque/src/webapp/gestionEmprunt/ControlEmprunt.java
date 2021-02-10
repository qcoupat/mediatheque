package webapp.gestionEmprunt;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import metier.Abonne;
import metier.Emprunt;
import metier.Livre;
import metier.tech.Abonnes;
import metier.tech.Emprunts;
import metier.tech.Livres;

/**
 * 
 * Controleur pour la gestion des emprunts
 */
@WebServlet(
		name = "ControlEmprunt", 
		description = "Controleur Emprunt", 
		urlPatterns = {"/emprunt/*"}
		)
public class ControlEmprunt extends HttpServlet {

	private static final long 	serialVersionUID = 1L;
	private RequestDispatcher 	disp;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// la verification de l'existence de l'abonne est faite dans le filtre

		// recuperation du choix
		String path = request.getPathInfo();
		System.out.println("1================  dans ControlEmprunt GET path=" + path );

		if (path == null || path.equals("/")) 		doAccueil(request, response);
		else if (path.equals("/liste")) 			doListe(request, response);
		else if (path.equals("/affiche")) 			doAfficheForm(request, response);
		else 										doError(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation du choix
		String path = request.getPathInfo();
		System.out.println("1================  dans ControlEmprunt POST path=" + path );

		if (path == null || path.equals("/")) 	doAccueil(request, response);
		else if (path.equals("/creer")) 		doCreer(request, response);
		else 									doError(request, response);
	}

	private void doCreer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEmprunt	= request.getParameter("idEmprunt").strip();
		String idAbonne		= request.getParameter("idAbonneE").strip();
		String dateEmprunt	= request.getParameter("dateEmprunt").strip();
		String[] idLivres 	= request.getParameterValues("idLivres");			

		// traitement idEmprunt
		int idEmp = 0;
		try {
			idEmp = Integer.parseInt(idEmprunt);
		}
		catch (NumberFormatException e) {
			// TODO: handle exception et envoyer message 
		}

		// traitement de la date emprunt 2020-xx-18
		//TODO catch de la date si format incorrect
		LocalDate dateEmp = LocalDate.now();
		if (!dateEmprunt.isBlank()) dateEmp = 
				LocalDate.parse(dateEmprunt, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		// traitement Abonne
		Abonne abonne = null;
		if (!idAbonne.isBlank()) abonne = new Abonne(idAbonne);
		else					 abonne = new Abonne("000","inconnu", "inconnu");

		// traitement livre
		ArrayList<Livre> livres = new ArrayList<Livre>();
		//TODO : normalement - refus de création de l'emprunt avec affichage message erreur "la saisie d'au moins un livre est obligatoire"
		if (idLivres != null && idLivres.length > 0) {
			for (String idLivre : idLivres) {
				if (!idLivre.isBlank()) livres.add(new Livre(idLivre));
			}
		}

		// creation de l'emprunt
		Emprunt emprunt = new Emprunt(idEmp);
		emprunt.setDateEmprunt(dateEmp);
		emprunt.setAbonne(abonne);
		emprunt.setLivres(livres);

		// ajouter l'emprunt à la liste (dans dao.Dao)
		Dao.emprunts.add(emprunt);

		// rediriger vers le formulaire emprunt
//		request.setAttribute("emprunt", emprunt);
//		RequestDispatcher disp = request.getRequestDispatcher("/emprunt/affiche");
//		disp.forward(request, response);
		doAfficheForm(request, response);
	}

	private void doAfficheForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation de la session
		Abonnes abonnes = new Abonnes(Dao.abonnes);
		Livres  livres  = new Livres(Dao.livres);
		request.setAttribute("abonnes", abonnes);
		request.setAttribute("livres", livres);
		String chemin = "/WEB-INF/vue/emprunt/formEmprunt.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(chemin);
		disp.forward(request, response);
	}

	private void doListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chemin = null;
		// si la liste est vide
		if (Dao.emprunts.size() == 0) {
			request.setAttribute("message", "La liste des emprunts est vide.");
			chemin = this.getServletContext().getInitParameter("pageError");
		}
		else {
			// on affiche la liste
			request.setAttribute("emprunts", new Emprunts(Dao.emprunts));
			chemin = "/WEB-INF/vue/emprunt/listeEmprunt.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(chemin);
		disp.forward(request, response);
	}

	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		disp = request.getRequestDispatcher("/index.jsp"); 
		disp.forward(request,response);
	}

	private void doError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("message", "Emprunt : Vous avez tripatouill&eacute; l'url!!! ");
		disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
		disp.forward(request,response);
	}

}
