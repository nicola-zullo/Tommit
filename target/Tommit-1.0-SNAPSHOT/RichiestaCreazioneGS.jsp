<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Richiesta Creazione Gruppo Studio</title>

    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>

    <link rel="stylesheet" href="static/css/RichiestaCreazioneGS.css">

</head>
<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null ){ %>
<div id="form-main">
    <%@ include file="/navbar.jsp"%>


    <div id="form-div">

        <form class="form" id="form1" action="richiesta-creazione-gs-servlet" method="post">
            <input type="hidden" name="id" value ='${utenteLoggato.getId()}' placeholder ="Id" />
            <p class="nome">
                <input name="nome" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Nome Gruppo" id="nomegruppo" />
            </p>

            <p class = "materia">
                <select style = "width: 27em; height: 3em;" name="categorie" id="categorie">
                    <option value="umanistica">Umanistica</option>
                    <option value="scientifico">Scientifico</option>
                    <option value="artistica">Artistica</option>
                    <option value="informatica">Informatica</option>
                    <option value="lingue">Lingue</option>
                    <option value="sanitario">Sanitario</option>
                </select>
            </p>

            <p class="luogo">
                <input name="luogo" type="text" class="validate[required,custom[email]] feedback-input" id="luogo" placeholder="Luogo di incontro" />
            </p>

            <p class="obiettivi">
                <textarea name="obiettivi" class="validate[required,length[6,300]] feedback-input" id="obiettivi" placeholder="Obiettivi"></textarea>
            </p>


            <div class="submit">
                <input type="submit" value="Richiedi approvazione"  id="button-blue"/>
                <div class="ease"></div>
            </div>
        </form>
    </div>
</div>
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>

</body>
</html>
