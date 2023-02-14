<%--
  Created by IntelliJ IDEA.
  User: nicol
  Date: 12/02/2023
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Donazione Effettuata</title>
    <link rel="stylesheet" href="static/css/RichiestaGSInviata.css">



</head>
<body>
<div class="container">
    <div class="popup">
        <div class="popup-content">
            <h1 class="popup-title">la tua donazione e stata effettuata!</h1>
            <p class="popup-body">${ritornoPagamento}</p>
            <a href="index.jsp" class="popup-button">Home Page</a>
        </div>
    </div>
</div>
</body>
</html>
