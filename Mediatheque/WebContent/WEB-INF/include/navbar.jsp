<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="metier.Abonne" %>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
    <div class="container">
      <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav mx-auto">
          <li class="nav-item active px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="<%=request.getContextPath()%>/index.jsp">Accueil
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item dropdown px-lg-4">
            <a class="nav-link dropdown-toggle text-uppercase text-expanded" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Emprunt
            </a>
            <div class="dropdown-menu dropdown-menu-right " aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item text-uppercase text-expanded" href="<%=request.getContextPath()%>/emprunt/affiche">Creer un emprunt</a>
              <a class="dropdown-item text-uppercase text-expanded" href="<%=request.getContextPath()%>/emprunt/liste">Lister les emprunts</a>
            </div>
          </li>  
          <li class="nav-item dropdown px-lg-4">
            <a class="nav-link dropdown-toggle text-uppercase text-expanded" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
              Abonn&eacute;
            </a>
            <div class="dropdown-menu dropdown-menu-right " aria-labelledby="navbarDropdownBlog">
              <a class="dropdown-item text-uppercase text-expanded" href="<%=request.getContextPath()%>/abonne/affiche">Creer un abonn&eacute;</a>
              <a class="dropdown-item text-uppercase text-expanded" href="<%=request.getContextPath()%>/abonne/liste">Lister les abonn&eacute;</a>
            </div>
          </li>        
          <!-- debut login -->
          <li class="nav-item dropdown px-lg-4">
          	<a class="nav-link text-uppercase text-expanded dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Login
	        </a>
	        <div class="dropdown-menu dropdown-menu-right p-2" aria-labelledby="navbarDropdownBlog">
				<div class="">
					 <form id="identification" method="post" action="<%=request.getContextPath()%>/identification" accept-charset="UTF-8">
					 
							<div class="form-group">
								 <label class="sr-only" for="login">login</label>
								 <input type="text" class="form-control" id="login" name="login" placeholder="Login" value="Muller" required />
							</div>
							<div class="form-group">
								 <label class="sr-only" for="pw">Password</label>
								 <input type="password" class="form-control" id="pw" name="pw" placeholder="Password" value="1234" required />
							</div>
							<div class="form-group">
								 <button type="submit" class="btn btn-primary btn-block">Sign in</button>
							</div>
					 </form>
				</div>
				<div class="bottom text-center">
					New here ? <a href="#"><b>Join Us</b></a>
				</div>
			</div>
        </li>
        <!-- fin login -->
        <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" 
            	href="<%=request.getContextPath()%>/deconnexion">se deconnecter</a>
        </li>
        <!-- affichage prenom et nom -->
        <% 
			Abonne abonneSession = (Abonne)session.getAttribute("abonne");
			if (abonneSession != null)		 {					 
		%> 
		  <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" 
            	href="<%=request.getContextPath()%>/abonne/affiche"><%=abonneSession.getPrenom() %> <%=abonneSession.getNom() %></a>
          </li> 
		<% } %>
	      <li class="nav-item px-lg-4">
            <p class="nav-link text-uppercase text-expanded text-muted">TODO</p>
          </li> 
       </ul>
      </div>
    </div>
  </nav>