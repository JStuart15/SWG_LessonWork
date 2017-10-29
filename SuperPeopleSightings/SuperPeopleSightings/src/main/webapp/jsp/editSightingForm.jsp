<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Super Human Sightings</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
    </head>
    <body>
        <div class="container">
            <h1>Edit Sighting</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <sf:form class="form-horizontal" role="form" modelAttribute="sighting"
                     action="editSighting" method="POST">
                <input type="hidden" name="sightingId" value="${sighting.sightingId}"/>
                <div class="form-group">
                    <label for="date" class="col-md-4 control-label">Date of Sighting:</label>
                    <div class="col-md-8">
                        <sf:input type="date" class="form-control" id="add-date"
                                  value="${sighting.date}" name="date" path="date"/>
                        <sf:errors path="date" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="location" class="col-md-4 control-label">Location of Sighting:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="location">
                            <c:forEach var="loc" items="${locationList}">
                                <c:choose>
                                    <c:when test="${sighting.location.locationId 
                                                    == loc.locationId}">
                                            <option value="${loc.locationId}"
                                                    selected>
                                                <c:out value="${loc.name}"/>
                                            </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${loc.locationId}">
                                            <c:out value="${loc.name}"/>
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                        <sf:errors path="location" cssclass="error"></sf:errors>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <a href="${pageContext.request.contextPath}/displayLocationsPage"
                           class="btn btn-default">Add New Location</a>
                    </div>
                </div>
                <div class="form-group">
                    <label for="superPeople" class="col-md-4 control-label">Super Humans Sighted:</label>
                    <div class="col-md-8">

                        <select multiple class="form-control" id="superPersonMultiSelect" name="superPersonList">
                            <c:forEach var="sp" items="${superPersonList}">
                                <c:set var="isSelected" value="false"/>
                                <c:forEach var="ssp" items="${sighting.superPeople}">
                                    <c:if test="${ssp.superPersonId == sp.superPersonId}">
                                        <c:set var="isSelected" value="true"/>
                                    </c:if>
                                </c:forEach>
                                <c:choose>
                                    <c:when  test="${isSelected}">
                                        <option value="${sp.superPersonId}" 
                                                selected="true">
                                            <c:out value="${sp.name}"/>
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${sp.superPersonId}"> 
                                            <c:out value="${sp.name}"/>
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <a href="${pageContext.request.contextPath}/displaySuperPeoplePage"
                           class="btn btn-default">Add New Super Human</a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-primary" value="Update Sighting"/>
                        <a href="${pageContext.request.contextPath}/displaySightingsPage"
                           class="btn btn-default">Cancel</a>
                    </div>

                </div>


            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>