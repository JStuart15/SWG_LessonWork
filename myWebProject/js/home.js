//home.js
$(document).ready(function() {
    //access an ID element
    //$('#second').hide();
    
    //access a class element
    //$('.notOriginal').hide();

    //access a tag element
    //$('H1').hide();
    
    //remove an item
    $('#third').remove();
    
    //create a new HTML element
    $('#emptyDiv').append('p').text('A new paragraph of text...');
    
    //remove class from an element
    //$('#first').removeClass('text-center');
    
    //add a class to an element
    $('#newButton').addClass('btn btn-default');
    
    //add a style to the page
    $('#first').css('color', 'blue');
    
});
