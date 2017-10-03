<%-- 
    Document   : index
    Created on : 2-Oct-2017, 7:03:45 PM
    Author     : jstuart15
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Flooring Calculator</title>

    </head>
    <body>
        <h1>Flooring Calculator</h1>
        <hr>
        <p>This site calculates the cost of a flooring project.</p>
        <p>
        <form method="POST" action="FlooringServlet">
            <p>Width:<input type="number" name="width" placeholder="width"/></p>
            <p>Height:<input type="number" name="height" placeholder="height"/></p>
            <p>Cost per square foot of the flooring material:<input type="number" name="costpsf" placeholder="Cost psf"/></p>
            <input type="submit" value="Calculate"/>
        </form>

       
    </body>
</html>
