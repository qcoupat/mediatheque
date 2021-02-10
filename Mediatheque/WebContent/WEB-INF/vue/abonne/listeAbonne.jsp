<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="metier.Abonne" %>
<%@ page import="java.util.ArrayList" %>
<jsp:useBean id="abonne" class="metier.Abonne" scope="session" />
<% ArrayList<Abonne> abonnes = (ArrayList<Abonne>) request.getAttribute("abonnes"); %>
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
    <span class="site-heading-lower">Lister les abonn&eacute;s</span>
  </h1>

  <%-- Navigation --%>
  <%@ include file="/WEB-INF/include/navbar.jsp" %>

  <section class="page-section about-heading">
    <div class="container-fluid">
      <div class="about-heading-content mt-3">
        <div class="row">
          <div class="col-xl-9 col-lg-10 mx-auto">
            <div class="bg-faded rounded p-5">
              	<h2 class="section-heading mb-4">
	                <span class="section-heading-upper">Liste</span>
	                <span class="section-heading-lower">abonn&eacute;s</span>
              	</h2>

		  	  	<h3>Bonjour <%= abonne.getPrenom() %> <%= abonne.getNom() %></h3>


				<!-- ecrire les lignes -->
				<form method="post" action="#">
					<table class="table">
						<thead><tr><th></th><th>IdAbonne</th><th>Nom</th><th>Pr&eacute;nom</th><th>Email</th></tr></thead>
						<% for (Abonne abo : abonnes) { %>
							<tr>
								<td><input name="sel" type="radio" value="<%= abo.getIdAbonne() %>"></td>
								<td><%= abo.getIdAbonne() %>		</td>
								<td><%= abo.getNom() %>			</td>
								<td><%= abo.getPrenom() %>		</td>
								<td><%= abo.getEmail() %>		</td>
							</tr>
						<% }%>
					</table>
					<button id="btnSupression" formaction="<%= request.getContextPath() %>/abonne/supprimer">Supprimer</button>
				</form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <%-- Bootstrap core JavaScript --%>
  <%@ include file="/WEB-INF/include/footer.jsp" %>

  <%-- Bootstrap core JavaScript --%>
  <%@ include file="/WEB-INF/include/bootstrapFooter.jsp" %>

</body>
</html>


	