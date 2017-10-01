$(function(){

var hovered1 = false;
var hovered2 = false;
var link1 = "Breitbart";
var link2 = "The Onion";
var hover1 = "fake news";
var hover2 = "just kidding";

$("#hover1").hover(function(){
  if(!hovered1){
    $(this).text(link1).css({fontSize: '18px', color: 'orange'});
    hovered1 = true;
    return;
  }
  $(this).text(hover1).css({fontSize: '38px', color: 'red'});
}, function(){
  $(this).text(link1).css({fontSize: '18px', color: 'orange'});
});

$("#hover2").hover(function(){
  if(!hovered2){
    $(this).text(link2).css({fontSize: '18px', color: 'pink'});
    hovered2 = true;
    return;
  }
  $(this).text(hover2).css({fontSize: '8px', color: ''});
}, function(){
  $(this).text(link2).css({fontSize: '18px', color: 'pink'});
});


});
