package webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import metier.Abonne;

// Voir config de l'ordre d'execution des filtres dans web.xml (ordre d'ecriture)
@WebFilter ({"/abonne/*","/emprunt/*"})
public class LoginFilter implements Filter {

	private String pageErreur;
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		System.out.println("Dans LoginFilter");
		
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		// le numero de session est contenu dans la request
		Abonne abonne = (Abonne) requestHttp.getSession(true).getAttribute("abonne");
		if (abonne == null) {
			request.setAttribute("message", "Vous n'etes pas connect&eacute;. Acc&egrave;s impossible.");
			RequestDispatcher disp = request.getRequestDispatcher(pageErreur);
			disp.forward(request, response);
		}
		else {
			String path = requestHttp.getRequestURI();	

			// TODO : Datas en dur !!! Il faut mettre en place une gestion du profil utilisateur
			if (path.equals(requestHttp.getContextPath() + "/abonne/liste") && !"root".equals(abonne.getNom())) {
				request.setAttribute("message", "Vous devez &ecirc;tre administrateur. Acc&egrave;s impossible.");
				RequestDispatcher disp = request.getRequestDispatcher(pageErreur);
				disp.forward(request, response);
			}
			else {
				System.out.println("LoginFilter : on laisse passer : " + path);
				chain.doFilter(request, response);
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		ServletContext   context   = config.getServletContext() ;
	    pageErreur    =  context.getInitParameter("pageError");
	    
	}
}
