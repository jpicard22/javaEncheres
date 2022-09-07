<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="fr">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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

 <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <!-- Style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">


  <title>Vendre un article </title>
</head>

<body>

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

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/encheres/boutique2.jpg');"></div>
    <div class="contents order-2 order-md-1">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3><strong>Les objets sont nos amis</strong></h3>
            <p class="mb-4">Le premier site d'enchère en ligne de notre association</p>
            <h2><strong>Quel article souhaitez-vous vendre ? </strong></h2>
            <c:if test="${ sessionScope.resultat == false }">
			    <div class="alert alert-danger" role="alert">
				  <p>${ sessionScope.errorMessage }</p>
				</div>
			</c:if>
            <form action="${pageContext.request.contextPath}/VendreArticle" method="post">
              <div class="form-scrollable">
                <div class="form-group  mb-3">
                  <label class="form-label">Nom de l'article</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" value=""
                      aria-describedby="inputGroupPrepend" required placeholder="Nom" name="nameArticle" >
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Description</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" value=""
                      aria-describedby="inputGroupPrepend" required placeholder="Description" name="Description" >
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Prix initial</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" value=""
                      aria-describedby="inputGroupPrepend" required placeholder="prix initial" name="miseAPrix" >
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">categorie</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" value=""
                      aria-describedby="inputGroupPrepend" required placeholder="categorie" name="categorie" >
                  </div>
                </div>	
                <div class="form-group  mb-3">
                  <label class="form-label">date de debut des enchères</label>
                  <div class="input-group has-validation">
                    <input type="date" class="form-control" value=""
                      aria-describedby="inputDate" required placeholder="date de debut des encheres" name="dateDebutEncheres" >
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">date de fin des enchères</label>
                  <div class="input-group has-validation">
                  <input type="date" class="form-control" value=""
                      aria-describedby="inputGroupPrepend" required placeholder="date de fin des enchères" name="dateFinEncheres" >
                  </div>
                </div>
              </div>
              <input type="submit" value="Ajout" class="btn btn-block mt-4 ConfirmButtun" id="ConfirmButtun">
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>