var base = 2;
console.log(global);
function addtwo(input){
  return parseInt(input) + base;
}
exports.addtwo = function(input){
  return parseInt(input) + base;
}
