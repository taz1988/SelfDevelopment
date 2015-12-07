$(document).ready(function(){
  $(".core-interfaces-dropdown li a").click(function(){
    var coreInterface = $(this).text();
    $(".core-interfaces-button").html(coreInterface + '<span class="caret"></span>');
    $(".implementations").addClass("hidden");
    $("[data-core-interface='" + coreInterface + "']").removeClass("hidden");
    $(".implementations-button").prop("disabled", false);
  });
  $(".implementations-dropdown li a").click(function(){
    var coreInterface = $(this).text();
    $(".implementations-button").html(coreInterface + '<span class="caret"></span>');
    $("#run-test").prop("disabled", false);
  });
});
