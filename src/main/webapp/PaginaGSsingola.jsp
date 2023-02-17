<%@ page import="model.GSBean" %><%--
  Created by IntelliJ IDEA.
  User: laimb
  Date: 09/02/2023
  Time: 11:51
  To change this template use File | SettincurrentGS | File Templates.
--%>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">

    <title>Gruppo Studio </title>
    <link rel="stylesheet" href="static/css/PaginaGSsingola.css">
    <link rel="stylesheet" href="static/css/navbar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>

</head>
<body>

<main>
    <%@ include file="navbar.jsp" %>

    <input type="hidden" id="idUtente" value="${utenteLoggato.getId()}">
    <div class="testo" >
        <h1 class="titolo"> ${currentGS.getNome()} </h1>
        <h2>Materia: ${currentGS.getMateria()} </h2>
        <h2>Luogo: ${currentGS.getLuogo()} </h2>
        <h2 class="obbiettivi">Obiettivi: ${currentGS.getObiettivo()}</h2>
    </div>

    <div class="wrapper">
        <img src="static/immagini/${currentGS.getMateria()}.png" class="w3-border" alt="my image">
        <div class="bottone">
            <form action="iscrizione-gs" id="iscrizione-servlet" method="post">
                <input type="hidden" id="nomegruppo" value="${currentGS.getNome()}" name="nome">
                <button onload="controlloUtenteGS()" class="btn5" id="iscrizioneButton">
                    Unisciti al gruppo
                </button><br><br><br>
                <span id="infoIscrizione">
                    <h4>${message}</h4>
                </span>
            </form>
        </div>
    </div>


</main>
</body>
</html>
