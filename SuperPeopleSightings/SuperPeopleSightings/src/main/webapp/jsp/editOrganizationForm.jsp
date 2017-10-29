<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Organizations</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">  
    </head>
    <body>
        <div class="container">
            <h1>Edit Organization</h1>
            <hr>
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super People</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>
            <sf:form class="form-horizontal" role="form" modelAttribute="organization"
                     action="editOrganization" method="POST">
                <div class="form-group">
                    <label for="name" class="col-md-4 control-label">Organization Name: </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-name"
                                  path="name" placeholder="Organization Name"
                                  maxlength="45"/>
                        <sf:errors path="name" cssclass="error"></sf:errors>
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
                        <label for="add-street" class="col-md-4 control-label">Street:</label>                          
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-street"
                                  path="street" placeholder="Street Address"
                                  maxlength="45"/>
                        <sf:errors path="street" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-city" class="col-md-4 control-label">City:</label>                          
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-city"
                                  path="city" placeholder="City"
                                  maxlength="45"/>
                        <sf:errors path="city" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-state" class="col-md-4 control-label">State:</label>                          
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-street"
                                  path="state" placeholder="State"
                                  maxlength="2" pattern="[A-Za-z]{2}"/>
                        <sf:errors path="state" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip:</label>                          
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-street"
                                  path="zip" placeholder="Zip" maxlength="10"
                                  pattern="(\d{5}([\-]\d{4})?)"/>
                        <sf:errors path="zip" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-phone" class="col-md-4 control-label">Phone (with dashes):</label>
                        <div class="col-md-8">
                        <sf:input type="phone" class="form-control" id="add-phone"
                                  path="phone" placeholder="Phone Number"
                                  maxlength="12" pattern="\d{3}[\-]\d{3}[\-]\d{4}"/>
                        <sf:errors path="phone" cssclass="error"></sf:errors>
                        <sf:hidden path="organizationId"/>
                    </div>
                </div>
                
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-primary" value="Update Organization"/>
                            <a href="${pageContext.request.contextPath}/displayOrganizationsPage"
                           class="btn btn-default">Cancel</a>
                        </div>
                    </div>
            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    </body>
</html>