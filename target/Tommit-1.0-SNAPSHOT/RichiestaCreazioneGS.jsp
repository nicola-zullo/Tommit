<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Richiesta Creazione Gruppo Studio</title>

    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'><link rel="stylesheet" href="static/css/navbar.css">
    <meta name="viewport" content="width=device-width, initial-scale=1"><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'><link rel="stylesheet" href="static/css/navbar.css">

    <link rel="stylesheet" href="static/css/RichiestaCreazioneGS.css">

</head>
<body>
<!-- partial:index.partial.html -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="index.jsp">Home</a></li>
                <li><a href="PaginaAppunti.jsp">Appunti</a></li>
                <li><a href="#">Gruppi Studio</a></li>
                <li><a href="#">Timer</a></li>
                <li><a href="login.jsp">icona</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>
<div id="form-main">

    <div id="form-div">
        <form class="form" id="form1">

            <p class="nome">
                <input name="nome" type="text" class="validate[required,custom[onlyLetter],length[0,100]] feedback-input" placeholder="Nome Gruppo" id="nomegruppo" />
            </p>

            <p class="materia">
                <input name="materia" type="text" class="validate[required,custom[email]] feedback-input" id="materia" placeholder="Materia" />
            </p>

            <p class="luogo">
                <input name="luogo" type="text" class="validate[required,custom[email]] feedback-input" id="luogo" placeholder="Luogo di incontro" />
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
    <!-- partial -->

</body>
</html>
