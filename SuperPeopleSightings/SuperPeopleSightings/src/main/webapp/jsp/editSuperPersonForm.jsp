<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Directive for Spring Form tag libraries -->
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
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
            <h1>Edit Super Human</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super People</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <sf:form class="form-horizontal" role="form" modelAttribute="superPerson"
                     action="editSuperPerson" method="POST">
                <div class="form-group">
                    <label for="name" class="col-md-4 control-label">Name: </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-name"
                                  path="name" placeholder="Super Human Name"/>
                        <sf:errors path="name" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="description" class="col-md-4 control-label">Description:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-description"
                                  path="description" placeholder="Description"/>
                        <sf:errors path="description" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="power" class="col-md-4 control-label">Power:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="power">
                            <c:forEach var="power" items="${superPowerList}">
                                <c:choose>
                                    <c:when test="${superPerson
                                                    .superPower
                                                    .superPowerId 
                                                    == power.superPowerId}">
                                            <option value="${power.superPowerId}" selected>
                                                <c:out value="${power.description}"/>
                                            </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${power.superPowerId}">
                                            <c:out value="${power.description}"/>
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                                <option value="${power.superPowerId}">
                                    <c:out value="${power.description}"/>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-primary" value="Add New Super Power"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="organizations" class="col-md-4 control-label">Organizations</label>
                    <div class="col-md-8">
                        <select multiple class="form-control" id="orgMultiSelect">

                            <c:forEach var="org" items="${orgList}">
                                <c:forEach var="personOrgs" items="${superPerson.orgs}">
                                    <c:choose>
                                        <c:when test="${personOrgs.organizationId == org.organizationId}">
                                            <option 
                                                value="${org.organizationId}" 
                                                selected>
                                                <c:out value="${org.name}"/>
                                            </option>
                                        </c:when>
                                        <c:when test="${personOrgs.organizationId != org.organizationId}">
                                            <option 
                                                value="${org.organizationId}">
                                                <c:out value="${org.name}"/>
                                            </option>
                                        </c:when>
                                    </c:choose>
                                </c:forEach>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="organizations" class="col-md-4 control-label">Organizations</label>
                    <div class="col-md-8">
                        <sf:select path="${orgs.organizationId}" multiple="true" class="form-control" id="orgMultiSelect">
                            <sf:option value="No organizational affiliation"/>
                            <c:forEach var="daoOrg" items="${orgList}">
                                <c:forEach var="personOrg" items="${superPerson.orgs}">
                                    <c:choose>
                                        <c:when test="${personOrg.organizationId == daoOrg.organizationId}">
                                            <sf:option 
                                                value="${daoOrg.organizationId}" 
                                                selected="true">
                                                <c:out value="${daoOrg.name}"/>
                                            </sf:option>
                                        </c:when>
                                        <c:otherwise>
                                            <sf:option 
                                                value="${daoOrg.organizationId}">
                                                <c:out value="${daoOrg.name}"/>
                                            </sf:option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </c:forEach>
                        </sf:select>
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-primary" value="Add New Organization"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-primary" value="Update Super Human"/>
                    </div>
                </div>


            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>