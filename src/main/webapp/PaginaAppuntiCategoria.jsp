<%--
  Created by IntelliJ IDEA.
  User: laimb
  Date: 10/02/2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PaginaAppuntiCategoria</title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="static/css/PaginaAppuntiCategoria.css">
</head>
<body>
<%@ include file="navbar.jsp" %>

<div class="wrapper">
    <div class="container">
        <h1>Appunti!</h1>
    </div>
</div>


<section class="hero-unit">


    <c:forEach var="gs" items="${listaAppunti}">
        <form action="">
            <input type="hidden" name="nome" value="${appunti.getNome()}">
            <div class="container">
                <div class="test_box box-01 col-xs-6 col-md-4">
                    <div class="inner">
                        <a href="" class="test_click">
                            <div class="flex_this">
                                <h1 class="test_title">${appunti.getNome()}</h1>
                                <span class="test_link">Link</span>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </form>
    </c:forEach>

</section>
</main>
<!-- partial -->
<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.0.0-alpha.6/js/bootstrap.min.js'></script><script  src="./script.js"></script>


</body>
</html>
