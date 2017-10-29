<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Hello Controller Page</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Super Human Sightings</h1>
            <hr/>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"  class="active"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <h2>${message}</h2>
            <div class="row">
                <div class="col-md-6">
                    <h2>Locations</h2>
                    <table id="locationTable" class="table table-hover">
                        <tr>
                            <th width="40%">Location Name</th>
                            <th width="30%">City</th>
                            <th width="10%">State</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentLocation" items="${locationList}">
                            <tr>
                                <td style="word-break:break-all;">
                                    <a href ="displayLocationDetails?locationId=${currentLocation.locationId}">
                                        <c:out value="${currentLocation.name}"/>
                                    </a>
                                </td>
                                <td style="word-break:break-all;">
                                    <c:out value="${currentLocation.city}"/>
                                </td>
                                <td>
                                    <c:out value="${currentLocation.state}"/>
                                </td>
                                <td>
                                    <a href="displayEditLocationForm?locationId=${currentLocation.locationId}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteLocation?locationId=${currentLocation.locationId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New Location</h2>
                    <sf:form class="form-horizontal"
                          role="form" method="POST"
                          action="createLocation">
                        <div class="form-group">
                            <label for="name" class="col-md-4 control-label">Location Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="name" placeholder="Location Name"
                                       required maxlength="45"/>
                                <sf:errors path="name" cssclass="error"></sf:errors>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="description" maxlength="45"
                                       placeholder="Description"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="street" class="col-md-4 control-label">Street:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="street" maxlength="45"
                                       placeholder="Street Address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="city" maxlength="45"
                                       placeholder="City"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="state" class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="state" maxlength="2"
                                       placeholder="State" pattern="[A-Za-z]{2}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="zip" class="col-md-4 control-label">Zip:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="zip" maxlength="10"
                                       pattern="(\d{5}([\-]\d{4})?)"
                                       placeholder="Zip Code"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="latitude" class="col-md-4 control-label">Latitude:</label>
                            <div class="col-md-8">
                                <input type="number" step="any" 
                                       class="form-control" name="latitude" 
                                       placeholder="Latitude" 
                                       min="-90" max="90"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="longitude" class="col-md-4 control-label">Longitude</label>
                            <div class="col-md-8">
                                <input type="number" step="any" 
                                       class="form-control" 
                                       name="longitude" placeholder="Longitude"
                                       min="-180" max="180"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-primary" value="Create Location"/>
                            </div>
                        </div>
                    </sf:form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

