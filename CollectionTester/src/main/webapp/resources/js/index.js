var selectedTestCase,
    selectedImplementationType;

function getStateOfRunningTestCase() {
    $.ajax({
           url : "getStatusOfRunningTest",
           success: function (response) {
               processResponseCameFromTestCaseRunning(response);
           }
       });
}

function processResponseCameFromTestCaseRunning(response) {
    if (response.state === "RUNNING") {
        setTimeout(getStateOfRunningTestCase, 1000);
    } else {
        $("#run-test").prop("disabled", false);
        $(".progress-bar").css("width", "0%");
        if (response.testResult) {
            $("#testCasesInTable").append("<tr><td>" + response.testResult.name + "</td><td>"
             + response.testResult.numberOfRuns + "</td><td>" + response.testResult.average + "</td><td>"
             + response.testResult.deviation + "</td><td>" + response.testResult.min + "</td><td>"
              + response.testResult.max + "</td></tr>");
        }
    }
}

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
     $("#run-test").prop("disabled", true);
     $(".progress-bar").css("width", "100%");
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
                    processResponseCameFromTestCaseRunning(response);
                }
            });
     } else {
         $("#numberOfRuns").parent().addClass("has-error");
     }
  });
});
