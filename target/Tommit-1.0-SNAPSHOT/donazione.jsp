<%--
  Created by IntelliJ IDEA.
  User: nicol
  Date: 12/02/2023
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Donazione</title>
    <link rel="stylesheet" href="static/css/donazione.css">
    <link rel="stylesheet" href="static/css/navbar.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
</head>
<body>
<%@ include file="navbar.jsp" %>



<div class="wrapperino">
    <div class="immagine">
        <img  src="static/immagini/logo.png">
    </div>
<label for="metodo">Metodo Di Pagamento</label>
<select class="info" name="metodo" id="metodo" onchange="popolaNome(this.id)" required>
    <option value="">Scegli Metodo Di Pagamento</option>
    <option value="cartadicredito">Carta Di Credito</option>
    <option value="paypal">PayPal</option>
    <option value="bitcoin">Bitcoin</option>
</select>

<!-- form carta di credito -->
<form class="testo" action="donazione" method="post" id="m1" style="display: none">
    <div class="wrap">
        <input type="hidden" name="metodoPagamento" value="cartadicredito">
        <label for="nome">Nome Titolare</label>
        <input type="text" name="nome" id="nome">
        <label for="ccNum">Numero Carta</label>
        <input type="text" name="ccNum" id="ccNum">
        <label for="cvv">CVV</label>
        <input type="text" name="cvv" id="cvv">
        <label for="scadenza">Scadenza</label>
        <input type="text" name="scadenza" id="scadenza">
    </div>
    <div>
        <label for="amount1">importo offerta</label>
        <input type="number" name="amount" id="amount1">
    </div>
    <input class ="bottone3" type="submit" value="Paga">
</form>
<!-- form PayPal -->
<form class="testo" action="donazione" method="post" id="m2" style="display: none">
    <div class="wrap">
        <input type="hidden" name="metodoPagamento" value="paypal">
        <label for="email">Email</label>
        <input type="email" name="email" id="email">
        <label for="password">Password</label>
        <input type="password" name="password" id="password">
    </div>
    <div>
        <label for="amount2">ammonto offerta</label>
        <input type="number" name="amount" id="amount2">
    </div>
    <input class ="bottone3" type="submit" value="Paga">
</form>
<!-- form Bitcoin -->
<form class="testo" ction="donazione" method="post" id="m3" style="display: none">
    <div class="wrap">
        <input type="hidden" name="metodoPagamento" value="bitcoin">
        <label for="wallet">Indirizzo wallet</label>
        <input type="text" name="wallet" id="wallet">
    </div>
    <div>
        <label for="amount3">ammonto offerta</label>
        <input type="number" name="amount" id="amount3">
    </div>
    <input class ="bottone3" type="submit" value="Paga">
</form>
</div>
<script>

    function popolaNome(s1){

        var s1 = document.getElementById(s1);  //metodo di pagamento

        var m1 = document.getElementById("m1");
        var m2 = document.getElementById("m2");
        var m3 = document.getElementById("m3");

        if (s1.value == ""){
            m1.style.display = "none";  //nasconde
            m2.style.display = "none"; //nasconde
            m3.style.display = "none"; //nasconde
        }else if(s1.value == "cartadicredito"){
            m1.style.display = "block";  //appare
            m2.style.display = "none"; //nasconde
            m3.style.display = "none"; //nasconde
        }else if(s1.value == "paypal"){
            m1.style.display = "none";  //nasconde
            m2.style.display = "block"; //appare
            m3.style.display = "none"; //nasconde
        }else if(s1.value == "bitcoin"){
            m1.style.display = "none";  //nasconde
            m2.style.display = "none"; //nasconde
            m3.style.display = "block"; //appare
        }

    }

</script>
</body>
</html>
