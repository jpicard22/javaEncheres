<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

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
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/modifierMonProfil.css"> <!-- ajout css -->
  
  <title>Mon profil</title>
</head>

<body>
<!-- class vh=100 -->
<section  style="background-color: #f4f5f7;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0 styleCard">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row cardProfil">
            <div class="col-md-12 gradient-custom text-center text-white" style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
              <img
                src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/1024px-Circle-icons-profile.svg.png"
                alt="Avatar"
                class="img-fluid my-5"
                style="width: 130px;"
              />
              <i class="far fa-edit mb-5"></i>
            </div>
            <div class="col-md-12">
              <div class="card-body p-4">
             	
                <div class="row pt-1">
                 <form>
                  
                 <div class="form-group">
					<label for="pseudo">Pseudo</label>
                    <input type="text" id="pseudo" class="form-control" placeholder="${ sessionScope.user.pseudo }">
                  </div> 
                  
                 <div class="form-row">
            	  <div class="form-group col-md-6">
					<label for="nom">Nom</label>
                    <input type="text" id="nom" class="form-control" placeholder="${ sessionScope.user.nom }">
                  </div>
                   <div class="form-group col-md-6">
					<label for="prenom">Prénom</label>
                    <input type="text" id="prenom" class="form-control" placeholder="${ sessionScope.user.prenom }">
                  </div>
                 </div>
                   
                 <div class="form-row">
            	  <div class="form-group col-md-6">
					<label for="email">Email</label>
                    <input type="email" id="email" class="form-control" placeholder="${ sessionScope.user.email }">
                  </div>
                   <div class="form-group col-md-6">
					<label for="telephone">Téléphone</label>
                    <input type="text" id="telephone" class="form-control" placeholder="${ sessionScope.user.telephone }">
                  </div>
                 </div>  

            	  <div class="form-group">
					<label for="rue">Rue</label>
                    <input type="text" id="rue" class="form-control" placeholder="${ sessionScope.user.rue }">
                  </div>
                  <div class="form-row">
                   <div class="form-group col-md-6">
					<label for="ville">Ville</label>
                    <input type="text" id="ville" class="form-control" placeholder="${ sessionScope.user.ville }">
                  </div>
                  <div class="form-group col-md-6">
					<label for="codePostal">Code Postal</label>
                    <input type="text" id="codePostal" class="form-control" placeholder="${ sessionScope.user.codePostal }">
                  </div>
                 </div>
                 <div class="form-group">
					<label for="mdpActuel">Mot de passe actuel </label>
                    <input type="password" id="mdpActuel" class="form-control">
                  </div>
                  <div class="form-row">
                   <div class="form-group col-md-6">
					<label for="newMdp">Nouveau mot de passe</label>
                    <input type="text" id="newMdp" class="form-control">
                  </div>
                  <div class="form-group col-md-6">
					<label for="confirmationMdp">Confirmation</label>
                    <input type="text" id="confirmationMdp" class="form-control">
                  </div>
                 </div>
                   <div class="form-group row">
					<label for="formCredit" class="col-sm-2 col-form-label">Crédit : </label>
					<div class="col-sm-10">
      					<p class="form-control" id="formCredit" >${ sessionScope.user.credit }</p>
    				</div>
    				</div>
                  </form> 
                </div>                               
              </div>              
            </div>            
          </div>          
        </div>
        <input type="submit" value="Modifier" class="btn btn-block" id="boutonModifier">
      </div>
    </div>
  </div>
</section>

	<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/popper.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/main.js"></script>
</body>
</html>