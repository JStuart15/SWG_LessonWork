<%@include file="/WEB-INF/jspf/commonTagLibraries.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %> 
    </head>
    <body>
        <div class="container">
            <h1>Edit Sighting</h1>
            <hr>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>
            <sf:form class="form-horizontal" role="form" modelAttribute="sighting"
                     action="editSighting" method="POST">
                <input type="hidden" name="sightingId" value="${sighting.sightingId}"/>
                <input type="hidden" id="dateSelected" 
                       value="<fmt:formatDate pattern="yyyy/MM/dd" value="${sighting.displayDate}"/>"/>
                <div class="form-group">
                    <label for="dateJQuery" class="col-md-4 control-label">Date:</label>
                    <div class="col-md-8">
                        <input type="text" id="datepicker" 
                               required="true" class="form-control" name="dateJQuery"
                               value="<fmt:formatDate pattern="MM/dd/yyyy" value="${sighting.displayDate}"/>"
                               />
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
                        <input type="submit" class="btn btn-danger" 
                               value="Update Sighting"/>
                        <a href="${pageContext.request.contextPath}/displaySightingsPage"
                           class="btn btn-default" 
                           >Cancel</a>
                    </div>

                </div>


            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setSightingNavActive.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#datepicker").datepicker();
                $("#datepicker").datepicker("setDate", new Date($("#dateSelected").val()));
            });
        </script>

    </body>
</html>