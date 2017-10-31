<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
        <div class="container">
            <div class="jumbotron jumbotron-fluid" style="background-image: 
                 url(http://maquinnasuperheroes.pbworks.com/f/1347855554/banner-corporate.jpg); background-size: 100%;">
                <div class="container">
                    <h1 class="display-3" style="color: white">Have you seen a hero or villain?</h1>
                    <p class="lead" style="color:white">If so, tell us about it and help us track their whereabouts...</p>
                </div>
            </div>
            <div class="container">
                <div class="navbar">
                    <ul class="nav nav-tabs">
                        <li role="presentation" class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
                        <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displaySuperPeoplePage">Super Humans</a></li>
                        <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayLocationsPage">Locations</a></li>
                        <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displayOrganizationsPage">Organizations</a></li>
                        <li role="presentation"><a style="color:maroon" href="${pageContext.request.contextPath}/displaySightingsPage">Sightings</a></li>
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

                                    <c:out value="${currentHero.name}"/>
                                    <img src="${currentHero.imageFileName}" 
                                         class="img-circle col-sm-1"/>
                                </c:forEach>
                                sighted at
                                <c:out value="${currentSighting.location.name}"/> on
                                <fmt:formatDate pattern="MM/dd/yyyy" value="${currentSighting.displayDate}"/>
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
        </div>
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script>
            function initMap() {
                var uluru = {lat: 39.8283, lng: -98.5795};
                var map = new google.maps.Map(document.getElementById('map'), {
                    zoom: 4,
                    center: uluru,
                    //mapTypeId: 'terrain'

                    styles: [
                        {
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#f5f5f5"
                                }
                            ]
                        },
                        {
                            "elementType": "labels.icon",
                            "stylers": [
                                {
                                    "visibility": "off"
                                }
                            ]
                        },
                        {
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#616161"
                                }
                            ]
                        },
                        {
                            "elementType": "labels.text.stroke",
                            "stylers": [
                                {
                                    "color": "#f5f5f5"
                                }
                            ]
                        },
                        {
                            "featureType": "administrative.land_parcel",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#bdbdbd"
                                }
                            ]
                        },
                        {
                            "featureType": "landscape.natural.landcover",
                            "elementType": "geometry.fill",
                            "stylers": [
                                {
                                    "color": "#bdbdbd"
                                    //"color": "#ffffff"
                                }
                            ]
                        },
                        {
                            "featureType": "poi",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#eeeeee"
                                }
                            ]
                        },
                        {
                            "featureType": "poi",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#757575"
                                }
                            ]
                        },
                        {
                            "featureType": "poi.park",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#e5e5e5"
                                }
                            ]
                        },
                        {
                            "featureType": "poi.park",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#9e9e9e"
                                }
                            ]
                        },
                        {
                            "featureType": "road",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#ffffff"
                                }
                            ]
                        },
                        {
                            "featureType": "road.arterial",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#757575"
                                }
                            ]
                        },
                        {
                            "featureType": "road.highway",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#dadada"
                                }
                            ]
                        },
                        {
                            "featureType": "road.highway",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#616161"
                                }
                            ]
                        },
                        {
                            "featureType": "road.local",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#9e9e9e"
                                }
                            ]
                        },
                        {
                            "featureType": "transit.line",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#e5e5e5"
                                }
                            ]
                        },
                        {
                            "featureType": "transit.station",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#eeeeee"
                                }
                            ]
                        },
                        {
                            "featureType": "water",
                            "elementType": "geometry",
                            "stylers": [
                                {
                                    "color": "#c9c9c9"
                                }
                            ]
                        },
                        {
                            "featureType": "water",
                            "elementType": "geometry.fill",
                            "stylers": [
                                {
                                    "color": "#a50000"
                                }
                            ]
                        },
                        {
                            "featureType": "water",
                            "elementType": "labels.text.fill",
                            "stylers": [
                                {
                                    "color": "#9e9e9e"
                                }
                            ]
                        }
                    ]
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

