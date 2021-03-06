<%@include file="/WEB-INF/jspf/commonTagLibraries.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>
    </head>
    <body>
        <div class="container">
            <h1>Edit Location</h1>
            <hr>
            <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>
            <sf:form class="form-horizontal" role="form" modelAttribute="location"
                     action="editLocation" method="POST">
                <div class="form-group">
                    <label for="name" class="col-md-4 control-label">Location Name: </label>
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-name"
                                  path="name" placeholder="Location Name"
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
                                  maxlength="2"/>
                        <sf:errors path="state" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-zip" class="col-md-4 control-label">Zip:</label>                          
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-street"
                                  path="zip" placeholder="Zip"
                                  pattern="(\d{5}([\-]\d{4})?)"
                                  maxlength="10"/>
                        <sf:errors path="zip" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="add-latitude" class="col-md-4 control-label">Latitude:</label>
                        <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-latitude"
                                  path="latitude" placeholder="Latitude"
                                  min="-90" max="90"/>
                        <sf:errors path="latitude" cssclass="error"></sf:errors>
                        <sf:hidden path="locationId"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="add-longitude" class="col-md-4 control-label">Longitude:</label>                          
                    <div class="col-md-8">
                        <sf:input type="text" class="form-control" id="add-longitude"
                                  path="longitude" placeholder="Longitude"
                                  min="-180" max="180"/>
                        <sf:errors path="longitude" cssclass="error"></sf:errors>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-offset-4 col-md-8">
                            <input type="submit" class="btn btn-danger"
                                   value="Update Location"/>
                            <a href="${pageContext.request.contextPath}/displayLocationsPage"
                           class="btn btn-default">Cancel</a>
                    </div>
                </div>
            </sf:form>
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/setLocationNavActive.js"></script>
    </body>
</html>