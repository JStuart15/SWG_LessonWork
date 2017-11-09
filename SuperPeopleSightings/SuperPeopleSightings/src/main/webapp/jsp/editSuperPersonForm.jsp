<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>
    </head>
    <body>
        <div class="container">
            <h1>Edit Super Human</h1>
            <hr>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>
            <sf:form class="form-horizontal" role="form" modelAttribute="superPerson"
                     action="editSuperPerson" method="POST">
                <input type="hidden" name="superPersonId" value="${superPerson.superPersonId}"/>
                <div class="form-group">
                    <label for="name" class="col-md-4 control-label">Name: </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-name"
                                  path="name" placeholder="Super Human Name"
                                  required="true" maxlength="45"/>
                        <sf:errors path="name" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="imageURL" class="col-md-4 control-label">Image URL:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-imageURL"
                                  path="imageFileName" placeholder="URL of Image"
                                  maxlength="255"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="description" class="col-md-4 control-label">Description:</label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-description"
                                  path="description" placeholder="Description"
                                  maxlength="45"/>
                        <sf:errors path="description" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="power" class="col-md-4 control-label">Power:</label>
                        <div class="col-md-8">
                            <select class="form-control" name="power">
                                <option value="">None</option>
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
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <a href="${pageContext.request.contextPath}/displaySuperPowersPage"
                           class="btn btn-default">Add New Super Power</a>
                    </div>
                </div>
                <div class="form-group">
                    <label for="organizations" class="col-md-4 control-label">Organizations</label>
                    <div class="col-md-8">
                        <select multiple class="form-control" id="orgMultiSelect" name="orgList">
                            <option>None</option>
                            <c:forEach var="org" items="${orgList}">
                                <c:set var="isSelected" value="false"/>
                                <c:forEach var="personOrgs" items="${superPerson.orgs}">
                                    <c:if test="${personOrgs.organizationId == org.organizationId}">
                                        <c:set var="isSelected" value="true"/>
                                    </c:if>
                                </c:forEach>
                                <c:choose>
                                    <c:when  test="${isSelected}">
                                        <option value="${org.organizationId}" 
                                                selected="true">
                                            <c:out value="${org.name}"/>
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${org.organizationId}"> 
                                            <c:out value="${org.name}"/>
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <a href="${pageContext.request.contextPath}/displayOrganizationsPage"
                           class="btn btn-default">Add New Organization</a>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-offset-4 col-md-8">
                        <input type="submit" class="btn btn-danger" value="Update Super Human"/>
                        <a href="${pageContext.request.contextPath}/displaySuperPeoplePage"
                           class="btn btn-default" >Cancel</a>
                    </div>
                </div>
            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setSuperHumansNavActive.js"></script>
    </body>
</html>