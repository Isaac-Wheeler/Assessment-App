<!DOCTYPE html>
<html>
    <head>
        <!--<script type="text/javascript">
            if (screen.width <= 800) {
                window.location = "/MobileLogin.html";
            }
        </script>-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assesment</title>
            <asset:stylesheet src="fileDisplay.css"/>
    </head>
    <body>
        <!-- right half of the page -->
        <div class="main">
            <div class="info">
                <h1>Edit Assessment</h1>
                <label for="measureTitle">Measure Title:</label>
                <br>
                <g:field type="text" id="measureTitle" name="measureTitle" width="100px" placeholder="Title" class="shortText"/>
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
                </div>
            <!--<g:submitButton class="button" name="submitButton" value="Create Outcome" />
             <g:submitButton class="button" name="cancelButton" value="Cancel" />-->
        </div>
        <div class="sidebar">
            <!-- the slider switch bar at the top's left label-->
            <!-- the slider switch bar at the top-->
            <label class="switch">
                <input type="checkbox" id="reveal-Classes"><span class="slider round"></span></input>
            </label>            <!-- the slider switch bar at the top's right label-->
            <div class="fileFolders">
              <g:each in="${Outcomes}" var="o">
                  <div class="Outcomes">
                      <label for="reveal-indicators" class="btn" style="width: 300px">>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Outcome ${o.outcomeCategory}:</label>
                      <input type="checkbox" id="reveal-indicators" role="button">
                      <!--<g:if test="${o.outcomeIndicators != NULL}">-->
                        <!--<g:each in="${o.outcomeIndicators.toList()}">-->

                          <div id="indicator">
                            <div id="indicators" class="nice" action="" method="post">
                              <label for="reveal-classes" class="btn" style="width: 300px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Indicators .1<!--${Indicators.get(it-1).indicatorName}-->:</label>
                              <input type="checkbox" id="reveal-classes" role="button">
                              <label id="classes" class="nice" action="" method="post">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Class: CS370</label>
                            </div>
                          </div>
                          <!--</g:each>-->
                      <!--</g:if>-->
                    </div>
                </g:each>
                <div id="Classes">
                  Hello World
                </div>
            </div>
        </div>
    </body>
</html>
