    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
        <!Doctype html Public "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html>
        <head>
        <meta http-equiv="Content-type" content="text/html; charset=ISO-8859-1">
        <title>Insert title</title>
        </head>
        <body>
        <form action="credit" method="post" type="number" min="0">
        <label>Kwota Kredytu:<input type="text" id="loanAmountRequested" name="loanAmountRequested">zl</label><br>
        <label>Ilosc lat:<input type="text"  id="numberOfInstallments" name="numberOfInstallments"></label><br>
        <label>Oprocentowanie:<input type="text"  id="interest" name="interest">%</label><br>
        <label>Oplata stala:<input type="text" id="fixedFee" name="fixedFee">zl</label><br>
        <label>Rodzaj rat: <input type="radio" value="lowering" name="typeofInstallments">Malejaca   <input type="radio" value="static" name="typeofInstallments">Stala</label><br>
        <input type="submit" value="wyslij">
        </form>
        </body>
        </html>