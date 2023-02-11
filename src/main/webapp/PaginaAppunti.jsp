<!DOCTYPE html>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <title>Appunti</title>
  <meta name="viewport" content="width=device-width, initial-scale=1"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css'>
  <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css'>
  <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/foundation/5.5.0/css/foundation.css'>
  <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
  <link rel="stylesheet" href="static/css/PaginaAppunti.css">

</head>

<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js'></script>

</html>

<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null ){ %>


<main>

  <section class="hero-unit">
    <%@ include file="/navbar.jsp"%>
    <div class="row2">
      <div class="large-12 columns">
        <hgroup>
          <h1>Appunti</h1>
          <h3>Inizia adesso, non domani!</h3>
        </hgroup>


        <ul class="small-block-grid-2 medium-block-grid-3 flip-cards">

          <li ontouchstart="this.classList.toggle('hover');">
            <div class="large button card-front">
              <a href="#">Umanistica</a>
              <i class="fa fa-book card-icon "></i>
            </div>
            <div class="panel card-back">
              <i class="fa fa-book card-icon"></i>
              <div class="hub-info">
                <form action="listAppuntiCategory" method="get">
                    <input type="hidden" name="category" value="umanistica" />
                    <input type="submit" value="Clicca qui">
                </form>
                <p>Qui puoi trovare gli appunti di Italiano, Storia, Letteratura, Latino...</p>
              </div>

            </div>
          </li>

          <li ontouchstart="">
            <div class="large button card-front">
              <a href="link">Scientifico</a>
              <i class="fa fa-calculator card-icon"></i>
            </div>

            <div class="panel card-back">
              <i class="fa fa-calculator card-icon"></i>
              <div class="hub-info">
                <form action="listAppuntiCategory" method="get">
                  <input type="hidden" name="category" value="scientifico" />
                  <input type="submit" value="Clicca qui">
                </form>
                <p>Qui puoi trovare appunti di Matematica, Fisica, Chimica...</p>
              </div>

            </div>
          </li>

          <li ontouchstart="this.classList.toggle('hover');">
            <div class="large button card-front">
              <a href="">Artistica</a>
              <i class="fa fa-paint-brush card-icon"></i>
            </div>

            <div class="panel card-back">
              <i class="fa fa-paint-brush card-icon"></i>
              <div class="hub-info">
                <form action="listAppuntiCategory" method="get">
                  <input type="hidden" name="category" value="artistico" />
                  <input type="submit" value="Clicca qui">
                </form>
                <p>Qui puoi trovare appunti di Storia dell'arte, Tecnologia, Architettura...</p>
              </div>

            </div>
          </li>

          <li ontouchstart="this.classList.toggle('hover');">
            <div class="large button card-front">
              <a href="">Informatica</a>
              <i class="fa fa-code card-icon"></i>
            </div>

            <div class="panel card-back">
              <i class="fa fa-code card-icon"></i>
              <div class="hub-info">
                <form action="listAppuntiCategory" method="get">
                  <input type="hidden" name="category" value="informatica" />
                  <input type="submit" value="Clicca qui">
                </form>
                <p>Qui puoi trovare appunti di programmazione(C, C++, Java...), Software Engineering... </p>
              </div>

            </div>
          </li>

          <li ontouchstart="this.classList.toggle('hover');">
            <div class="large button card-front">
              <a href="http://www.keytokorean.com">Lingue</a>
              <i class="fa fa-language card-icon"></i>
            </div>

            <div class="panel card-back">
              <i class="fa fa-language card-icon"></i>
              <div class="hub-info">
                <form action="listAppuntiCategory" method="get">
                  <input type="hidden" name="category" value="lingue" />
                  <input type="submit" value="Clicca qui">
                </form>
                <p>Qui puoi trovare appunti di Inglese, Francese, Spagnolo, Tedesco...</p>
              </div>

            </div>
          </li>

          <li ontouchstart="this.classList.toggle('hover');">
            <div class="large button card-front">
              <a href="http://www.aicfchurch.org">Sanitario</a>
              <i class="fa fa-stethoscope card-icon"></i>
            </div>

            <div class="panel card-back">
              <i class="fa fa-stethoscope card-icon"></i>
              <div class="hub-info">
                <form action="listAppuntiCategory" method="get">
                  <input type="hidden" name="category" value="sanitario" />
                  <input type="submit" value="Clicca qui">
                </form>
                <p>Qui puoi trovare appunti per prepararti al meglio per il test di Medicina e per i futuri esami</p>
              </div>

            </div>
          </li>

        </ul>
      </div>
    </div>

  </section>

</main>
<!-- partial -->
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
<script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/gsap/1.18.0/TweenMax.min.js'></script><script  src="../js/script.js"></script>
<script src='https://cdnjs.cloudflare.com/ajax/libs/foundation/5.5.2/js/foundation.min.js'></script>
</body>
</html>
