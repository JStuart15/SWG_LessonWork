<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sightings</title>  
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Super Human Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    
                </ul>    
            </div>
            <h2>${message}</h2>
            
            
            <table id="sightingsTable" class="table table-hover">
                       <tr>
                           <th width="25%">Date</th>
                           <th width="25%">Location</th>
                           <th width="25%">Supers</th>
                           <th width="25%">Organization</th>
                       </tr>
                       <tbody id="content-rows">
                           <c:forEach var="sighting" items="${sightingList}">
                               <tr>
                                   <td>
                                       <c:out value="${sighting.date}"/>
                                   </td>
                                   <td>
                                       <c:out value="${sighting.location.name}"/>
                                   </td>
                                   <td>
                                       <c:forEach var="hero" items="${sighting.supers}">
                                           <c:out value="${hero.name}"/><br><br>
                                       </c:forEach>
                                   </td>
                                   <td>
                                       <c:forEach var="hero" items="${sighting.supers}">
                                           <c:forEach var="org" items="${hero.organizations}">
                                               <c:out value="${org.name}"/><br>
                                           </c:forEach><br>
                                       </c:forEach>
                                   </td>
                               </tr>
                           </c:forEach>
                       </tbody>
                   </table>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

