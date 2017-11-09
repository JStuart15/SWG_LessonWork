<%@include file="/WEB-INF/jspf/commonTagLibraries.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>
    <body>
        <div class="container">
            <h1>Super Human Sightings</h1>
            <hr/>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>
            <h2>${message}</h2>
            <div class="row">
                <div class="col-md-6">
                    <h2>Super Powers</h2>
                    <table id="superpowerTable" class="table table-hover">
                        <tr>
                            <th>Description</th>
                            <th></th>
                        </tr>
                        <c:forEach var="currentSuperPower" items="${superPowerList}">
                            <tr>
                                <td>
                                    <c:out value="${currentSuperPower.description}"/>
                                </td>
                                <td>
                                    <a href="deleteSuperPower?superPowerId=${currentSuperPower.superPowerId}">
                                        Inactivate
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New SuperPower</h2>
                    <form class="form-horizontal"
                          role="form" method="POST"
                          action="createSuperPower">

                        <div class="form-group">
                            <label for="description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="description" required
                                       maxlength="45"
                                       placeholder="Description"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-danger" value="Create SuperPower"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setSightingNavActive.js"></script>        
    </body>
</html>

