<%-- 
    Document   : index
    Created on : 2-Oct-2017, 6:12:46 PM
    Author     : jstuart15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Factorizer</title>
    </head>
    <body>
        <h1>Factorizer App</h1>
        <p>Please enter the number that you want to factor.</p>
        <p>
        <form method='POST' action='FactorizerServlet'>
            <input type='text' name='numberToFactor'/>
            <input type='submit' value='Find Factors!!!'/>
        </form>
    </p>
</body>
</html>
