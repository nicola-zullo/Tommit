<!DOCTYPE html>
<html lang="en" >
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="static/css/search_bar.css">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel="stylesheet" href="static/css/PaginaGS.css">
    <link rel="stylesheet" href="static/css/ComboBox.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<main>
    <% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null ){ %>
    <%@ include file="navbar.jsp" %>
    <section class="hero-unit">


        <div class="bottone" >
            <button onclick="location.href='RichiestaCreazioneGS.jsp'" class="btn5">
                Crea Gruppo Studio
            </button>
        </div>

        <div class ="box">
            <form action="listGSCategory" method="get">
                <div class="comboBox">
                    <div class="select" tabindex="1">
                        <input class="selectopt" name="category" type="radio" id="opt0" checked>
                        <label for="opt0" class="option">Seleziona il filtro</label>
                        <input class="selectopt" name="category" type="radio" id="opt1" value="artistica">
                        <label for="opt1" class="option">Artistica</label>
                        <input class="selectopt" name="category" type="radio" id="opt2" value="umanistica">
                        <label for="opt2" class="option">Umanistica</label>
                        <input class="selectopt" name="category" type="radio" id="opt3" value="scientifico">
                        <label for="opt3" class="option">Scientifico</label>
                        <input class="selectopt" name="category" type="radio" id="opt4" value="informatica">
                        <label for="opt4" class="option">Informatica</label>
                        <input class="selectopt" name="category" type="radio" id="opt5" value="sanitario">
                        <label for="opt5" class="option">Sanitaria</label>
                        <input class="selectopt" name="category" type="radio" id="opt6" value="lingue">
                        <label for="opt6" class="option">Lingue</label>
                    </div>
                </div>
                <div class="bottone2">
                    <button class="btn6" onsubmit="ApplicaFiltro">
                        Filtra per materia
                    </button>
                </div>
            </form>
        </div>

        <div class="gruppi">
            <div class="container">
                <c:forEach var="item" items="${listaGS}">
                    <div class="test_box box-01 col-xs-6 col-md-4">
                        <div class="inner" style="background-image:url('static/immagini/${item.getMateria()}.png')" >
                            <a href="pagina-gs-servlet?nome=${item.getNome()}" class="test_click">
                                <div class="flex_this">
                                    <h1 class="test_title">${item.getNome()}</h1>
                                </div>
                            </a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script><script  src="./script.js"></script>
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
</body>
</html>
