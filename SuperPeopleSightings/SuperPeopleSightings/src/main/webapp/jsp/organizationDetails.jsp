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
               class="btn btn-danger">Back</a>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setOrganizationNavActive.js"></script>
    </body>
</html>