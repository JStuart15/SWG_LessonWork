//home.js
$(document).ready(function(){
  $('#toggleNumbers').on('click', function(){
    $('h2').toggle('slow');
  });

  $('#centerUp').on('click', function(){
    $('h1').addClass('text-center');
    $('h2').addClass('text-center');
    $('#buttonDiv').addClass('text-center');
  });

  $('#headingBlue').on('click', function(){
    $('h1').css('color', 'blue');
  });

  $('div').hover(
    //in function
    function(){
      $(this).css('background-color', 'Blue');
    },
    //out function
    function(){
      $(this).css('background-color', '');
    }
  );

  $('h2').hover(
    function(){
        $(this).css('color', 'DarkOrange');
    },
    function(){
      $(this).css('color', '');
    }
  );

  $('#mainHeading').hover(
    function(){
        $(this).css('color', 'Red');
    },
    function(){
      $(this).css('color', 'Pink');
    }
  );

});
