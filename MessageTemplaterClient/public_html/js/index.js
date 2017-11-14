$(document).ready(function () {
    clearMessageCustom();
    clearMessagePreview();
    loadMessageTemplates();
    loadCompanies();
    loadGuests();

    $('#messageSelect').focusout(function () {
        loadMessageCustom();
    });
    /*$('#companySelect').focusout(function () {
     updateMessagePreviewForCompany();
     });
     $('#guestSelect').focusout(function () {
     updateMessagePreviewForGuest();
     });*/
});

function generateMessage() {
    var companyId = $('#companySelect').val();
    var guestId = $('#guestSelect').val();

    //put guest information in message preview
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/guest/' + guestId,
        dataType: 'json',
        success: function (data) {
            var text = $('#messageCustom').val();
            text = text.replace('<First Name>', data.firstName);
            console.log(data.firstName);
            text = text.replace('<Last Name>', data.lastName);
            console.log(data.lastName);
            text = text.replace('<Room Number>', data.reservation.roomNumber);
            console.log(data.reservation.roomNumber);
            var startDate = new Date(data.reservation.startTimestamp * 1000).toDateString();
            console.log(startDate);
            text = text.replace('<Booking Start Date>', startDate);
            var endDate = new Date(data.reservation.endTimestamp * 1000).toDateString();
            console.log(endDate);
            text = text.replace('<Booking End Date>', endDate);
            $('#messagePreview').html(text);
        }
    });

    //put Company information in message preview
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/company/' + companyId,
        dataType: 'json',
        success: function (data) {
            var text = $('#messagePreview').val();
            text = text.replace('<Company>', data.company);
            text = text.replace('<City>', data.city);
            $('#messagePreview').html(text);
        }
    });
}

function loadMessageCustom() {
    var messageId = $('#messageSelect').val();
    $('#messageCustom').append(messageId);
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/messagetemplate/' + messageId,
        dataType: 'json',
        success: function (message) {
            var messageText = message.message;
            $('#messageCustom').html(messageText);
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

/*function loadTemplate() {
 $('#companySelect').prop('disabled', 'disabled');
 }*/

function displayMessageSent() {
    alert("Your message was sent");
    clearMessageCustom();
    clearMessagePreview();
}