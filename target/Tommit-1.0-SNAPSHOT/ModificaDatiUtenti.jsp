<%@ page import="model.entity.UtenteBean" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Modifica dati</title>
    <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="static/css/background.css">

    <link rel="stylesheet" href="static/css/Registrazione.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).isRuolo()==false){ %>

<div class="bg-img">
    <%@ include file="/navbar.jsp"%>
    <div class="content">

        <div class="form-wrapper">

            <div class="linker">

                <span class="ring"></span>
                <span class="ring"></span>
                <span class="ring"></span>
                <span class="ring"></span>
                <span class="ring"></span>
                <span class="ring"></span>

            </div>
            <form id="msform" action="update-utente-servlet" method="post">
                <ul id="progressbar">
                    <li class="active">Registrazione</li>
                </ul>
                <fieldset>
                    <h2 style="font-size: 15px" class="fs-title">Modifica dati</h2>
                    <input type="hidden" name="id" value ='${utenteLoggato.getId()}' placeholder ="Id" />
                    <input type="text" name="name" placeholder="Nome" />
                    <input type="text" name="surname" placeholder="Cognome" />
                    <input type="text" name="cf" placeholder="CF" />
                    <input type="text" name="username" placeholder="Username" />
                    <input type="text" name="email" placeholder="Email" />
                    <input type="password" name="password" placeholder="Password" />
                    <input type = "submit" name = "next" placeholder="Modifica">
                </fieldset>
            </form>
        </div>
    </div>

</div>
<%} else{ response.sendRedirect("./errorPage.jsp");}%>
</body>
</html>
