<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Vending Machine</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.css">
    </head>
    <body>
        <div class="container">
            <h1 align="center">Vending Machine</h1>
            <hr>
            <div class="row">
                <div class="col-md-8" id="itemDiv">
                    <div id="errorMessages"></div>
                    <div class="row" id="contentRows">
                        <c:forEach var="currentItem" items="${itemList}">
                            <div class="card col-md-4">
                                <div class="card-body">
                                    <p class="card-text" 
                                       id="productId" 
                                       name="id">
                                        <c:out value="${currentItem.itemId}"/>
                                    </p>
                                    <h4 class="card-title" 
                                        id="name" 
                                        name="name">
                                        <c:out value="${currentItem.itemName}"/>
                                    </h4>
                                    <p class="card-text" 
                                       id="price" 
                                       name="price">
                                        $<c:out value="${currentItem.itemCost}"/>
                                    </p>
                                    <p class="card-text" 
                                       id="quantity" 
                                       name="quantity">Quantity Left: 
                                        <c:out value="${currentItem.quantityAvailable}"/>
                                    </p>
                                    <form action="updateItemSelected" method="POST">
                                        <input type="hidden" name="itemId" 
                                               value="${currentItem.itemId}"/>
                                        <input type="submit" 
                                               class="btn btn-primary" 
                                               value="Select Item"/>
                                    </form>

                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-4" id="adminDiv">
                    <div id='moneyDiv'>
                        <input type="number" 
                               align="center" 
                               hidden 
                               id="totalDeposit">
                        <h4 align='center'>Total $ In</h4>
                        <div class="form-group">
                            <input id="total-money-in" 
                                   class="form-control form-control-lg col-md-auto text-center" 
                                   type="text" 
                                   disabled 
                                   required
                                   value = "${totalIn}">
                        </div>
                        <form action="addMoney" method="POST" role="form">
                            <div class="form-group">
                                <div class="btn-group d-flex justify-content-center">
                                    <button id="add-dollar-button" 
                                            type="submit" 
                                            class="btn btn-outline-primary"
                                            value="1.00"
                                            name="denom">
                                        Add Dollar</button>
                                    <button id="add-quarter-button" 
                                            type="submit" 
                                            class="btn btn-outline-primary"
                                            value="0.25"
                                            name="denom">
                                        Add Quarter</button>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="btn-group d-flex justify-content-center">
                                    <button id="add-dime-button" 
                                            type="submit" 
                                            class="btn btn-outline-primary"
                                            value="0.10"
                                            name="denom">
                                        Add Dime</button>
                                    <button id="add-nickel-button" 
                                            type="submit" 
                                            class="btn btn-outline-primary" 
                                            value="0.05"
                                            name="denom">
                                        Add Nickel</button>
                                </div>
                            </div>
                        </form>

                    </div>
                    <div id="messageDiv">
                        <hr>
                        <h4 align="center">Messages</h4>
                        <div class="form-group">
                            <input id="messages" 
                                   class="form-control form-control-lg col-md-auto text-center" 
                                   type="text" 
                                   disabled
                                   value="${message}">
                        </div>
                        <div class="form-group" id="makePurchaseForm">
                            <div class="form-inline">
                                <label for="item-selected" 
                                       class="form-control-label col-md-3">
                                    Item:</label>
                                <input type="text" 
                                       class="form-control col-md-9" 
                                       id="item-selected"
                                       disabled
                                       value ="${itemSelected}"
                                       />
                            </div>
                        </div>
                        <form action="makePurchase" method="GET" role="form">
                            <div class="form-group">
                                <button type="submit" class="btn btn-outline-primary btn-block"
                                        id="make-purchase-button">Make Purchase</button>
                            </div>
                        </form>
                    </div>
                    <div id="changeDiv">
                        <hr>
                        <h4 align="center">Change</h4>
                        <div class="form-group">
                            <input id="change-output" 
                                   class="form-control form-control-lg col-md-auto text-center" 
                                   type="text" 
                                   disabled
                                   value="${changeMessage}">
                        </div>
                        <form action="returnChange" method="GET" role="form">
                            <div class="form-group">
                                <button type="submit" 
                                        class="btn btn-outline-primary btn-block"
                                        id="return-change-button"
                                        >Change Return</button> 
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="js/jquery-3.2.1.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" crossorigin="anonymous"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/home.js"></script>
    </body>
</html>

