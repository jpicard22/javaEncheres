<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html lang="fr">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Accueil</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans:wght@300;400;600;700;800;900&display=swap"
    rel="stylesheet">
    <!-- Css Styles -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/magnific-popup.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/slicknav.min.css" type="text/css">
	<link href="<%=request.getContextPath()%>/css/styleAccueil.css" rel="stylesheet">
	
</head>

<body>
    <!-- Page préchargée -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Offcanvas Menu Begin -->
    <div class="offcanvas-menu-overlay"></div>
    <div class="offcanvas-menu-wrapper">
        <div class="offcanvas__option">
         <div class="offcanvas__links">
                <c:if test="${ !empty sessionScope.user }"> <a href="#">ENCHERES</a></c:if>
                <c:if test="${ !empty sessionScope.user }"><a href="<%=request.getContextPath()%>/VendreArticle">VENDRE UN ARTICLE</a></c:if>
                <c:if test="${ !empty sessionScope.user }"><a href="<%=request.getContextPath()%>/MonProfil">MON PROFIL</a></c:if>
                <c:if test="${ !empty sessionScope.user }"><a href="<%=request.getContextPath()%>/ModifierMonProfil">MODIFIER PROFIL</a></c:if>
                <c:if test="${ empty sessionScope.user }"><a href="<%=request.getContextPath()%>/Connexion">SE CONNECTER</a></c:if>
                <c:if test="${ empty sessionScope.user }"><a href="<%=request.getContextPath()%>/Sinscrire">S'INSCRIRE</a></c:if>
				<c:if test="${ !empty sessionScope.user }"> <a href="<%=request.getContextPath()%>/Deconnexion">DECONNEXION</a></c:if>
         </div>
        </div>
        <div id="mobile-menu-wrap"></div>
        <div class="offcanvas__text">
            <p>LOGO</p>
        </div>
    </div>
    <!-- Offcanvas Menu End -->

    <!-- Header Section Begin -->
    <header class="header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2 col-md-3">
                        <div class="header__top__left">
                            <p>LOGO</p>
                        </div>
                    </div>
                    <div class="col-lg-10 col-md-3">
                        <div class="header__top__right">
                            <div class="header__top__links">    
                                <c:if test="${ !empty sessionScope.user }"> <a href="#">ENCHERES</a></c:if>
                                <c:if test="${ !empty sessionScope.user }"><a href="<%=request.getContextPath()%>/VendreArticle">VENDRE UN ARTICLE</a></c:if>
               					<c:if test="${ !empty sessionScope.user }"><a href="<%=request.getContextPath()%>/MonProfil">MON PROFIL</a></c:if>
                                <c:if test="${ !empty sessionScope.user }"><a href="<%=request.getContextPath()%>/ModifierMonProfil">MODIFIER PROFIL</a></c:if> 
                				<c:if test="${ empty sessionScope.user }"><a href="<%=request.getContextPath()%>/Connexion">SE CONNECTER</a></c:if>
				                <c:if test="${ empty sessionScope.user }"><a href="<%=request.getContextPath()%>/Sinscrire">S'INSCRIRE</a></c:if>
								<c:if test="${ !empty sessionScope.user }"> <a href="<%=request.getContextPath()%>/Deconnexion">DECONNEXION</a></c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-3">
                </div>
                <div class="col-lg-6 col-md-6">
                    <nav class="header__menu mobile-menu">
                    </nav>
                </div>
            </div>
            <div class="canvas__open"><i class="fa fa-bars"></i></div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-option">
        <div class="container">
                <div class="col-lg-12">
                    <div class="breadcrumb__text">
                        <h4>Liste des enchères</h4>
                        <!--  
                        <div class="breadcrumb__links">
                            <a href="#">Home</a>
                        </div> -->
                    </div>
                </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Shop Section Begin -->
    <section class="shop spad">
    
        <div class="container">
	        <div class="shop__sidebar__search ">
               <form action="#">
                   <input type="text" placeholder="Search...">
                   <button type="submit"><span class="icon_search"></span></button>
               </form>
	        </div>
            <div class="row">
                <div class="col-lg-3">
                    <div class="shop__sidebar">
                        
                        <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionExample">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseOne">Categories</a>
                                    </div>
                                    <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <li><a href="#">Toutes</a></li>
                                                    <li><a href="#">Informatique</a></li>
                                                    <li><a href="#">Ameublement</a></li>
                                                    <li><a href="#">Vêtement</a></li>
                                                    <li><a href="#">Sport&Loisirs</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                         <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionAchat">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseAchat">Achats</a>
                                    </div>
                                    <div id="collapseAchat" class="collapse show" data-parent="#accordionAchat">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <li><a href="#">enchères ouvertes</a></li>
                                                    <li><a href="#">mes enchères en cours</a></li>
                                                    <li><a href="#">mes enchères remportées</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionVente">
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapseVente">Mes ventes</a>
                                    </div>
                                    <div id="collapseVente" class="collapse show" data-parent="#accordionVente">
                                        <div class="card-body">
                                            <div class="shop__sidebar__categories">
                                                <ul class="nice-scroll">
                                                    <li><a href="#">Mes ventes en cours</a></li>
                                                    <li><a href="#">Ventes non débutées</a></li>
                                                    <li><a href="#">Ventes terminées</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
               	<div class="col-lg-9">
               	<%
               	List<ArticleVendu> listArticle = (List<ArticleVendu>)request.getAttribute("listArticle");
					if(listArticle==null)
					{
				%>		<h3>Aucuns articles disponibles </h3>		
					
				<% 
					}else {	
				%>
                    <div class="row">
                     <% for(ArticleVendu art:listArticle){
                     	%>
                        <div class="col-lg-4 col-md-6 col-sm-6">
                            <div class="product__item">
                                <div class="product__item__text">
                                <img alt="" src="images/encheres/5b83a7ae-4084-42d1-9650-16b6cb273d18.jpg">
                                    <h6><%=art.getNom()%></h6>
                                      <p class="finEnchere">
                                       Fin de l'enchère : <%=art.getDateDebutEncheres()%>
                                    </p>
                                   
                                    
                                    <p>Vendeur : <%-- <%=art.getVendeur().getPrenom()%> --%> </p>
                                    
                                    <h5>Prix : <%=art.getPrixVente() == 0? art.getMiseAPrix(): art.getPrixVente()%> points</h5>
                                </div>
                            </div>
                        </div>
	                   <%
	                    } 
	                  	%>
                      </div>
                 <%
					}
                 %>
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="product__pagination">
                                <a class="active" href="#">1</a>
                                <a href="#">2</a>
                                <a href="#">3</a>
                                <span>...</span>
                                <a href="#">21</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Shop Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="footer__copyright__text">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        <p> ENI-ENCHERES - 2022
                        </p>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Search Begin -->
    <div class="search-model">
        <div class="h-100 d-flex align-items-center justify-content-center">
            <div class="search-close-switch">+</div>
            <form class="search-model-form">
                <input type="text" id="search-input" placeholder="Search here.....">
            </form>
        </div>
    </div>
    <!-- Search End -->

    <!-- Js Plugins -->
    <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.nice-select.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.nicescroll.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.magnific-popup.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.countdown.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/jquery.slicknav.js"></script>
    <script src="<%=request.getContextPath()%>/js/mixitup.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/owl.carousel.min.js"></script>
    <script src="<%=request.getContextPath()%>/js/mainAccueil.js"></script>
</body>

</html>