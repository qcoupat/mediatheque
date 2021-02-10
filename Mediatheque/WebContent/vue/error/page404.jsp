<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

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
    <span class="site-heading-lower">M&eacute;diath&egrave;que</span>
  </h1>

  <%-- Navigation --%>
  <%@ include file="/WEB-INF/include/navbar.jsp" %>

  <section class="page-section clearfix">
    <div class="container">
      <div class="intro">
        <img class="intro-img img-fluid mb-3 mb-lg-0 rounded" src="<%=request.getContextPath()%>/img/intro.jpg" alt="">
        <div class="intro-text left-0 text-center bg-faded p-5 rounded">
          <h2 class="section-heading mb-4">
            <span class="section-heading-upper">Attention</span>
            <span class="section-heading-lower">Page 404</span>
          </h2>
          <h1 class="mb-3">Cette page n'existe plus.</h1>
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
