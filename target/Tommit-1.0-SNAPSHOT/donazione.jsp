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

    <form action="donazione" method="post">

        <select style = "width: 27em; height: 3em;" name="metodoPagamento" id="metodoPagamento">
            <option value="cartadicredito">Carta Di Credito</option>
            <option value="paypal">Paypal</option>
            <option value="bitcoin">Bitcoin</option>
        </select>

        <input type="email" name="email">
        <input type="password" name="password">
        <input type="text" name="amount">

        <input type="submit" value="Paga">

    </form>





</head>
<body>

</body>
</html>
