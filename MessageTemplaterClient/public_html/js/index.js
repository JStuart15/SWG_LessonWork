$(document).ready(function () {
    clearMessageCustom();
    clearMessagePreview();
    loadMessageTemplates();
    loadCompanies();
    //loadGuests();
    $('#messageSelect').focusout(function () {
        loadMessageCustom();
    });
    $('#companySelect').focusout(function () {
        updateMessageCustomForCompany();
    });
});

function clearMessageCustom() {
    $('#messageCustom').empty();
}

function clearMessagePreview() {
    $('#messagePreview').empty();
}

function loadMessageCustom() {
    var messageId = $('#messageSelect').val();
    $('#messageCustom').append(messageId);
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/messagetemplates/' + messageId,
        dataType: 'json',
        success: function (message) {
            var messageText = message.message;
            $('#messageCustom').html(messageText);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please ensure it is running."));
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

function loadTemplate() {
    $('#companySelect').prop('disabled', 'disabled');
}