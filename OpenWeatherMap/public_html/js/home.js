//home.js
$(document).ready(function(){
    $('h1').css('text-align', 'center');

    $('#get-weather').on('click', function(){
        //add code to validate the zip code is not letters
        $.ajax({
            type: 'GET',
            url: 'http://api.openweathermap.org/data/2.5/weather?zip='
                    + $('#add-zipcode').val() +',us'
                    + '&units=' + $('#units').val()
                    +'&APIKEY=ae75b3216c181af2985a3ffa62b437a7',
            success: function(currentWeatherArray){
                $('#currentCondHeading').append(currentWeatherArray['name']);
                $('#current-temp').append(currentWeatherArray['main']['temp']);
                var temp_units;
                if($('#units').val() === 'imperial' ){
                    temp_units = "F";
                } else {
                    temp_units = "C";
                }
                $('#current-temp').append(temp_units);

                $('#current-humidity').append(currentWeatherArray['main']['humidity']);
                
                $('#current-wind').append(currentWeatherArray['wind']['speed']);
                
                console.log(currentWeatherArray['weather']['icon']);
                var currentIcon = currentWeatherArray['weather'][0]['icon'];
                $('#weather-icon').append('<img src="http://openweathermap.org/img/w/'
                        + currentIcon + '.png"/>');
                
            },
            error:function(){
                alert('Failed to get weather for zipcode ' + zip);
            }
        });
    });
});
