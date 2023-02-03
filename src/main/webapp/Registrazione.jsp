<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>Registrazione</title>
    <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="static/css/navbar.css">

    <link rel="stylesheet" href="static/css/Registrazione.css">
    <link rel="stylesheet" href="static/css/background.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>
<body>
<div class="bg-img">
    <%@ include file="/static/html/navbar.html"%>
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
            <input type="text" name="nome" placeholder="Nome" />
            <input type="text" name="cognome" placeholder="Cognome" />
            <input type="text" name="cf" placeholder="CF" />
            <input type="text" name="username" placeholder="Username" />
            <input type="text" name="email" placeholder="Email" />
            <input type="password" name="pass" placeholder="Password" />
            <input type="password" name="cpass" placeholder="Conferma Password" />
            <input type="submit" name="next" class="next action-button" value="Conferma" />
        </fieldset>
        </form>

    </div>
</div>

</div>
</body>
</html>