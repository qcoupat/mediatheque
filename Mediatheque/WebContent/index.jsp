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
            <span class="section-heading-upper">Un livre pour No&euml;l</span>
            <span class="section-heading-lower">Abonnements</span>
          </h2>
          <p class="mb-3">Offrez un acc&egrave;s annuel &agrave; vos proches dans ce lieu calme et rafraichissant.
          </p>
          <div class="intro-button mx-auto">
            <a class="btn btn-primary btn-xl" href="#">Abonnements</a>
          </div>
        </div>
      </div>
    </div>
  </section>

  <section class="page-section cta">
    <div class="container">
      <div class="row">
        <div class="col-xl-9 mx-auto">
          <div class="cta-inner text-center rounded">
            <h2 class="section-heading mb-4">
              <span class="section-heading-upper">Notre promesse</span>
              <span class="section-heading-lower">pour vous</span>
            </h2>
            <p class="mb-0">Lorsque vous entrez dans notre m&eacute;diath&egrave;que pour commencer votre journÃ©e, 
            	nous nous engageons Ã  vous offrir un service amical, une atmosphÃ¨re accueillante et, 
            	par-dessus tout, d'excellents livres choisis avec soin. 
            	Si vous n'Ãªtes pas satisfait, faites-le nous savoir et nous ferons tout notre possible pour que les choses se passent bien!</p>
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
