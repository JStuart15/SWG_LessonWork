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
                    <h2>Super Human Organizations</h2>
                    <table id="organizationTable" class="table table-hover">
                        <tr>
                            <th width="40%">Organization Name</th>
                            <th width="30%">City</th>
                            <th width="10%">State</th>
                            <th width="10%"></th>
                            <th width="10%"></th>
                        </tr>
                        <c:forEach var="currentOrganization" items="${organizationList}">
                            <tr>
                                <td style="word-break:break-all;">
                                    <a href ="displayOrganizationDetails?organizationId=${currentOrganization.organizationId}">
                                        <c:out value="${currentOrganization.name}"/>
                                    </a>
                                </td>
                                <td style="word-break:break-all;">
                                    <c:out value="${currentOrganization.city}"/>
                                </td>
                                <td>
                                    <c:out value="${currentOrganization.state}"/>
                                </td>
                                <td>
                                    <a href="displayEditOrganizationForm?organizationId=${currentOrganization.organizationId}">
                                        Edit
                                    </a>
                                </td>
                                <td>
                                    <a href="deleteOrganization?organizationId=${currentOrganization.organizationId}">
                                        Delete
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                <div class="col-md-6">
                    <h2>Add New Organization</h2>
                    <form class="form-horizontal"
                          role="form" method="POST"
                          action="createOrganization">
                        <div class="form-group">
                            <label for="name" class="col-md-4 control-label">Organization Name:</label>
                            <div class="col-md-8">
                                <input type="text" name="orgname" 
                                       class="form-control" 
                                       placeholder="Organization Name" 
                                       required="true" maxlength="45"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="description" class="col-md-4 control-label">Description:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="description" maxlength="45"
                                       placeholder="Description"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="street" class="col-md-4 control-label">Street:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="street" maxlength="45"
                                       placeholder="Street Address"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="city" class="col-md-4 control-label">City:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="city" maxlength="45"
                                       placeholder="City"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="state" class="col-md-4 control-label">State:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="state" placeholder="State"
                                       maxlength="2" pattern="[A-Za-z]{2}"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="zip" class="col-md-4 control-label">Zip:</label>
                            <div class="col-md-8">
                                <input type="text" class="form-control" 
                                       name="zip" placeholder="Zip Code"
                                       pattern="(\d{5}([\-]\d{4})?)"
                                       maxlength="10"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="phone" class="col-md-4 control-label">Phone (with dashes):</label>
                            <div class="col-md-8">
                                <input type="phone" class="form-control" 
                                       name="phone" placeholder="Phone Number"
                                       pattern="\d{3}[\-]\d{3}[\-]\d{4}"
                                       maxlength="12"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-md-offset-4 col-md-8">
                                <input type="submit" class="btn btn-danger" value="Create Organization"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setOrganizationNavActive.js"></script>
    </body>
</html>

