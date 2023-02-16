<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>
    <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="static/css/background.css">

    <link rel="stylesheet" href="static/css/Registrazione.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body>

<script>
    function controlloUsername() {
        const xhttp = new XMLHttpRequest();
        var username = document.getElementById("username").value;
        xhttp.onload = function() {
            if (this.response == "false"){
                document.getElementById("bottone").disabled=false;
                document.getElementById("bottone").style.background = "#27ae60";
                document.getElementById("infoUsername").innerHTML = "";
                document.getElementById("infoUsername").style.color = "";
            }else{
                document.getElementById("bottone").disabled=true;
                document.getElementById("bottone").style.background = "gray";
                document.getElementById("infoUsername").innerHTML = "Username gia' in uso";
                document.getElementById("infoUsername").style.color = "red";
            }
        }
        xhttp.open("GET", "username-servlet?username="+username);
        xhttp.send();
    }
</script>

<script>
    function controlloEmail() {
        const xhttp = new XMLHttpRequest();
        var email = document.getElementById("email").value;
        xhttp.onload = function() {
            if (this.response == "false"){
                document.getElementById("bottone").disabled=false;
                document.getElementById("bottone").style.background = "#27ae60";
                document.getElementById("infoEmail").innerHTML = "";
                document.getElementById("infoEmail").style.color = "";
            }else{
                document.getElementById("bottone").disabled=true;
                document.getElementById("bottone").style.background = "gray";
                document.getElementById("infoEmail").innerHTML = "Email gia' in uso";
                document.getElementById("infoEmail").style.color = "red";
            }
        }
        xhttp.open("GET", "email-servlet?email="+email);
        xhttp.send();
    }
</script>

<script>
    function controlloConfermaPass() {
        var confPass = document.getElementById("confPassword").value;
        var pass = document.getElementById("pass").value;
            if (pass === confPass){
                document.getElementById("bottone").disabled=false;
                document.getElementById("bottone").style.background = "#27ae60";
                document.getElementById("infoPassword").innerHTML = "";
                document.getElementById("infoPassword").style.color = "";
            }else{
                document.getElementById("bottone").disabled=true;
                document.getElementById("bottone").style.background = "gray";
                document.getElementById("infoPassword").innerHTML = "Le password non coincidono!";
                document.getElementById("infoPassword").style.color = "red";
            }
    }
</script>

<script>
    function controlloCF() {
        const xhttp = new XMLHttpRequest();
        var cf = document.getElementById("cf").value;
        xhttp.onload = function() {
            if (this.response == "false"){
                document.getElementById("bottone").disabled=false;
                document.getElementById("bottone").style.background = "#27ae60";
                document.getElementById("infoCF").innerHTML = "";
                document.getElementById("infoCF").style.color = "";
            }else{
                document.getElementById("bottone").disabled=true;
                document.getElementById("bottone").style.background = "gray";
                document.getElementById("infoCF").innerHTML = "CF gia' registrato";
                document.getElementById("infoCF").style.color = "red";
            }
        }
        xhttp.open("GET", "cf-servlet?cf="+cf);
        xhttp.send();
    }
</script>

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
        <form id="msform" action="registrazione-utente-servlet" method="post">
            <ul id="progressbar">
                <li class="active">Registrazione</li>
            </ul>
        <fieldset>
            <h2 class="fs-title">Crea il tuo account</h2>
            <input type="text" name="name" placeholder="Nome" required/>
            <input type="text" name="surname" placeholder="Cognome" required/>
            <input type="text" name="cf" id="cf" placeholder="CF" onchange="controlloCF()" required/>
            <span id="infoCF"></span>
            <input type="text" name="username" placeholder="Username" id="username" onchange="controlloUsername()" required/>
            <span id="infoUsername"></span>
            <input type="email" name="email" id="email" placeholder="Email" required onchange="controlloEmail()"/>
            <span id="infoEmail"></span>
            <input type="password" name="pass" id="pass" placeholder="Password" required/>
            <input type="password" name="confPassword" id="confPassword" placeholder="Conferma Password" required onchange="controlloConfermaPass()"/>
            <span id="infoPassword"></span>
            <input type="submit" name="next" class="next action-button" id="bottone" value="Conferma" />
        </fieldset>
        </form>

    </div>
</div>

</div>
</body>
</html>