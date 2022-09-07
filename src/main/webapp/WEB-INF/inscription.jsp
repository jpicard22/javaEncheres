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


  <title>Inscription </title>
</head>

<body>

  <div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('images/bg_1.jpg');"></div>
    <div class="contents order-2 order-md-1">
      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-7">
            <h3><strong>Les objets sont nos amis</strong></h3>
            <p class="mb-4">Le premier site d'enchère en ligne de notre association</p>
            <h2><strong>Inscription</strong></h2>
            <c:if test="${ sessionScope.resultat == false }">
			    <div class="alert alert-danger" role="alert">
				  <p>${ sessionScope.errorMessage }</p>
				</div>
			</c:if>
            <form action="#" method="post">
              <div class="form-scrollable">
                <div class="form-group  mb-3">
                  <label class="form-label">Pseudo</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Un_pseudo" name="pseudo" value="${pseudo}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Nom</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Nom" name="nom" value="${nom}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Prénom</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Prénom" name="prenom" value="${prenom}" >
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Email</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="email@email.fr" name="email" value="${email}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Téléphone</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="0655778822" name="tel" value="${tel}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Rue</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Avenue des enchères" name="rue" value="${rue}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Code postale</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="17210" name="codePostal" value="${codePostal}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label class="form-label">Ville</label>
                  <div class="input-group has-validation">
                    <input type="text" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Paris" name="ville" value="${ville}">
                  </div>
                </div>
                <div class="form-group  mb-3">
                  <label for="validationCustomUsername" class="form-label">Mot de passe</label>
                  <div class="input-group has-validation">
                    <input type="password" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Votre mot de passe" name="password" value="${password}">
                  </div>
                </div>
              <!--   <div class="form-group  mb-3">
                  <label for="validationCustomUsername" class="form-label">Confirmation</label>
                  <div class="input-group has-validation">
                    <input type="password" class="form-control" 
                      aria-describedby="inputGroupPrepend" required placeholder="Votre mot de passe" name="mdpConfirmation" >
                  </div>
                </div> -->
              </div>
              <input type="submit" value="Sinscrire" class="btn btn-block mt-4" id="connexionButtun">
            </form>
            <a href="<%=request.getContextPath()%>/" class="btn btn-block mt-2 align-middle linkButtonAnnulationContainer" id="AnnulationButtun" value="Annuler">
            <p class="mt-2 linkButton">Annuler</p>
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