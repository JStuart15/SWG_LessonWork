$(document).ready(function () {
   $('h1').css('text-align', 'center');
   $('h2').css('text-align', 'center');
   $('.myBannerHeading').addClass('page-header');
   $('.myBannerHeading').removeClass('myBannerHeading');
   
   $('#yellowHeading').text('Yellow Team');
   
   $('#redTeamList').css('background-color', 'red');
   $('#orangeTeamList').css('background-color', 'orange');
   $('#blueTeamList').css('background-color', 'blue');
   $('#yellowTeamList').css('background-color', 'yellow');
   
   $('#yellowTeamList').append('<li>Joseph Banks</li>');
   $('#yellowTeamList').append('<li>Simon Jones</li>');
   
   $('#oops').hide();
   $('#footerPlaceholder').remove();
   
   $('#footer').append('<p>Jeff Stuart, stuart@gmail.com</p>')
           .css('font-family', 'courier')
           .css('font-size', '24px');
   
});