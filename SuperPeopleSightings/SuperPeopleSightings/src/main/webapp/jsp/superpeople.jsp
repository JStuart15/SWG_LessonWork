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
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <h2>${message}</h2>
            <div class="row">
                <div class="col-md-6">
                    <h2>Super Humans</h2>
                    <table id="superPeopleTable" class="table table-hover">
                        <tr>
                            <th>Name</th>
                            <th>Power</th>
                            <th>Organizations</th>
                            <th></th>
                            <th></th>
                        </tr>
                        <c:forEach var="currentSuperPerson" items="${superPersonList}">
                            <tr>
                                <td>
                                    <a href ="displaySuperPersonDetails?superPersonId=${currentSuperPerson.superPersonId}">
                                        <c:out value="${currentSuperPerson.name}"/>
                                    </a>
                                </td>
                                <td>
                                    <c:out value="${currentSuperPerson.superPower.description}"/>
                                </td>
                                <td>
                                    <c:forEach var="org" items="${currentSuperPerson.orgs}">
                                        <c:out value="${org.name}"/><br>
                                    </c:forEach>
                                </td>
                                <td>
                                    <a href="displayEditSuperPersonForm?superPersonId=${currentSuperPerson.superPersonId}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteSuperPerson?superPersonId=${currentSuperPerson.superPersonId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New Super Human</h2>
                    <form class="form-horizontal"
                          role="form" method="POST"
                          action="createSuperPerson">
                        <div class="form-group">
                            <label for="name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="name" placeholder="Super Human Name"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" name="description" placeholder="Description"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="power" class="col-md-4 control-label">Power:</label>
                            <div class="col-md-8">
                                <select class="form-control" name="power">
                                    <option value="" selected disabled>Choose a power</option>
                                    <c:forEach var="power" items="${superPowerList}">
                                        <option value="${power.superPowerId}">
                                            <c:out value="${power.description}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="organizations" class="col-md-4 control-label">Organizations:</label>
                            <div class="col-md-8">
                                <select multiple class="form-control" id="orgMultiSelect" name="orgSelect">
                                    <c:forEach var="org" items="${orgList}">
                                        <option value="${org.organizationId}">
                                            <c:out value="${org.name}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-primary" value="Create Super Human"/>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    </body>
</html>

