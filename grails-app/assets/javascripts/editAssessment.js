function clearForm(){
  console.log('Clear in');
  document.getElementById('assessmentDocTitle').value = '';
  document.getElementById('Desc').value = '';
  document.getElementById('targetGoal').value = 0;
  document.getElementById('belowExpectation').value = 0;
  document.getElementById('meetsExpectation').value = 0;
  document.getElementById('exceedsExpectation').value = 0;
  document.getElementById('comment').value = '';
  document.getElementById('observation').value = '';
  document.getElementById('completed').value = false;
  document.getElementById('requiredAction').value = '';
}
function updateForm(){
  var valueBelow = parseInt(document.getElementById('belowExpectation').value, 10);
  var valueMeets = parseInt(document.getElementById('meetsExpectation').value, 10);
  var valueExceeds = parseInt(document.getElementById('exceedsExpectation').value, 10);
  var together = valueBelow + valueMeets + valueExceeds;

  document.getElementById("BE").innerHTML = Math.round((valueBelow/together)*100) + "%";
  document.getElementById("ME").innerHTML = Math.round((valueMeets/together)*100) + "%";
  document.getElementById("EE").innerHTML = Math.round((valueExceeds/together)*100) + "%";
}

function hideShowOutcomesClasses() {
  var x = document.getElementById("Outcomes");
  if (x.style.display == "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
  var y = document.getElementById("Classes");
  if (x.style.display == "none") {
    y.style.display = "block";

  } else {
    y.style.display = "none";
  }
}
function addBelowExpectation() {
    var value = parseInt(document.getElementById('belowExpectation').value, 10);
    value++;
    document.getElementById("belowExpectation").value = value;
    updateForm();
}
function minusBelowExpectation() {
    var value = parseInt(document.getElementById('belowExpectation').value, 10);
    value--;
    document.getElementById("belowExpectation").value = value;
    updateForm();
}
function addMeetsExpectation() {
    var value = parseInt(document.getElementById('meetsExpectation').value, 10);
    value++;
    document.getElementById("meetsExpectation").value = value;
    updateForm();
}
function minusMeetsExpectation() {
    var value = parseInt(document.getElementById('meetsExpectation').value, 10);
    value--;
    document.getElementById("meetsExpectation").value = value;
    updateForm();
}
function addExceedsExpectation() {
    var value = parseInt(document.getElementById('exceedsExpectation').value, 10);
    value++;
    document.getElementById("exceedsExpectation").value = value;
    updateForm();
}
function minusExceedsExpectation() {
    var value = parseInt(document.getElementById('exceedsExpectation').value, 10);
    value--;
    document.getElementById("exceedsExpectation").value = value;
    updateForm();
}
function revealAction() {
  document.getElementById("requiredAction").style.display = "block";
  document.getElementById("actionLabel").style.display = "block";
  document.getElementById("action").style.display = "none";
}
function revealInfo(){
  document.getElementById("info").style.visibility = "visible";
}
