
<%@ page import="model.entity.UtenteBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
  <title>Visualizza Utenti</title>

  <meta name="viewport" content="width=device-width, initial-scale=1"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css'>
  <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css'>
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="static/css/visualizzaUtenti.css">
</head>


<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).isRuolo()==true){ %>

  <main>
    <section class="hero-unit">
      <%@ include file="/navbar.jsp"%>


      <div class="table-wrapper">
          <h1 class="titolo">Utenti registrati</h1>
        <table class="fl-table">
          <thead>
            <tr>
                <th>ID</th>
                <th>NOME</th>
                <th>COGNOME</th>
                <th>EMAIL</th>
                <th>USERNAME</th>
                <th>CF</th>
             </tr>
          </thead>


           <c:forEach  items="${listaUtenti}" var="user">
             <tbody>
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getSurname()}</td>
                    <td>${user.getEmail()}</td>
                    <td>${user.getUsername()}</td>
                    <td>${user.getCF()}</td>
                 </tr>
             </tbody>
           </c:forEach>
        </table>
      </div>
    </section>
  </main>
<%} else{ response.sendRedirect("./errorPage.jsp");}%>
</body>






