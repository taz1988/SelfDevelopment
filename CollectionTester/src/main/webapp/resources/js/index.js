$(document).ready(function(){
  $(".core-interfaces-dropdown li a").click(function(){
    var coreInterface = $(this).text();
    $(".core-interfaces-button").html(coreInterface + '<span class="caret"></span>');
    $(".implementations").addClass("hidden");
    $("[data-core-interface='" + coreInterface + "']").removeClass("hidden");
    $(".implementations-button").prop("disabled", false);
  });
  $(".implementations-dropdown li a").click(function(){
    var implementation = $(this).text();
    $(".implementations-button").html(implementation + '<span class="caret"></span>');
    $(".test-cases-button").prop("disabled", false);
    $(".test-cases").addClass("hidden");
    $("[data-implementation='" + implementation + "']").removeClass("hidden");
  });
  $(".test-cases-dropdown li a").click(function(){
    $(".implementations-button").html(implementation + '<span class="caret"></span>');
    $("#run-test").prop("disabled", false);
  });
});
