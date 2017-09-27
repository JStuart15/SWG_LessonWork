$(document).ready(function () {
    $('#akronInfoDiv').hide();
    $('#minneapolisInfoDiv').hide();
    $('#louisvilleInfoDiv').hide();

    //table row highlighting but not the first row
    $('tr:not(:first-child)').hover(
            function () {
                $(this).css('background-color', 'WhiteSmoke');
            },
            function () {
                $(this).css('background-color', 'white');
            });

    $('#akronWeatherButton')
    //click button actions
    $('#mainButton').click(function () {
        $('#mainInfoDiv').show();
        $('#minneapolisInfoDiv').hide();
        $('#akronInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });

    $('#akronButton').click(function () {
        $('#mainInfoDiv').hide();
        $('#akronInfoDiv').show();
        $('#akronWeather').hide();
        $('#akronWeatherButton').text('Show Weather');

        $('#minneapolisInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });

    $('#minneapolisButton').click(function () {
        $('#mainInfoDiv').hide();
        $('#minneapolisInfoDiv').show();
        $('#minneapolisWeather').hide();
        $('#minneapolisWeatherButton').text('Show Weather');
        $('#akronInfoDiv').hide();
        $('#louisvilleInfoDiv').hide();
    });

    $('#louisvilleButton').click(function () {
        $('#mainInfoDiv').hide();
        $('#louisvilleInfoDiv').show();
        $('#louisvilleWeather').hide();
        $('#akronInfoDiv').hide();
        $('#louisvilleWeatherButton').text('Show Weather');
        $('#minneapolisInfoDiv').hide();
    });

    //Click to show/hide weather
    $('#akronWeatherButton').click(function () {
        $('#akronWeather').toggle();
        $(this).text(function (i, text) {
            return text === "Show Weather" ? "Hide Weather" : "Show Weather";
        });
    });

    $()
    $('#minneapolisWeatherButton').click(function () {
        $('#minneapolisWeather').toggle();
        $(this).text(function (i, text) {
            return text === "Show Weather" ? "Hide Weather" : "Show Weather";
        });
    });

    $('#louisvilleWeatherButton').click(function () {
        $('#louisvilleWeather').toggle();
        $(this).text(function (i, text) {
            return text === "Show Weather" ? "Hide Weather" : "Show Weather";
        });
    });
});