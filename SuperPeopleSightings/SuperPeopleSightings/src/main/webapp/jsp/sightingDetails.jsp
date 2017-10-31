<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Human Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Super Human Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <h3>
                Date: <fmt:formatDate pattern="MM/dd/yyyy" value="${sighting.displayDate}"/>

            </h3>
            <h3>
                Location: <c:out value="${sighting.location.name}"/>,
                <c:out value="${sighting.location.city}"/>, 
                <c:out value="${sighting.location.state}"/>
            </h3>

            <h3>
                    Super Human(s):<br>
                    <table class="table">
                        <c:forEach var="superPerson" items="${sighting.superPeople}">
                            <tr> 
                                <td>
                                    <c:out value="${superPerson.name}"/>
                                    <img src="${superPerson.imageFileName}" 
                                         class="img-thumbnail img-circle col-sm-1"/>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
            </h3>

            <a style="background-color: maroon;" 
               href="${pageContext.request.contextPath}/displaySightingsPage"
               class="btn btn-danger">Back</a>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>