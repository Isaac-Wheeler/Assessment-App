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
            <asset:javascript src="editAssessment.js"/>
    </head>
    <body>
        <!-- right half of the page -->
        <div class="main">
            <div class="info">
                <h1>Assessment Documentation</h1>
                <label for="assessmentDocTitle">Assessment Documentation Title:</label>
                <br>
                <g:field type="text" id="assessmentDocTitle" name="assessmentDocTitle" style="width:35%;" placeholder="Title" class="shortText"/>
                    <br>
                    <label for="Desc">Description:</label>
                    <br>
                    <g:textArea id="Desc" name="Desc" rows="10" cols="100" resize="none"/>
                    <br>
                    <label for="workUsed">Work Used:</label>
                    <br>
                    <input type="file" name="workUsed" id="workUsed">
                    <br>
                    <label for="targetGoal">Target Goal:</label>
                    <label for="belowExpectation" class="labelEx">Below Expectation:</label>
                    <label for="meetsExpectation" class="labelEx">Meets Expectation:</label>
                    <label for="exceedsExpectation" class="labelEx">Exceeds Expectation:</label>
                    <br>
                    <g:field type="text" id="targetGoal" name="targetGoal" placeholder="____" class="targetGoal"/>
                    <input type="button" value="-" onclick="minusBelowExpectation();" class="minus"/>
                    <g:field type="text" id="belowExpectation" name="belowExpectation" value="0" class="oneChar"/>
                    <input type="button" onclick="addBelowExpectation();" value="+" />
                    <input type="button" value="-" onclick="minusMeetsExpectation();" class="minus">
                    <g:field type="text" id="meetsExpectation" name="meetsExpectation" value="0" class="oneChar"/>
                    <input type="button"  onclick="addMeetsExpectation();" value="+">
                    <input type=button value="-" onclick="minusExceedsExpectation();" class="minus">
                    <g:field type="text" id="exceedsExpectation" name="exceedsExpectation" value="0" class="oneChar"/>
                    <input type="button" onclick="addExceedsExpectation();" value="+">
                    <br>
                    <label for="comment">Comment:</label>
                    <br>
                    <g:textArea id="comment" name="comment" rows="10" cols="100" resize="none"/>
                    <br>
                    <label for="observations">Observations:</label>
                    <br>
                    <g:textArea id="observation" name="observation" rows="10" cols="100" resize="none"/>
                    <br>
                    <label for="semseter">Semester:</label>
                    <label for="completed" style="margin-left:40%;">Completed:</label>
                    <br>
                    <g:field type="text" name="semester" style="width:40%;" placeholder="Semseter Ex: Fall2017"/>
                    <g:checkBox style="display: inline-block;margin-left:15%;"id="completed" name="completed"/>
                    <br>
                </div>
            <!--<g:submitButton class="button" name="submitButton" value="Create Outcome" />
             <g:submitButton class="button" name="cancelButton" value="Cancel" />-->
        </div>
        <div class="sidebar">
            <!-- the slider switch bar at the top's left label-->
            <!-- the slider switch bar at the top-->
            <label class="switch">
                <input type="checkbox" onclick="hideShowOutcomesClasses();" id="reveal-Classes"><span class="slider round" ></span></input>
            </label>            <!-- the slider switch bar at the top's right label-->
            <div class="fileFolders">
              <div class="Outcomes" id="Outcomes">
                <g:each in="${Outcomes}" var="o">
                <details>
                  <summary>Outcome ${o.outcomeCategory}:</summary>
                    <g:if test="${o.indicators != NULL}">
                      <g:each in="${o.indicators}">
                        <details>
                          <summary class="cat1">Indicator: ${it.indicatorName}</summary>
                        </details>
                      </g:each>
                      </g:if>
                    </details>
                  </g:each>
                </div>
              <div class="Outcomes" id="Classes">
                <g:each in="${Classes}" var="c">
                  <details>
                    <summary>${c.title}:</summary>
                    <g:if test="${c.indicators != NULL}">
                      <g:each in="${c.indicators}">
                        <summary class="cat1">Indicator: ${it.indicatorName}</summary>
                      </g:each>
                    </g:if>
                  </details>
                </g:each>
              </div>
            </div>
        </div>
    </body>
</html>
