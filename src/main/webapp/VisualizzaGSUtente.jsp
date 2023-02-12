
<%@ page import="model.UtenteBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>Visualizza Appunti</title>

  <meta name="viewport" content="width=device-width, initial-scale=1"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css'>
  <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css'>
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="static/css/visualizzaUtenti.css">
</head>


<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).isRuolo()==false){ %>

<main>
  <section class="hero-unit">
    <%@ include file="/navbar.jsp"%>


    <div class="table-wrapper">
      <table class="fl-table">
        <thead>
        <tr>
          <th>NOME</th>
          <th>MATERIA</th>
          <th>LUOGO</th>
          <th>OBIETTIVO</th>

        </tr>
        </thead>


        <c:forEach var="gs" items="${listGS}">
          <tbody>
          <tr>
            <td>${gs.getNome()}</td>
            <td>${gs.getLuogo()}</td>
            <td>${gs.getMateria()}</td>
            <td>${gs.getObiettivo()}</td>
          </tbody>
        </c:forEach>

      </table>
    </div>
  </section>
</main>
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
</body>






