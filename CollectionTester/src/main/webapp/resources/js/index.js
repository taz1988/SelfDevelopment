$(document).ready(function(){
  $(".core-interfaces-dropdown li a").click(function(){
    var coreInterface = $(this).text();
    $(".core-interfaces-button").html(coreInterface + '<span class="caret"></span>');
  });
});