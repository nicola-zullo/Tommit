<%@ page import="model.entity.GSBean" %><%--
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
    <div class="testo" >
        <h1 class="titolo"> ${currentGS.getNome()} </h1>
        <h2>Materia: ${currentGS.getMateria()} </h2>
        <h2>Luogo: ${currentGS.getLuogo()} </h2>
        <h2 class="obbiettivi">Obiettivi: ${currentGS.getObiettivo()}</h2>

    </div>

    <div class="wrapper">
        <img src="static/immagini/${currentGS.getMateria()}.png" class="w3-border" alt="my image">
        <div class="bottone">
            <form action="iscrizione-gs" method="post">
                <input type="hidden" value="${currentGS.getNome()}" name="nome">
                <button class="btn5">
                    Unisciti al gruppo
                </button>
            </form>
        </div>
    </div>


</main>
</body>
</html>
