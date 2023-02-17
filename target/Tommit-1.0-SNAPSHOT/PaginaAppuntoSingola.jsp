<%@ page import="model.entity.AppuntiBean" %>
<%@ page import="model.entity.UtenteBean" %>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="UTF-8">
    <title>${currentAppunto.getTitolo()}</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1"><link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css'>
    <link rel='stylesheet' href='//cdnjs.cloudflare.com/ajax/libs/animate.css/3.2.3/animate.min.css'>
    <link rel='stylesheet' href='//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel='stylesheet' href='https://cdn.jsdelivr.net/foundation/5.5.0/css/foundation.css'>
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css'>
    <link rel="stylesheet" href="./static/css/PaginaAppuntoSIngola.css">

</head>
<body>
<% if(((UtenteBean)request.getSession().getAttribute("utenteLoggato"))!=null ){ %>
<main>

    <section class="hero-unit">
        <%@ include file="/navbar.jsp"%>
<!-- partial:index.partial.html -->

            <div class="rating">
                <input type='radio' hidden name='rate' id='rating_opt5' data-idx='0'>
                <label for='rating_opt5'><span>Uno dei migliori!</span></label>

                <input type='radio' hidden name='rate' id='rating_opt4' data-idx='1'>
                <label for='rating_opt4'><span>fantastico</span></label>

                <input type='radio' hidden name='rate' id='rating_opt3' data-idx='2'>
                <label for='rating_opt3'><span>interessante...</span></label>

                <input type='radio' hidden name='rate' id='rating_opt2' data-idx='3'>
                <label for='rating_opt2'><span>Non male</span></label>

                <input type='radio' hidden name='rate' id='rating_opt1' data-idx='4'>
                <label for='rating_opt1'><span>Non sprecare il tuo tempo!</span></label>
            </div>

        <div>
            <div class="bottone" >
                <form action="salva-appunti">
                <button class="btn2">
                        <input type="hidden" name="idAppunti" value="${currentAppunto.getId()}">
                    Salva appunti
                </button>
                </form>
            </div>
            <h1> ${currentAppunto.getTitolo()}</h1>
            <p>${currentAppunto.getTesto()}</p>
        </div>
    </section>
</main>

<!-- partial -->
<%} else{ response.sendRedirect("./utenteNonRegistrato.jsp");}%>
</body>
</html>
