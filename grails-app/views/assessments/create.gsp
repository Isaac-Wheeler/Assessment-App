<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
	<div class="pageTitle">
    		<h1>Create Assessment</h1>
      	<p>Complete the form below to create an Assessment</p>
    </div>
    <g:form class="simpleform" url="create">
   			 <g:hasErrors bean="${teacher}">
      			<div class="errors">
        				<g:renderErrors bean="${teacher}"/>
      			</div>
    			</g:hasErrors>
    		<div class="backgrounds">
            <div class="labels">
              <label for="Title">Measure Title:</label>
              <br>
              <g:field type="text" id="outcomeTitle" name="outcomeTitle" width="100px" placeholder="Title" class="shortText"/>
              <br>
              <label for="selectOutcomes">Select Outcome:</label>
              <select id="selectOutcomes">
                  <option value="A">A</option>
                  <option value="B">B</option>
                  <option value="C">C</option>
                  <option value="D">D</option>
              </select>
              <label for="selectIndicator">Select Indicator:</label>
              <select id="selectIndicator" >
                  <option value=".1">.1</option>
                  <option value=".2">.4</option>
                  <option value=".3">.3</option>
                  <option value=".4">.4</option>
              </select>
              <label for="selectClass">Select Class:</label>
              <select id="selectClass" >
                  <option value="CS 370">CS 370</option>
                  <option value="CS 420">CS 420</option>
                  <option value="CS 230">CS 230</option>
                  <option value="ECE 260">ECE 260</option>
              </select>
              <br>
              <label for="Desc">Description:</label>
              <br>
              <textArea id="Desc" name="Desc" rows="10" cols="100" resize="none"></textarea>
              <br>
              <label for="Desc">Work Used:</label>
              <br>
              <input type="file" name="workUsed" id="workUsed">
              <br>
              <label for="targetGoal">Target Goal:</label>
              <label for="belowExpectation" class="labelEx">Below Expectation:</label>
              <label for="meetsExpectation" class="labelEx">Meets Expectation:</label>
              <label for="exceedsExpectation" class="labelEx">Exceeds Expectation:</label>
              <br>
              <g:field type="text" id="targetGoal" name="targetGoal" placeholder="____" class="targetGoal"/>
              <input type="button" value="-" onclick="minusBelowExpectation()" class="minus"/>
              <g:field type="text" id="belowExpectation" name="belowExpectation" value="0" class="oneChar"/>
              <input type="button" onclick="addBelowExpectation()" value="+" />
              <input type="button" value="-" onclick="minusMeetsExpectation()" class="minus">
              <g:field type="text" id="meetsExpectation" name="meetsExpectation" value="0" class="oneChar"/>
              <input type="button"  onclick="addMeetsExpectation()" value="+">
              <input type=button value="-" onclick="minusExceedsExpectation()" class="minus">
              <g:field type="text" id="exceedsExpectation" name="exceedsExpectation" value="0" class="oneChar"/>
              <input type="button" onclick="addExceedsExpectation()" value="+">
              <br>
              <script>
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
              </script>
              <label for="comment">Comment:</label>
              <br>
              <textArea id="comment" name="comment" rows="10" cols="100" resize="none"></textarea>
              <br>
              <label for="observations">Observations:</label>
              <br>
              <textArea id="observation" name="observation" rows="10" cols="100" resize="none"></textarea>
              <br>

              <g:submitButton class="button" name="submitButton" value="Create" />
              <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
