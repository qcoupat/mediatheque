<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="metier.Emprunt" %>
<%@ page import="metier.Livre" %>
<jsp:useBean id="abonnes" class="metier.tech.Abonnes" scope="request" />
<jsp:useBean id="livres"  class="metier.tech.Livres"  scope="request" />
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mediatheque</title>
  	<%-- Bootstrap core CSS et Custom styles for this template --%>
  	<%@ include file="/WEB-INF/include/bootstrapHeader.jsp" %>
  </head>
  <body>
  <h1 class="site-heading text-center text-white d-none d-lg-block">
    <span class="site-heading-upper text-primary mb-3">Le lieu qu'il vous faut</span>
    <span class="site-heading-lower">Creer un emprunt</span>
  </h1>

  <%-- Navigation --%>
  <%@ include file="/WEB-INF/include/navbar.jsp" %>

    <section class="page-section cta">
      <div class="container">
        <div class="row">
          <div class="mx-auto">
            <div class="cta-inner text-center rounded">
              <h2 class="section-heading mb-5">
                <span class="section-heading-upper">Creation</span>
                <span class="section-heading-lower">Emprunt</span>
              </h2>
              
              <div>	<!-- div formulaire -->
		      	<form action = "<%=request.getContextPath()%>/emprunt/creer" method="post">
		      	  <div class="row">
					  <div class="form-group col-6">
					    <label for="idEmprunt">Emprunt</label>
					    <input type="number" class="form-control" id="idEmprunt" name="idEmprunt" placeholder="Identifiant emprunt"  value="1">
					  </div>
					  <div class="form-group col-6">
							<label 	for="idAbonneE">Abonn&eacute; :</label> 
							<select class="form-control" id="idAbonneE" name="idAbonneE">
							  <% for (Abonne abonne : abonnes) { %>	
							  	<% if (abonne != null) { %>
								        <option value="<%=abonne.getIdAbonne() %>">
								        	<%=abonne.getIdAbonne() + "-" + abonne.getPrenom() + " " + abonne.getNom() %>
								        </option>
								 <% } %>
							   <% } %>
						    </select>
					  </div>
				   </div>
				   <div class="row">
					  <div class="form-group col-6">
					    <label for="dateEmprunt">Date emprunt</label>
					    <input type="date" class="form-control" id="dateEmprunt" name="dateEmprunt">
					  </div>
					  
					  <div class="form-group col-6">
							<label 	for="idLivres">Livres : (5 max)</label> 
							<select class="form-control" multiple id="idLivres" name="idLivres">
							  <% for (Livre livre : livres) { %>	
							  	<% if (livre != null) { %>
								        <option value="<%=livre.getCote() %>">
								        	<%=livre.getTitre() %>
								        </option>
								 <% } %>
							   <% } %>
						    </select>
					  </div>
				  </div>
				  <br />
				  <button type="submit" class="btn btn-primary">Cr&eacute;er l'emprunt</button>
				</form>
			  </div>  <!-- fin div formulaire -->
			  <!-- affichage du message -->
				  <% Emprunt emprunt = (Emprunt)request.getAttribute("emprunt");
					 if (emprunt != null) {
				  %>
				  		<div class="toast">
						    <div class="toast-header">
						        <strong class="mr-auto"><i class="fa fa-grav"></i> Message</strong>
						        <small>derniere action</small>
						        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
						    </div>
						    <div class="toast-body">
						        L'emprunt num&eacute;ro <%= emprunt.getIdEmprunt() %> a &eacute;t&eacute; cr&eacute;&eacute;.
						    </div>
						</div>
				  <%		 
					 } else {
					%>
						 <p>&nbsp;</p>
					<%
					 }
				  	%>
            </div>
          </div>
        </div>
      </div>
    </section>

 
  <%-- Bootstrap core JavaScript --%>
  <%@ include file="/WEB-INF/include/footer.jsp" %>

  <%-- Bootstrap core JavaScript --%>
  <%@ include file="/WEB-INF/include/bootstrapFooter.jsp" %>

    <!-- Script to highlight the active date in the hours list -->
    <script>
      $('.list-hours li').eq(new Date().getDay()).addClass('today');
    </script>
    
    <script>
		$(document).ready(function(){
			$('.toast').toast({delay: 3000});
			$('.toast').toast('show');
		});
	</script>

  </body>

</html>
