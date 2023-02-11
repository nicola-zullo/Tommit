<%@ page import="model.GSBean" %><%--
  Created by IntelliJ IDEA.
  User: laimb
  Date: 09/02/2023
  Time: 11:51
  To change this template use File | Settings | File Templates.
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
        <section class="hero-unit">
            <img src="https://marketplace.canva.com/EAEdhZMmjlU/1/0/1600w/canva-viola-moderno-tecnologia-e-gaming-logo-mDRZg0vq1eY.jpg" class="w3-border" alt="my image">
            <div class="testo" >
                <h1> ${gs.getNome()}</h1>
                <h4>${gs.getMaterie()}</h4>
                <h4>${gs.getLuogo}</h4>
                <h4>${gs.getObiettivi}</h4>

            </div>

            <form action="iscrizione-gs" method="post">
                <input type="hidden" value="${gs.getNome()}" name="nome">
            <div class="bottone">
                <button class="btn5">
                    unisciti al gruppo
                </button>
            </div>
            </form>


        </section>
    </main>
</body>
</html>
