function hideShowOutcomesClasses(); {
  var x = document.getElementById("Outcomes");
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
  var y = document.getElementById("Classes");
  if (y.style.display === "none") {
    y.style.display = "none";

  } else {
    y.style.display = "block";
  }
}
function addBelowExpectation() {
    var value = parseInt(document.getElementById('belowExpectation').value, 10);
    value++;
    document.getElementById("belowExpectation").value = value;
}
function minusBelowExpectation() {
    var value = parseInt(document.getElementById('belowExpectation').value, 10);
    value--;
    document.getElementById("belowExpectation").value = value;
}
function addMeetsExpectation() {
    var value = parseInt(document.getElementById('meetsExpectation').value, 10);
    value++;
    document.getElementById("meetsExpectation").value = value;
}
function minusMeetsExpectation() {
    var value = parseInt(document.getElementById('meetsExpectation').value, 10);
    value--;
    document.getElementById("meetsExpectation").value = value;
}
    function addExceedsExpectation() {
    var value = parseInt(document.getElementById('exceedsExpectation').value, 10);
    value++;
    document.getElementById("exceedsExpectation").value = value;
}
    function minusExceedsExpectation() {
    var value = parseInt(document.getElementById('exceedsExpectation').value, 10);
    value--;
    document.getElementById("exceedsExpectation").value = value;
}
