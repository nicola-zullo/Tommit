<%@ page import="model.entity.UtenteBean" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Richiesta Inviata</title>
    <link rel="stylesheet" href="static/css/RichiestaGSInviata.css">

</head>
<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null ){ %>
<div class="container">
    <img src="static/immagini/logo.png">
    <div class="popup">
        <div class="popup-content">
            <h2 class="popup-title">Richiesta inviata!</h2>
            <p class="popup-body">La tua richiesta &egrave; stata inviata correttamente agli amministratori.  </p>
            <p class="popup-body">Quando sar&agrave; approvata vedrai visibile il gruppo studio nella sezione "I tuoi gruppi".</p>
            <a href="index.jsp" class="popup-button">Home Page</a>
        </div>
    </div>
</div>
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
</body>
</html>

