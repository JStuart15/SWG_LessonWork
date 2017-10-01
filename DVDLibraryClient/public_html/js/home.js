$(document).ready(function () {
//    $('#searchFormDiv').hide();
//    $('#errorMessages').hide();
//    $('#dvdTableDiv').hide();
    $('#addFormDiv').hide();
    $('#editFormDiv').hide();
    
    loadDvds();
    
     $(document).on('click','div.card',function(){
        alert("you clicked " + $(this).attr("class") );
    });
    
    $('#search-dvd-button').click(function (event) {
        $('#errorMessages').empty();
        var contentRows = $('#contentRows');

        var hasValidationErrors = checkAndDisplayValidationErrors($('#search-form').find('input, select'));
        if (hasValidationErrors) {
            $('#errorMessages').show();
            return false;
        }

        $.ajax({
            type: 'GET',
            url: 'http://localhost:8080/dvds/'
                    + $('#select-category').val()
                    + '/' + $('#search-input').val(),
            success: function (dvdArray) {
                clearDvdTable();
                $.each(dvdArray, function (index, dvd) {
                    var title = dvd.title;
                    var releaseYear = dvd.releaseYear;
                    var director = dvd.director;
                    var rating = dvd.rating;
                    var dvdId = dvd.dvdId;


                    var row = '<tr>';
                    row += '<td>' + title + '</td>';
                    row += '<td>' + releaseYear + '</td>';
                    row += '<td>' + director + '</td>';
                    row += '<td>' + rating + '</td>';
                    row += '<td><a onclick="showEditForm('
                            + dvdId + ')">Edit</a> | <a onclick="deleteContact('
                            + dvdId + ')">Delete</a></td>';
                    row += '</tr>';

                    contentRows.append(row);
                    $('#select-category').val('');
                    $('#search-input').val('');
                });
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text("Error calling web service...please try again later."));
            }
        });
    });

    $('#add-button').click(function (event) {
        var hasValidationErrors = checkAndDisplayValidationErrors($('#add-form').find('select, input'));

        if (hasValidationErrors) {
            return false;
        }

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/dvd',
            data: JSON.stringify({
                title: $('#add-dvd-title').val(),
                releaseYear: $('#add-release-year').val(),
                director: $('#add-director').val(),
                rating: $('#add-rating').val(),
                notes: $('#add-notes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function () {
                $('#errorMessages').empty();
                $('#add-dvd-title').val('');
                $('#add-release-year').val('');
                $('#add-director').val('');
                $('#add-rating').val('');
                $('#add-notes').val('');
                hideAddForm();
                loadDvds();
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text("Error calling web service...please try again later."));
            }
        });
    });

    $('#edit-button').click(function (event) {
        var hasValidationErrors = checkAndDisplayValidationErrors($('#edit-form').find('input, select'));
        if (hasValidationErrors) {
            return false;
        }

        $.ajax({
            type: 'PUT',
            url: 'http://localhost:8080/dvd/' + $('#edit-dvd-id').val(),
            data: JSON.stringify({
                dvdId: $('#edit-dvd-id').val(),
                title: $('#edit-dvd-title').val(),
                releaseYear: $('#edit-release-year').val(),
                director: $('#edit-director').val(),
                rating: $('#edit-rating').val(),
                notes: $('#edit-notes').val()
            }),
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            'dataType': 'json',
            success: function () {
                $('#errorMessages').empty();
                hideEditForm();
                loadDvds();
            },
            error: function () {
                $('#errorMessages')
                        .append($('<li>')
                                .attr({class: 'list-group-item list-group-item-danger'})
                                .text("Error calling web service...please try again later."));
            }

        });
    });
});

