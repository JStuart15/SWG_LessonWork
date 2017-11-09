<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="/WEB-INF/jspf/commonHeadLinks.jspf" %>
        <link href="${pageContext.request.contextPath}/css/custom.map.css" rel="stylesheet"> 
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
                <%@include file="/WEB-INF/jspf/topNavBar.jspf" %>

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
        <script src="${pageContext.request.contextPath}/js/setHomeNavActive.js"></script>
        <script src="${pageContext.request.contextPath}/js/googleMap.js"></script>
        <script async defer
                src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAU601CAmYmF97gSGTDNCEU6tBgeppKVX8&callback=initMap">
        </script> 
    </body>
</html>

