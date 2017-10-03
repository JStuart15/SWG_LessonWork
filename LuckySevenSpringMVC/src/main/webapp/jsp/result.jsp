<%-- 
    Document   : result
    Created on : 3-Oct-2017, 2:35:45 PM
    Author     : jstuart15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Result</h1>
        <hr>
        <p>You had $${dollars} before the game started</p>
        <p>It took you ${brokeAfter} rolls to lose all your money.</p>
        <p>You should have stopped at roll number ${quitRolls} when you had $${maxDollars}.</p>
        <p>
            <a href="index.jsp">Try again</a>
        </p>
    </body>
</html>
