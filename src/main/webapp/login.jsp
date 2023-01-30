<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="static/css/navbar.css">

  <link rel="stylesheet" href="static/css/login.css">
  <link rel="stylesheet" href="static/css/background.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.7/prefixfree.min.js"></script>

</head>

<body>
<div class="bg-img">
  <%@ include file="navbar.jsp"%>

<div class="content">

  <div class="form-wrapper">

    <div class="linker">

      <span class="ring"></span>
      <span class="ring"></span>
      <span class="ring"></span>
      <span class="ring"></span>
      <span class="ring"></span>
    </div>

    <form class="login-form" action="accesso-utente-servlet" method="post">
      <input type="text" name="username" placeholder="username" />
      <input type="password" name="password" placeholder="password" />
      <button type="submit">Log in</button>
      <a href="Registrazione.jsp">Registrati!</a>

    </form>
  </div>
</div>
</div>
</body>
</html>