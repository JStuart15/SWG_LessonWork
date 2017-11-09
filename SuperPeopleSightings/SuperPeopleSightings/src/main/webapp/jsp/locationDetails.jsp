<%@include file="/WEB-INF/jspf/commonTagLibraries.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>     
    </head>
    <body>
        <div class="container">
            <h1>Contact Details</h1>
            <hr/>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>
            <h3>
                Location Name: <c:out value="${location.name}"/> <c:out value="${contact.lastName}"/>
            </h3>
            <h3>
                Description: <c:out value="${location.description}"/>
            </h3>
            <h3>
                Street: <c:out value="${location.street}"/>
            </h3>
            <h3>
                City: <c:out value="${location.city}"/>
            </h3>
            <h3>
                State: <c:out value="${location.state}"/>
            </h3>
            <h3>
                Zip: <c:out value="${location.zip}"/>
            </h3>
            <h3>
                Latitude: <c:out value="${location.latitude}"/>
            </h3>
            <h3>
                Longitude: <c:out value="${location.longitude}"/>
            </h3>
            <a href="${pageContext.request.contextPath}/displayLocationsPage"
               class="btn btn-danger">Back</a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setLocationNavActive.js"></script>
    </body>
</html>