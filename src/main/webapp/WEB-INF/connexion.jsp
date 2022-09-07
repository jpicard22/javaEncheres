<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html lang="fr">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/owl.carousel.min.css">
  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap.min.css">
  <!-- Style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">

  <title>Login </title>
</head>

<body>
  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('<%=request.getContextPath()%>/images/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3><strong>Les objets sont nos amis</strong></h3>
            <p class="mb-4">Le premier site d'enchère en ligne de notre association</p>
            <c:if test="${ sessionScope.resultat == false }">
			    <div class="alert alert-danger" role="alert">
				  Identifiant ou mot de passe incorect !
				</div>
			</c:if>
            
            <form action="Connexion" method="post">
              <div class="form-group  mb-3">
                <label for="email" class="form-label">Email</label>
                <div class="input-group has-validation">
                  <input type="text" class="form-control" 
                    aria-describedby="inputGroupPrepend" required placeholder="email-email@gmail.com" name="email" id="email" >
                  <div class="invalid-feedback">
                    Veuillez entre votre adresse mail
                  </div>
                </div>
              </div>
              <div class="form-group  mb-3">
                <label for="mdp" class="form-label">Mot de passe</label>
                <div class="input-group has-validation">
                  <input type="password" class="form-control" 
                    aria-describedby="inputGroupPrepend" required placeholder="Votre mot de passe" name="mdp" id="mdp" >
                </div>
              </div>
              <div class="d-flex mb-5 align-items-center">
                <label class="mb-0"><span>Ce souvenir de moi</span>
                  <input type="checkbox" />
                </label>
              </div>
              <input type="submit" value="Connexion" class="btn btn-block" id="connexionButtun">
            </form>
            <a href="<%=request.getContextPath()%>/Sinscrire" class="btn btn-block mt-2 align-middle linkButtonContainer" id="connexionButtun" value="S'inscrire">
            <p class="mt-2 linkButton">S'inscrire</p>
            </a>
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