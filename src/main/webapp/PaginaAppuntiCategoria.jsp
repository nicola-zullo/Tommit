<%--
  Created by IntelliJ IDEA.
  User: laimb
  Date: 10/02/2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>PaginaAppuntiCategoria</title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/PaginaAppuntiCategoria.css">
</head>
<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null ){ %>
<%@ include file="navbar.jsp" %>
<section class="hero-unit">

    <div class="container">
        <h1 class="titoloo">Appunti</h1>
        <a class="pubblica" href="RichiestaAggiuntaAppunti.jsp">pubblica</a>
    </div>


    <div class="appunti">
        <div class="container2">
            <c:forEach var="item" items="${listAppunti}">
                <form action="pagina-appunto-servlet"><input type="hidden" name="id" value="${item.getId()}">
                    <div class="test_box box-01 col-xs-6 col-md-4">
                        <div class="inner" style="background-image:url('static/immagini/${item.getMateria()}.png')" >
                            <a href="pagina-appunto-servlet?id=${item.getId()}" class="test_click">
                                <div class="flex_this">
                                    <h1 class="test_title">${item.getTitolo()}</h1>
                                </div>
                            </a>
                        </div>
                    </div>
                </form>
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
