<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>
    </head>
    <body>
        <div class="container">
            <h1>Super Human Details</h1>
            <hr/>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>

            <h3>
                Name: <c:out value="${superPerson.name}"/>
            </h3>
            <h3>
                Description: <c:out value="${superPerson.description}"/>
            </h3>
            <h3>
                Power: <c:out value="${superPerson.superPower.description}"/>
            </h3>
            <h3>
                Organization(s):<br>
                <ul>
                    <c:forEach var="org" items="${superPerson.orgs}">
                        <li><c:out value="${org.name}"/></li>
                        </c:forEach>
                </ul>
            </h3>
            <a href="${pageContext.request.contextPath}/displaySuperPeoplePage"
               class="btn btn-danger">Back</a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setSuperHumansNavActive.js"></script>
    </body>
</html>