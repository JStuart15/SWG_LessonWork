<%-- 
    Document   : result
    Created on : 2-Oct-2017, 7:18:00 PM
    Author     : jstuart15
--%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <h1>Flooring Calculation Results</h1>
        <hr>
        <h2>Project Details</h2>
        <p>Flooring area width: <c:out value="${width}"/></p>
        <p>Flooring area height: <c:out value="${height}"/></p>
        <p>Cost per square foot of flooring material: <c:out value="${costPsf}"/></p>
        <p>Cost of Flooring Material is $ <c:out value="${matCost}"/></p>
        <p>Cost of Flooring Labor is $ <c:out value="${laborCost}"/></p>
        <p>Total Cost is $ <c:out value="${totalCost}"/></p>
        <p><a href="index.jsp">Calculate Another Project</a></p>
    </body>
</html>
