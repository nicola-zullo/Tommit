<%@ page import="model.entity.UtenteBean" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Area Utente</title>
    <link rel="stylesheet" href="static/css/PaginaUtente.css">


</head>
<body>

<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap-extended.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/fonts/simple-line-icons/style.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/colors.min.css">
<link rel="stylesheet" type="text/css" href="https://pixinvent.com/stack-responsive-bootstrap-4-admin-template/app-assets/css/bootstrap.min.css">
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null && ((UtenteBean) request.getSession().getAttribute("utenteLoggato")).isRuolo()==false){ %>


<div class="total">
    <% UtenteBean utente = (UtenteBean) request.getSession().getAttribute("utenteLoggato");%>
    <div class="row">
        <div class="col-12 mt-3 mb-1">
            <h2 style="color: white">Benvenuto, ${utenteLoggato.getName()} ${utenteLoggato.getSurname()}</h2>
            <h6 style="color: white"> Questa &egrave la tua area personale</h6>
            <h6><a style="color: white" href="index.jsp">Torna alla Homepage</a></h6>
        </div>
    </div>
    <div class="row">
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card">
                <div class="card-content">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="icon-bubbles warning font-large-2 float-right"></i>
                            </div>
                            <div class="media-body text-right">
                                <form>
                                    <input type="hidden" name="id" value ='${utenteLoggato.getId()}' placeholder ="Id" />
                                    <span><a href="listUserGS">Gruppi Studio</a></span>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xl-3 col-sm-6 col-12">
            <div class="card">
                <div class="card-content">
                    <div class="card-body">
                        <div class="media d-flex">
                            <div class="align-self-center">
                                <i class="icon-book-open primary font-large-2 float-right"></i>
                            </div>
                            <div class="media-body text-right">

                                <form>
                                    <input type="hidden" name="id" value ='${utenteLoggato.getId()}' placeholder ="Id" />
                                    <span><a href="listUserAppunti">Appunti</a></span>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-12 mt-3 mb-1">
            <h4 style="color: white" class="text-dati">Ecco i tuoi dati!</h4>

            <table id = "utenti">
                <tr>
                    <th>ID</th>
                    <th>NOME</th>
                    <th>COGNOME</th>
                    <th>EMAIL</th>
                    <th>USERNAME</th>
                    <th>CF</th>
                    <th>PASSWORD</th>
                </tr>
                <tr>
                    <td>${utenteLoggato.getId()}</td>
                    <td>${utenteLoggato.getName()}</td>
                    <td>${utenteLoggato.getSurname()}</td>
                    <td>${utenteLoggato.getEmail()}</td>
                    <td>${utenteLoggato.getUsername()}</td>
                    <td>${utenteLoggato.getCF()}</td>
                    <td>${utenteLoggato.getPassword()}</td>
                </tr>
            </table>

        </div>

    </div>

    <button style="background-color: #b20002"><a style="color: white" href="ModificaDatiUtenti.jsp"><span>Modifica dati</span></a> </button>
</div>
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
</body>
</html>