function loadDvds() {
    clearDvdTable();
    var contentRows = $('#contentRows');

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvds',
        success: function (dvdArray) {
            $.each(dvdArray, function (index, dvd) {
                var title = dvd.title;
                var releaseYear = dvd.releaseYear;
                var director = dvd.director;
                var rating = dvd.rating;
                var dvdId = dvd.dvdId;


                var row = '<tr>';
                row += '<td>' + title + '</td>';
                row += '<td>' + releaseYear + '</td>';
                row += '<td>' + director + '</td>';
                row += '<td>' + rating + '</td>';
                row += '<td><a onclick="showEditForm('
                        + dvdId + ')">Edit</a> | <a onclick="deleteContact('
                        + dvdId + ')">Delete</a></td>';
                row += '</tr>';

                contentRows.append(row);
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

function clearDvdTable() {
    $('#contentRows').empty();
}

function showAddForm() {
    $('#searchFormDiv').hide();
    //$('#errorMessages').hide();
    $('#dvdTableDiv').hide();
    $('#editFormDiv').hide();
    $('#addFormDiv').show();
}
function showEditForm(dvdId) {
    $('#errorMessages').empty();
    $('#searchFormDiv').hide();
    $('#dvdTableDiv').hide();

    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/dvd/' + dvdId,
        success: function (data, status) {
            $('#editDVDTitle').append(data.title);
            $('#edit-dvd-title').val(data.title);
            $('#edit-release-year').val(data.releaseYear);
            $('#edit-director').val(data.director);
            $('#edit-rating').val(data.rating);
            $('#edit-notes').val(data.notes);
            $('#edit-dvd-id').val(data.dvdId);
        },
        error: function () {
            $('#errorMessages')
                    .append($('<li>')
                            .attr({class: 'list-group-item list-group-item-danger'})
                            .text("Error calling web service...please try again later."));
        }
    });

    $('#editFormDiv').show();
}

function hideEditForm() {
    $('#errorMessages').empty();

    //remove values from the edit form
    $('#edit-dvd-title').val('');
    $('#edit-release-year').val('');
    $('#edit-director').val('');
    $('#edit-rating').val('');
    $('#edit-notes').val('');

    $('#editFormDiv').hide();
    $('#searchFormDiv').show();
    $('#errorMessages').show();
    $('#dvdTableDiv').show();
}

function hideAddForm() {
    $('#errorMessages').empty();

    //remove values from the add form
    $('#edit-dvd-title').val('');
    $('#edit-release-year').val('');
    $('#edit-director').val('');
    $('#edit-rating').val('');
    $('#edit-notes').val('');

    $('#addFormDiv').hide();
    $('#searchFormDiv').show();
    $('#errorMessages').show();
    $('#dvdTableDiv').show();
}

function deleteContact(dvdId) {
    var response = confirm("Are you sure you want to delete this DVD from your collection?");
    if (response === true) {
        $.ajax({
            type: 'DELETE',
            url: 'http://localhost:8080/dvd/' + dvdId,
            success: function () {
                loadDvds();
            }
        });
    } else {
        loadDvds();
    }
}

function checkAndDisplayValidationErrors(input) {
    $('#errorMessages').empty();

    var errorMessages = [];

    input.each(function () {
        //console.log(this);
        if (!this.validity.valid) {
            //console.log(this.id);
            //console.log(this);

            errorMessages.push(this.validationMessage);
            console.log(this.id);

            console.log(this.validationMessage);
            if (this.id === 'add-release-year' || this.id === 'edit-release-year') {
                $('#errorMessages').append('<li class="list-group-item list-group-item-danger">Please enter a 4-digit year</li>');
            }
            if (this.id === 'add-dvd-title' || this.id === 'edit-dvd-title') {
                $('#errorMessages').append('<li class="list-group-item list-group-item-danger">Please enter title for the DVD</li>');
            }
            if (this.id === 'search-input') {
                $('#errorMessages').append('<li class="list-group-item list-group-item-danger">Both Search Category and Search Term are required.</li>');
            }
            if (this.id === 'select-category') {
                console.log('im in the search category if statement')
                $('#errorMessages').append('<li class="list-group-item list-group-item-danger">Both Search Category and Search Term are required.</li>');
            }
        }
    });
    if (errorMessages.length > 0) {
        return true;

    } else {
        return false;
    }
}