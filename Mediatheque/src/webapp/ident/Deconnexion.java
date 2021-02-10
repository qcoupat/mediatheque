package webapp.ident;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/deconnexion")
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Suppression de l'abonne en session 
		HttpSession session = request.getSession(true);
		session.removeAttribute("abonne");
		// session.setAttribute("abonne", null);
		// session.invalidate();
		response.sendRedirect(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je suis dans deconnexion Post");
		request.setAttribute("message", "Url invalide !!");
		RequestDispatcher disp = request.getRequestDispatcher(this.getServletContext().getInitParameter("pageError"));
		disp.forward(request, response);
	}
}
