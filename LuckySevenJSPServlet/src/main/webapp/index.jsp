<%-- 
    Document   : index
    Created on : 3-Oct-2017, 11:21:35 AM
    Author     : jstuart15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lucky Sevens</title>
    </head>
    <body>
        <h1>Lucky Sevens</h1>
        <hr>
        <form method="POST" action="LuckySevenServlet">
            <p>
                How much money do you have? 
                <input type="number"/>
            </p>
            <input type="submit" value="Roll the Die"/>
        </form>
    </body>
</html>
