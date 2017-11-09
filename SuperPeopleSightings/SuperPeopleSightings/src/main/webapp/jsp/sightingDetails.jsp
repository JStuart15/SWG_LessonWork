<%@include file="/WEB-INF/jspf/commonTagLibraries.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>     
    </head>
    <body>
        <div class="container">
            <h1>Super Human Sightings</h1>
            <hr/>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>
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

            <a href="${pageContext.request.contextPath}/displaySightingsPage"
               class="btn btn-danger">Back</a>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setSightingNavActive.js"></script>
    </body>
</html>