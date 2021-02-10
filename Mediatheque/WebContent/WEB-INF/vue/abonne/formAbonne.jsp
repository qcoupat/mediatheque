<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="metier.Abonne" %>
<%-- attention, il faut un constructeur par default --%>
<jsp:useBean id="abonne" class="metier.Abonne" scope="session" />
<jsp:useBean id="abonneFormulaire" class="metier.Abonne" scope="request" />
<jsp:useBean id="message" class="java.lang.String" scope="request" />
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
    <span class="site-heading-lower">Espace Abonn&eacute;</span>
  </h1>

  <%-- Navigation --%>
  <%@ include file="/WEB-INF/include/navbar.jsp" %>

    <section class="page-section cta">
      <div class="container">
        <div class="row">
          <div class="mx-auto">
            <div class="cta-inner text-center rounded">
              <h2 class="section-heading mb-5">
                <span class="section-heading-upper">Modifier vos</span>
                <span class="section-heading-lower">Coordonn&eacute;es</span>
              </h2>
              
              <div>	<!-- div formulaire -->
		      	<form action = "<%=request.getContextPath()%>/modificationAbonne" method="post">
		      	  <div class="row">
					  <div class="form-group col-4">
					    <label for="idAbonne">Abonn&eacute;</label>
					    <input readonly type="text" id="idAbonne" name="idAbonne"
					    	class="form-control" placeholder="Identifiant abonne"  value="<%=abonneFormulaire.getIdAbonne() %>">
					  </div>
					  <div class="form-group col-4">
					    <label for="nom">Nom</label>
					    <input readonly type="text" class="form-control" id="nom" name="nom" value="<%=abonneFormulaire.getNom() %>">
					  </div>
					  <div class="form-group col-4">
					    <label for="nom">Pr&eacute;nom</label>
					    <input readonly type="text" class="form-control" id="prenom" name="prenom" value="<%=abonneFormulaire.getPrenom() %>">
					  </div>
					  <div class="form-group col-4">
					    <label for="nom">Adresse electronique</label>
					    <input type="email" class="form-control" id="email" name="email" value="<%=abonneFormulaire.getEmail() %>">
					  </div>
					  <div class="form-group col-4">
					    <label for="nom">Mot de passe</label>
					    <input type="text" class="form-control" id="pw" name="pw" value="<%=abonneFormulaire.getPw().decode() %>">
					  </div>
					  
				  </div>
				  <br />
				  <div class="form-row">
					<div class="form-group">
						<button class="d-none btn btn-primary btn-sm" formaction="<%=request.getContextPath() %>/abonne/creer">Ajouter</button>
						<button class="btn btn-primary btn-sm" formaction="<%=request.getContextPath() %>/abonne/modifier">Modifier</button>
						<button class="d-none btn btn-primary btn-sm" formaction="<%=request.getContextPath() %>/abonne/supprimer">Supprimer</button>
						<button class="btn btn-primary btn-sm" type="reset">Clear</button>
					</div>
				</div>
				</form>
			  </div>  <!-- fin div formulaire -->
			  <!-- affichage du message -->
				  <% 
					 if (!message.isBlank()) {
				  %>
				  		<div class="toast">
						    <div class="toast-header">
						        <strong class="mr-auto"><i class="fa fa-grav"></i> Message</strong>
						        <small>derniere action</small>
						        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast">&times;</button>
						    </div>
						    <div class="toast-body">
						        <%= message %>
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
