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
            <h2>${message}</h2>
            <div class="row">
                <div class="col-md-6">
                    <h2>Super Humans</h2>
                    <table id="superPeopleTable" class="table table-hover">
                        <tr>
                            <th width="25%">Name</th>
                            <th width="25%">Power</th>
                            <th width="25%">Organizations</th>
                            <th width="12.5%"></th>
                            <th width="12.5%"></th>
                        </tr>
                        <c:forEach var="currentSuperPerson" items="${superPersonList}">
                            <tr>
                                <td style="word-break:break-all;">
                                    <a href ="displaySuperPersonDetails?superPersonId=${currentSuperPerson.superPersonId}">
                                        <c:out value="${currentSuperPerson.name}"/>
                                    </a>
                                </td>
                                <td style="word-break:break-all;">
                                    <c:out value="${currentSuperPerson.superPower.description}"/>
                                </td>
                                <td style="word-break:break-all;">
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
                          action="createSuperPerson"
                          enctype="multipart/form-data">
                        <div class="form-group">
                            <label for="name" class="col-md-4 control-label">Name:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="name" required 
                                       maxlength="45"
                                       placeholder="Super Human Name"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="imageURL" class="col-md-4 control-label">Image URL:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="imageURL" 
                                       maxlength="255"
                                       placeholder="URL of Image"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="description" 
                                       maxlength="45"
                                       placeholder="Description"/>
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
                            <div class="col-md-offset-4 col-md-8">
                                <a href="${pageContext.request.contextPath}/displaySuperPowersPage" 
                                   class="btn btn-default">Add Super Power</a>
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
                                <a href="${pageContext.request.contextPath}/displayOrganizationsPage" 
                                   class="btn btn-default">Add Organization</a>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-danger" value="Create Super Human"/>
                            </div>
                        </div>

                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setSuperHumansNavActive.js"></script>
    </body>
</html>

