<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sightings</title>  
        <!-- Bootstrap core CSS-->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"> 
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"> -->
        <style>
            #map{
                width: 550px;
                height: 400px;
                background-color: grey;
            }
        </style>
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-3">Have you seen a hero or villain?</h1>
                <p class="lead">If so, tell us about it and help us track their whereabouts...</p>
            </div>
        </div>
        <div class="container">
            <div class="navbar">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                    <li role="presentation"><a href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
                </ul>    
            </div>

            <div class="row">
                <h3 class="col-md-6">Latest Hero/Villain Sightings</h3>
                <h3 class="col-md-6">Latest Locations</h3>
            </div>
            <div class="row">
                <div class="list-group col-md-6">
                    <c:forEach var="currentSighting" items="${sightingList}" 
                               varStatus="theCount">
                        <a href="/SuperPeopleSightings/displaySightingDetails?sightingId=${currentSighting.sightingId}" 
                           class="list-group-item list-group-item-action"
                           id="sighting-${currentSighting.sightingId}">

                            <c:forEach var="currentHero" items="${currentSighting.superPeople}">
                                <c:out value="${currentHero.name}"/>,
                            </c:forEach>
                            sighted at
                            <c:out value="${currentSighting.location.name}"/> on
                            <c:out value="${currentSighting.date}"/>
                        </a>
                        <input type="number" hidden value="${currentSighting.location.latitude}"
                               id="sighting-${theCount.count}-latitude"/>
                        <input type="number" hidden value="${currentSighting.location.longitude}"
                               id="sighting-${theCount.count}-longitude"/>
                    </c:forEach>
                </div>
                <div id="map" class="col-md-6">
                </div>
            </div>

        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            function initMap() {
                //var uluru = {lat: -25.363, lng: 131.044};
                //var latitude = parseFloat(document.getElementById('sighting-8-latitude').value);
                //var longitude = parseFloat(document.getElementById('sighting-8-longitude').value);
                //console.log(latitude, longitude);
                var uluru = {lat: 39.8283, lng: -98.5795};
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 4,
                    center: uluru,
                    mapTypeId: 'terrain'
                });
                for (var i = 1; i < 11; i++) {
                    var latitude = parseFloat(document.getElementById('sighting-' + i + '-latitude').value);
                    var longitude = parseFloat(document.getElementById('sighting-' + i + '-longitude').value);
                    var uluru = {lat: latitude, lng: longitude};
                    var marker = new google.maps.Marker({
                        position: uluru,
                        map: map
                    });
                }
            }
        </script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAU601CAmYmF97gSGTDNCEU6tBgeppKVX8&callback=initMap">
        </script>
    </body>
</html>

