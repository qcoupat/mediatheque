package webapp.gestionAbonne;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import metier.Abonne;
import metier.PassWord;

/**
 * Servlet implementation class ControlAbonne
 * 
 * Controleur pour la gestion Abonne
 */
@WebServlet(
		name = "ControlAbonne", 
		description = "Controleur Abonne", 
		urlPatterns = {"/abonne/*"}
		)
public class ControlAbonne extends HttpServlet {

	private static final long 	serialVersionUID = 1L;
	private RequestDispatcher 	disp;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// recuperation du choix
		String path = request.getPathInfo();
		System.out.println("2================  dans ControlAbonne path=" + path );

		if 		(path == null || path.equals("/")) 		doAccueil(request, response);
		else if (path.equals("/affiche")) 				doAfficheform(request, response);
		else if (path.equals("/liste")) 				doListe(request, response);
		else {
			request.setAttribute("message", "Gestion : Vous avez tripatouill&eacute; l'url!!! ");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
			disp.forward(request,response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation du choix
		String path = request.getPathInfo();
		System.out.println("2================  dans ControlAbonne path=" + path );

		if 		(path == null || path.equals("/")) 		doAccueil(request, response);
		else if (path.equals("/modifier")) 				doModifier(request, response);
		else if (path.equals("/supprimer")) 			doSupprimer(request, response);
		else {
			request.setAttribute("message", "Gestion : Vous avez tripatouill&eacute; l'url!!! ");
			disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError")); 
			disp.forward(request,response);
		}
	}

	private void doSupprimer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "");
		// recuperation des donnees
		String idAbonne		= request.getParameter("sel").strip();

		// suppression de l'abonne dans la liste
		boolean ok = Dao.supressionAbonne(idAbonne);

		//rediriger vers le formulaire
		if (ok) request.setAttribute("message", "L'abonne " + idAbonne + " a été supprim&eacute;");
		else	request.setAttribute("message", "L'abonne "+ idAbonne + " n'existe pas");

		doListe(request, response);
	}

	private void doModifier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "");

		// recuperation des donnees
		String idAbonne		= request.getParameter("idAbonne").strip();
		String nom			= request.getParameter("nom").strip();
		String prenom		= request.getParameter("prenom").strip();
		String email		= request.getParameter("email").strip();
		String pw			= request.getParameter("pw").strip();

		// Creation de l'objet 
		Abonne abonne = new Abonne(idAbonne, nom, prenom, new PassWord(pw), email);
		// modification de l'abonne dans la liste
		boolean ok = Dao.modifAbonne(abonne);

		// rediriger vers le formulaire
		request.setAttribute("abonne", abonne);
		if (ok) request.setAttribute("message", "L'abonne " + abonne.getIdAbonne() + " a été modifi&eacute;");
		else	request.setAttribute("message", "L'abonne n'existe pas");

		doAfficheform(request, response);
	}


	private void doListe(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String chemin = null;
		// si la liste est vide
		if (Dao.abonnes.size() == 0) {
			request.setAttribute("message", "La liste des abonnes est vide.");
			chemin = this.getServletContext().getInitParameter("pageError");
		}
		else {
			// on affiche la liste
			request.setAttribute("abonnes", Dao.abonnes);
			chemin = "/WEB-INF/vue/abonne/listeAbonne.jsp";
		}
		RequestDispatcher disp = request.getRequestDispatcher(chemin);
		disp.forward(request, response);
	}

	private void doAfficheform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperation de la session
		HttpSession session = request.getSession(true);
		Abonne abonneSession = (Abonne) session.getAttribute("abonne");
		// recuperation de l'abonne dans la liste (pour avoir acces a toutes les datas)
		Abonne abonne = Dao.getAbonne(abonneSession.getIdAbonne());
		
		request.setAttribute("abonneFormulaire", abonne);
		String chemin = "/WEB-INF/vue/abonne/formAbonne.jsp";

		RequestDispatcher disp = request.getRequestDispatcher(chemin);
		disp.forward(request, response);
	}
	
	private void doAccueil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		disp = request.getRequestDispatcher("/index.jsp"); 
		disp.forward(request,response);
	}
}
