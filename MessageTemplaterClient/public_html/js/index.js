$(document).ready(function () {
    clearMessageCustom();
    clearMessagePreview();
    loadMessageTemplates();
    loadCompanies();
    loadGuests();

    $('#messageSelect').focusout(function () {
        loadMessageCustom();
    });
});

function generateMessagePreview() {
    var companyId = $('#companySelect').val();
    var guestId = $('#guestSelect').val();

    //Determine time of day greeting
    var date = new Date();
    var hour = date.getHours();
    if (hour >= 0 && hour < 12) {
        var greeting = 'Good morning';
    } else if (hour >= 12 && hour < 4) {
        greeting = 'Good afternoon';
    } else if (hour >= 4 && hour <= 23) {
        greeting = 'Good evening';
    }

    //put guest information in message preview
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/guest/' + guestId,
        dataType: 'json',
        crossDomain: 'true',
        success: function (data) {
            var text = $('#messageCustom').val();
            text = text.replace('<time of day greeting>', greeting);
            console.log(greeting);
            text = text.replace('<first name>', data.firstName);
            console.log(data.firstName);
            text = text.replace('<last name>', data.lastName);
            console.log(data.lastName);
            text = text.replace('<room number>', data.reservation.roomNumber);
            console.log(data.reservation.roomNumber);
            var startDate = new Date(data.reservation.startTimestamp * 1000).toDateString();
            console.log(startDate);
            text = text.replace('<booking start date>', startDate);
            var endDate = new Date(data.reservation.endTimestamp * 1000).toDateString();
            console.log(endDate);
            text = text.replace('<booking end date>', endDate);
            $('#messagePreview').html(text);
            populateCompanyData();
        }
    });

    //put Company information in message preview
    function populateCompanyData() {
        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/company/' + companyId,
            dataType: 'json',
            crossDomain: 'true',
            success: function (data) {
                var text = $('#messagePreview').val();
                text = text.replace('<company>', data.company);
                console.log(data.company);
                text = text.replace('<city>', data.city);
                console.log(data.city);
                $('#messagePreview').html(text);
            }
        });
    }
}

function loadMessageCustom() {
    var messageId = $('#messageSelect').val();
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/messagetemplate/' + messageId,
        dataType: 'json',
        crossDomain: 'true',
        success: function (message) {
            var messageText = message.message;
            document.getElementById('messageCustom').value = messageText;
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please ensure REST Service is running."));
        }
    });
}

function loadMessageTemplates() {
    var messageSelect = $('#messageSelect');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/messagetemplates',
        dataType: 'json',
        crossDomain: 'true',
        success: function (messageArray) {
            $.each(messageArray, function (index, message) {
                var messageId = message.id;
                var messageName = message.name;

                var option = '<option value="' + messageId + '">' + messageName + '</option>';
                messageSelect.append(option);
            });
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please try again later."));
        }
    });
}

function loadCompanies() {
    var companySelect = $('#companySelect');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/companies',
        dataType: 'json',
        crossDomain: 'true',
        success: function (companyArray) {
            $.each(companyArray, function (index, company) {
                var companyId = company.id;
                var companyName = company.company;
                var city = company.city;
                var timezone = company.timezone;

                var option = '<option value="' + companyId + '">' + companyName + '</option>';
                companySelect.append(option);
            });
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please try again later."));
        }
    });
}

function loadGuests() {
    var guestSelect = $('#guestSelect');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/guests',
        dataType: 'json',
        crossDomain: 'true',
        success: function (guestArray) {
            $.each(guestArray, function (index, guest) {
                var guestId = guest.id;
                var guestFirstName = guest.firstName;
                var guestLastName = guest.lastName;

                var option = '<option value="' + guestId + '">' + guestFirstName
                        + ' ' + guestLastName + '</option>';
                guestSelect.append(option);
            });
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please try again later."));
        }
    });
}

function clearMessageCustom() {
    $('#messageCustom').empty();
}

function clearMessagePreview() {
    $('#messagePreview').empty();
}

function displayMessageSent() {
    alert("Your message was sent");
}

function appendGreeting() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<time of day greeting>';
}

function appendFirstName() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<first name>';
}

function appendLastName() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<last name>';
}

function appendRoomNumber() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<room number>';
}

function appendStartDate() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<booking start date>';
}

function appendEndDate() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<booking end date>';
}

function appendCompany() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<company>';
}

function appendCity() {
    var text = $('#messageCustom').val();
    document.getElementById('messageCustom').value = text + '<city>';
}