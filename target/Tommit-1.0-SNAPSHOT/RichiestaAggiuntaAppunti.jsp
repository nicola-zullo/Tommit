<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Richiesta Aggiunta Appunti</title>

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
    <form class="form" id="form1" action="richiesta-creazione-appunti-servlet" method="post">
      <p class="nome">
        <input name="nome" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Titolo" id="nomegruppo" />
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

      <p class="testo">
        <textarea name="testo" class="validate[required,length[6,300]] feedback-input" id="testo" placeholder="Testo"></textarea>
      </p>


      <div class="submit">
        <input type="submit" value="Richiedi approvazione" id="button-blue"/>
        <div class="ease"></div>
      </div>
    </form>
  </div>
      <%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
</body>
</html>
