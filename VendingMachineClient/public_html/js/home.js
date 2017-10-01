$(document).ready(function () {
    loadItems();

    $('#contentRows').delegate('.card', "click", function (e) {
        var id = $(this).find('#productId');
        $('#item-selected').val(id[0]['innerText']);
        //var price = $(this).find('#price');
        //$('#item-selected-price').val(price[0]['innerText']);
        clearMessages();
        clearChange();
        e.preventDefault();
    });
});

function addDollar() {
    var totalDeposit = Number($('#totalDeposit').val());
    showChangeReturnButton();
    clearMessages();
    clearChange();
    totalDeposit += Number(1.00);
    $('#total-money-in').val(totalDeposit.toFixed(2));
    $('#totalDeposit').val(totalDeposit.toFixed(2));
}

function addQuarter() {
    var totalDeposit = Number($('#totalDeposit').val());
    showChangeReturnButton();
    clearMessages();
    clearChange();
    totalDeposit += Number(0.25);
    $('#total-money-in').val(totalDeposit.toFixed(2));
    $('#totalDeposit').val(totalDeposit.toFixed(2));
}

function addDime() {
    var totalDeposit = Number($('#totalDeposit').val());
    showChangeReturnButton();
    clearMessages();
    clearChange();
    totalDeposit += Number(0.10);
    $('#total-money-in').val(totalDeposit.toFixed(2));
    $('#totalDeposit').val(totalDeposit.toFixed(2));
}

function addNickel() {
    var totalDeposit = Number($('#totalDeposit').val());
    showChangeReturnButton();
    clearMessages();
    clearChange();
    totalDeposit += Number(0.05);
    $('#total-money-in').val(totalDeposit.toFixed(2));
    $('#totalDeposit').val(totalDeposit.toFixed(2));
}

function loadItems() {
    clearItems();
    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/items',
        success: function (itemArray) {
            $.each(itemArray, function (index, item) {
                var id = item.id;
                var name = item.name;
                var price = Number(item.price).toFixed(2);
                var quantity = item.quantity;

                var card = '<div class="card col-md-4">'
                card += '<img class="card-img-top alt="Card image cap" src="images/'+ name + '.jpg">';
                card += '<div class="card-body">';
                card += '   <p class="card-text" id="productId" name="id">' + id + '</p>';
                card += '   <h4 class="card-title" id="name" name="name">' + name + '</h4>';
                card += '   <p class="card-text" id="price" name="price">$' + price + '</p>';
                card += '   <p class="card-text" id="quantity" name="quantity"> Quantity Left: ' + quantity + '</p>';
                card += '</div>';
                card += '</div>';

                contentRows.append(card);
            });
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please try again later."));
            $('#messages').val('Maintenance Required');
        }
    });
}

function makePurchase() {
    moneyIn = Number($('#totalDeposit').val());
    item = $('#item-selected').val();
    price = $('#item-selected-price').val();
    const maybePluralize = (count, noun, suffix = 's') =>
            `${count} ${noun}${count !== 1 ? suffix : ''}`;
//    if(!item.validity.valid){
//        $('#messages').val('Please select an item');
//    }

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/money/' + moneyIn + '/item/' + item,
        success: function (s) {
            clearMessages();
            var changeMessage = '';
            var numQuarters = s['quarters'];
            var numDimes = s['dimes'];
            var numNickels = s['nickels'];

            if (numQuarters !== 'undefined' && numQuarters > 0) {
                changeMessage += ' ' + maybePluralize(numQuarters, 'Quarter');
            }
            if (numDimes !== 'undefined' && numDimes > 0) {
                changeMessage += ' ' + maybePluralize(numDimes, 'Dime');
            }
            if (numNickels !== 'undefined' && numNickels > 0) {
                changeMessage += ' ' + maybePluralize(numNickels, 'Nickel');
            }

            $('#total-money-in').val('');
            $('#totalDeposit').val(0);
            $('#change-output').val(changeMessage);
            $('#item-selected').val('');
            $('#messages').val('Thank You!!!');
            $('#return-change-button').hide();
            loadItems();
        },
        error: function (e) {
            var errorText = $.parseJSON(e.responseText);
            if (errorText['message'] === 'No message available') {
                $('#messages').val('Please Select an Item');
            } else {
                $('#messages').val(errorText['message']);
            }
        }

    });
}

function clearItems() {
    $('#contentRows').empty();
}

function clearMessages() {
    $('#messages').val('');
}

function changeBack() {
    var change = Number($('#totalDeposit').val());
    var quarters = 0;
    var dimes = 0;
    var nickels = 0;
    var pennies = 0;
    var changeMessage = '';

    const maybePluralize = (count, noun, suffix = 's') =>
            `${count} ${noun}${count !== 1 ? suffix : ''}`;

    if (change.toFixed(2) >= 0.25) {
        num = Math.floor((change.toFixed(2) / 0.25));
        quarters += num;
        change -= num * 0.25;
        changeMessage += maybePluralize(quarters, 'Quarter');
    }
    if (change.toFixed(2) >= 0.10) {
        num = Math.floor((change.toFixed(2) / 0.10));
        dimes += num;
        change -= num * 0.10;
        changeMessage += ' ' + maybePluralize(dimes, "Dime");
    }
    if (change.toFixed(2) >= 0.05) {
        num = Math.floor((change.toFixed(2) / 0.05));
        nickels += num;
        change -= num * 0.05;
        changeMessage += ' ' + maybePluralize(nickels, "Nickel");
    }
    if (change.toFixed(2) >= 0.01) {
        num = Math.floor((change.toFixed(2) / 0.05));
        pennies += num;
        change -= num * 0.01;
        changeMessage += ' ' + maybePluralize(pennies, "Penny");
    }
    console.log(changeMessage);
    $('#total-money-in').val('');
    $('#totalDeposit').val(0);
    clearMessages();
    $('#item-selected').val('');
    $('#change-output').val(changeMessage);
    loadItems();
}

function clearChange() {
    $('#change-output').val('');
}

function showChangeReturnButton() {
    $('#return-change-button').show();
}