<%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="metier.Abonne" %>
<%@ page import="metier.Emprunt" %>
<%@ page import="metier.Livre" %>
<jsp:useBean id="abonne"   class="metier.Abonne" 		scope="session" />
<jsp:useBean id="emprunts" class="metier.tech.Emprunts" scope="request" />
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
    <span class="site-heading-lower">Lister les emprunts</span>
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
	                <span class="section-heading-lower">Emprunts</span>
                </h2>
                <%-- si on arrive ici, c'est que l'abonne existe --%>
				<h3>Bonjour <%= abonne.getPrenom() %> <%= abonne.getNom() %></h3>

				<!-- ecrire les lignes emprunts -->
				<table  class="table">
					<thead><tr><th>IdEmprunt</th><th>IdAbonne</th><th>Date Emprunt</th><th>Livres</th></tr></thead>
					
					<%-- de la forme : <tr><td>123</td><td>A1</td><td>20-12-2020</td><td>L001, L002, L003</td></tr> --%>
					<% for (Emprunt emprunt : emprunts) { %>
							<tr>
								<td><a href="<%= request.getContextPath() %>/detail?ref=<%= emprunt.getIdEmprunt() %>">
						  			<%= emprunt.getIdEmprunt() %></a></td>
							    <td><%= emprunt.getAbonne().getIdAbonne() %></td>
							    <td><%= emprunt.getDateEmprunt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) %></td>
							    <td>
						
							<%	for (Livre livre : emprunt.getLivres()) { //L001 L002 L003 %>
										<%= livre.getCote() %>
							<%	} %>
								</td>
							</tr>
					<%	} %>
				</table>
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


	