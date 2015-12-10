var selectedTestCase,
    selectedImplementationType;

$(document).ready(function(){
  $(".core-interfaces-dropdown li a").click(function() {
    var coreInterface = $(this).text();
    $(".core-interfaces-button").html(coreInterface + '<span class="caret"></span>');
    $(".implementations").addClass("hidden");
    $("[data-core-interface='" + coreInterface + "']").removeClass("hidden");
    $(".implementations-button").prop("disabled", false);
  });
  $(".implementations-dropdown li a").click(function() {
    var implementation = $(this).text();
    $(".implementations-button").html(implementation + '<span class="caret"></span>');
    $(".test-cases-button").prop("disabled", false);
    $(".test-cases").addClass("hidden");
    $("[data-implementation='" + implementation + "']").removeClass("hidden");
  });
  $(".test-cases-dropdown li a").click(function() {
    selectedTestCase = $(this).parent().data("testCaseId");
    selectedImplementationType = $(this).parent().data("implementation");
    $(".test-cases-button").html($(this).text() + '<span class="caret"></span>');
    $("#run-test").prop("disabled", false);
  });
  $("#run-test").click(function() {
     var numberOfRuns = $("#numberOfRuns").val();
     $("#numberOfRuns").parent().removeClass("has-error");
     if (!isNaN(parseInt(numberOfRuns))) {
         $.ajax({
                url : "startTest",
                data : {
                    implementationType : selectedImplementationType,
                    id : selectedTestCase,
                    numberOfRuns : numberOfRuns
                },
                success: function (response) {
                        console.log(response);
                }
            });
     } else {
         $("#numberOfRuns").parent().addClass("has-error");
     }
  });
});
