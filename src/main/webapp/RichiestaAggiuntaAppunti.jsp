<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Richiesta Aggiunta Appunti</title>

  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'><link rel="stylesheet" href="static/css/navbar.css">
  <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'><link rel="stylesheet" href="static/css/navbar.css">

  <link rel="stylesheet" href="static/css/RichiestaCreazioneGS.css">

</head>
<body>
<%@ include file="navbar.jsp"%>
<div id="form-main">

  <div id="form-div">
    <form class="form" id="form1">

      <p class="nome">
        <input name="nome" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Titolo" id="nomegruppo" />
      </p>

      <p class="materia">
        <input name="materia" type="text" class="validate[required,custom[email]] feedback-input" id="materia" placeholder="Materia" />
      </p>

      <p class="obiettivi">
        <textarea name="obiettivi" class="validate[required,length[6,300]] feedback-input" id="obiettivi" placeholder="Obiettivi"></textarea>
      </p>


      <div class="submit">
        <input type="submit" value="Richiedi approvazione" id="button-blue"/>
        <div class="ease"></div>
      </div>
    </form>
  </div>
</body>
</html>
