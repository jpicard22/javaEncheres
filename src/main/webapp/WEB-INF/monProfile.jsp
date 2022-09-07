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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/monProfile.css">
  

  <title>Mon profile </title>
</head>

<body>
<section class="vh-100" style="background-color: #f4f5f7;">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-lg-6 mb-4 mb-lg-0">
        <div class="card mb-3" style="border-radius: .5rem;">
          <div class="row g-0">
            <div class="col-md-4 gradient-custom text-center text-white" style="border-top-left-radius: .5rem; border-bottom-left-radius: .5rem;">
              <img
                src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Circle-icons-profile.svg/1024px-Circle-icons-profile.svg.png"
                alt="Avatar"
                class="img-fluid my-5"
                style="width: 130px;"
              />
              <h5>${ sessionScope.user.pseudo }</h5>
              <p style="color: white;">${ sessionScope.user.nom } ${ sessionScope.user.prenom }</p>
              <i class="far fa-edit mb-5"></i>
            </div>
            <div class="col-md-8" style="width: 150px;">
              <div class="card-body p-4">
                <h6>Information</h6>
                <hr class="mt-0 mb-4">
                <div class="row pt-1">
                  <div class="col-6 mb-3">
                    <h6>Email</h6>
                    <p class="text-muted">${ sessionScope.user.email }</p>
                  </div>
                  <div class="col-6 mb-3">
                    <h6>Téléphone</h6>
                    <p class="text-muted">${ sessionScope.user.telephone }</p>
                  </div>
                  <div class="col-12 mb-3">
                    <h6>Adresse</h6>
                    <p class="text-muted">${ sessionScope.user.rue } ${ sessionScope.user.ville } ${ sessionScope.user.codePostal }</p>
                  </div>
                  
                  <div class="col-12 mb-3">
                    <h6>Crédits</h6>
                    <p class="text-muted">${ sessionScope.user.credit }</p>
                  </div>
                </div>
                
                <div class="d-flex justify-content-start">
                  <a href="#!"><i class="fab fa-facebook-f fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-twitter fa-lg me-3"></i></a>
                  <a href="#!"><i class="fab fa-instagram fa-lg"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div>
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