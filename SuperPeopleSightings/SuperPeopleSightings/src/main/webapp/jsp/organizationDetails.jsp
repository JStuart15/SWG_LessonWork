<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Company Contacts</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">        
    </head>
    <body>
        <div class="container">
            <h1>Contact Details</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <h3>
                Organization Name: <c:out value="${organization.name}"/> 
            </h3>
            <h3>
                Description: <c:out value="${organization.description}"/>
            </h3>
            <h3>
                Street: <c:out value="${organization.street}"/>
            </h3>
            <h3>
                City: <c:out value="${organization.city}"/>
            </h3>
            <h3>
                State: <c:out value="${organization.state}"/>
            </h3>
            <h3>
                Zip: <c:out value="${organization.zip}"/>
            </h3>
            <h3>
                Phone Number: <c:out value="${organization.phone}"/>
            </h3>
            <a href="${pageContext.request.contextPath}/displayOrganizationsPage"
                           class="btn btn-danger" style="background-color: maroon;">Back</a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>