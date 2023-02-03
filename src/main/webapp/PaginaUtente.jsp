<%@ page import="model.UtenteBean" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Area Utente</title>
    <link rel="stylesheet" href="static/css/PaginaAdmin.css">


</head>
<body>

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Montserrat&display=swap" rel="stylesheet">

<div class="total">
    <div class="row">
        <div class="col-12 mt-3 mb-1">
            <h2 class="text-uppercase">Benvenuto!</h2>
            <h6>Questa &egrave la tua area personale</h6>
            <h6><a href="index.jsp">Torna alla Homepage</a></h6>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card">
                <div class="card-content">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="icon-bubbles warning font-large-2 float-right"></i>
                            </div>
                            <div class="media-body text-right">

                                <span><a href="#">Gruppi Studio</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card">
                <div class="card-content">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="icon-book-open primary font-large-2 float-right"></i>
                            </div>
                            <div class="media-body text-right">

                                <span><a href="#">Appunti</a></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <% UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utenteLoggato");%>
        <div class="col-12 mt-3 mb-1">
            <h4 class="text-dati">Ecco i tuoi dati!</h4>
            <h6 class = "text-dati">//dati</h6>
        </div>
    </div>
</div>

</body>
</html>

