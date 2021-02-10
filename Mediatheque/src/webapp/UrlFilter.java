package webapp;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Voir config de l'ordre d'execution des filtres dans web.xml (ordre d'ecriture)
@WebFilter (urlPatterns = {"/*"})
public class UrlFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) 
			throws IOException, ServletException {

		HttpServletRequest  requestHttp  = (HttpServletRequest)  request;
		HttpServletResponse responseHttp = (HttpServletResponse) response;

		
//		String contexte 	= requestHttp.getContextPath();
		String chemin  		= requestHttp.getServletPath();
		System.out.println("Dans UrlFilter : " + chemin);
		
		/*
		 * Si l'url est / 						  on affiche la page accueil
		 * Si l'url commence par /abonne    	  on laisse passer (on continu le flux normal - Gestion Abonne)
		 * Si l'url commence par /emprunt         on laisse passer (on continu le flux normal - Gestion emprunt)
		 * Si l'url commence par /identification  on laisse passer (on continu le flux normal)
		 * Si l'url commence par /deconnexion     on laisse passer (on continu le flux normal)
		 * sinon 								  on redirige vers 404.jsp
		 * 
		 * Les controleurs de chaque domaine gèrent les patterns /gestion/* et /catalogue/*
		 */
		
		 /* Att : si une page index.* existe au niveau de WebContent, elle est automatiquement ajoutee au 
		 *    getServletPath() 
		 */
		if (chemin.equals("/") || chemin.equals("/index.jsp")) {
			RequestDispatcher disp = requestHttp.getRequestDispatcher("/index.jsp");
			disp.forward(requestHttp, responseHttp);
		}
		
		// pour assets
		else if (chemin.startsWith("/css/")  || chemin.startsWith("/img/") || 
				 chemin.startsWith("/scss/") || chemin.startsWith("/vendor/"))		chain.doFilter(requestHttp, responseHttp);
		
		// Pour les domaines de gestion
		else if (chemin.startsWith("/identification"))		chain.doFilter(requestHttp, responseHttp);
		else if (chemin.startsWith("/deconnexion"))			chain.doFilter(requestHttp, responseHttp);
		
		else if (chemin.startsWith("/abonne"))				{
			chain.doFilter(requestHttp, responseHttp);
		}
		else if (chemin.startsWith("/emprunt"))			{
			System.out.println("emprunt");
			chain.doFilter(requestHttp, responseHttp);
		}
		
		
		else {
			System.out.println("else");
			RequestDispatcher disp = requestHttp.getRequestDispatcher("/vue/error/page404.jsp");
			disp.forward(requestHttp, responseHttp);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

}
