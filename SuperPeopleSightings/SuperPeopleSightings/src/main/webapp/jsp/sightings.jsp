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
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <h2>${message}</h2>
            <div class="col-md-6">
                <h2>Sightings</h2>
                <table id="sightingsTable" class="table table-hover">
                    <tr>
                        <th width="20%">Date</th>
                        <th width="30%">Location</th>
                        <th width="30%">Super Humans</th>
                        <th width="10"></th>
                        <th width="10"></th>
                    </tr>
                    <tbody id="content-rows">
                        <c:forEach var="currentSighting" items="${sightingList}">
                            <tr>
                                <td>
                                    <a style="color: maroon;" href ="displaySightingDetails?sightingId=${currentSighting.sightingId}">
                                        <fmt:formatDate pattern="MM/dd/yyyy" 
                                                        value="${currentSighting.displayDate}"
                                                        />
                                    </a>
                                </td>
                                <td style="word-break:break-all;">
                                    <c:out value="${currentSighting.location.name}"/>
                                </td>
                                <td style="word-break:break-all;">
                                    <c:forEach var="superPerson" items="${currentSighting.superPeople}">
                                        <c:out value="${superPerson.name}"/><br>
                                    </c:forEach>
                                </td>
                                <td>
                                    <a style="color: maroon;" href="displayEditSightingForm?sightingId=${currentSighting.sightingId}">
                                        Edit
                                    </a>
                                </td>
                                <td><a style="color: maroon;" href="deleteSighting?sightingId=${currentSighting.sightingId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-md-6">
                <h2>Add New Sighting</h2>
                <form class="form-horizontal"
                      role="form" method="POST"
                      action="createSighting">

                    <div class="form-group">
                        <label for="dateJQuery" class="col-md-4 control-label">Date:</label>
                        <div class="col-md-8">
                            <input type="text" id="datepicker" 
                                   class="form-control" name="dateJQuery"
                                   required="true"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="description" class="col-md-4 control-label">Location:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="location" required="true">
                                <option value="" selected disabled>Choose a location</option>
                                <c:forEach var="location" items="${locationList}">
                                    <option value="${location.locationId}">
                                        <c:out value="${location.name}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <a href="${pageContext.request.contextPath}/displayLocationsPage" 
                               class="btn btn-default">Add Location</a>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="organizations" class="col-md-4 control-label">Super Humans:</label>
                        <div class="col-md-8">
                            <select multiple class="form-control" 
                                    id="superPersonMultiSelect" 
                                    name="spSelect" required="true">
                                <c:forEach var="superPerson" items="${superPersonList}">
                                    <option value="${superPerson.superPersonId}">
                                        <c:out value="${superPerson.name}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <a href="${pageContext.request.contextPath}/displaySuperPeoplePage" 
                               class="btn btn-default">Add Super Human</a>
                        </div>
                    </div>
                    <div class="form-group">

                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-danger"
                                   style="background-color: maroon;"
                                   value="Create Sighting"/>
                        </div>
                    </div>
                </form>
            </div>
            <!-- Placed at the end of the document so the pages load faster -->
            <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
            <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
            <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
            <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
            <script>
                $(function () {
                    $("#datepicker").datepicker();
                });
            </script>
    </body>
</html>

