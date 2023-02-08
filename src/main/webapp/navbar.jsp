<%@ page import="model.UtenteBean" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">


  <link rel="stylesheet" href="static/css/navbar.css">

</head>

<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>

    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="index.jsp">Home</a></li>
        <li><a href="PaginaAppunti.jsp">Appunti</a></li>
        <li><a href="PaginaGS.jsp">Gruppi Studio</a></li>
        <li><a href="#">Timer</a></li>
        <%
        //utente non loggato
        if( (UtenteBean)request.getSession().getAttribute("utenteLoggato")==null ){
        %>
        <li><a href="login.jsp">Login</a></li>
        <% //admin
        }else if( (UtenteBean)request.getSession().getAttribute("utenteLoggato")!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).isRuolo()==true) {
        %>
        <li><a href="PaginaAdmin.jsp">Area Admin</a></li>
        <li><a href="DisconnessioneUtente">Logout<</a></li>
        <% //utente loggato
        }else if ( (UtenteBean)request.getSession().getAttribute("utenteLoggato")!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).isRuolo()==false){
        %>
        <li><a href="PaginaUtente.jsp">Area Utente</a> </li>
        <li><a href="DisconnessioneUtente">Logout</a></li>
        <% } %>
      </ul>
    </div>
  </div>
</nav>
</body>
