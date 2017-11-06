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
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
      <g:uploadForm class="simpleform" url="editAssessment" >
        <!-- right half of the page -->
        <div class="main">
          <div class="info" id="info">
            <g:hasErrors bean="${assessment_documents}">
         			<div class="errors">
           				<g:renderErrors bean="${assessment_documents}"/>
         			</div>
       			</g:hasErrors>
            <h1>Assessment Documentation</h1>
            <label for="assessmentDocTitle">Assessment Documentation Title:</label>
            <br>
            <g:field type="text" value="${assessment_documents?.assessmentDocTitle}" id="assessmentDocTitle" name="assessmentDocTitle" style="width:35%;" placeholder="Title" class="shortText"/>
            <br>
            <label for="Desc">Description:</label>
            <br>
            <g:textArea id="Desc" value="${assessment_documents?.summary}" name="summary" rows="10" cols="100" resize="none"/>
            <br>
            <label for="workUsed">Work Used:</label>
            <br>
              <input type="file" name="myFile" />
            <br>
            <label for="targetGoal">Target Goal:</label>
            <label for="belowExpectation" class="labelEx" >Below Expectation:</label>
            <label for="meetsExpectation" class="labelEx">Meets Expectation:</label>
            <label for="exceedsExpectation" class="labelEx">Exceeds Expectation:</label>
            <br>
            <g:field type="text" value="${assessment_documents?.targetGoal}" id="targetGoal" name="targetGoal" placeholder="____" class="targetGoal"/>
            <input type="button" value="-" onclick="minusBelowExpectation();" class="minus"/>
            <g:field type="text" id="belowExpectation" name="needsImprovement" value="${assessment_documents?.needsImprovement}" value="0" class="oneChar"/>
            <input type="button" onclick="addBelowExpectation();" value="+" />
            <input type="button" value="-" onclick="minusMeetsExpectation();" class="minus">
            <g:field type="text" id="meetsExpectation" name="meetsExpectations" value="${assessment_documents?.meetsExpectations}" value="0" class="oneChar"/>
            <input type="button"  onclick="addMeetsExpectation();" value="+">
            <input type=button value="-" onclick="minusExceedsExpectation();" class="minus">
            <g:field type="text" id="exceedsExpectation" name="exceedsExpectations" value="${assessment_documents?.exceedsExpectations}" value="0" class="oneChar"/>
            <input type="button" onclick="addExceedsExpectation();" value="+">
            <br>
            <label for="comment">Comment:</label>
            <br>
            <g:textArea id="comment" value="${assessment_documents?.comments}" name="comments" rows="10" cols="100" resize="none"/>
            <br>
            <label for="observations">Observations:</label>
            <br>
            <g:textArea id="observation" value="${assessment_documents?.resultComment}" name="resultComment" rows="10" cols="100" resize="none"/>
            <br>
            <label for="semseter">Semester:</label>
            <label for="completed" style="margin-left:40%;">Completed:</label>
            <br>
            <g:field type="text" value="${assessment_documents?.academicSemester}" name="academicSemester" style="width:40%;" placeholder="Semseter Ex: Fall2017"/>
            <g:checkBox style="display: inline-block;margin-left:15%;"id="completed" name="complete"/>
            <br>
            <input type="button" class="actionButton" name="action" id="action" value="Actions "onclick="revealAction();"/>
            <br>
            <label for="requiredAction" id="actionLabel" class="actionsText">Required Actions:</label>
            <g:textArea id="requiredAction" value="${assessment_documents?.requiredAction}" name="requiredAction" rows="10" cols="100" class="actionsText" />
            <br>
            <g:hiddenField name="measureID" value="${measureID}"/>
            <g:submitButton class="button" name="submitButton" value="Submit" />
            <g:submitButton class="button" name="submitButton" value="Cancel" />
          </div>
        </div>
        <div class="sidebar">
            <!-- the slider switch bar at the top's left label-->
            <!-- the slider switch bar at the top-->
            <i class="w3-xlarge"> <g:link controller="admin" class="fa fa-home"  style="float: left; margin-top: 4%; margin-left: 3%"></g:link></i>
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
                      <g:if test="${it.measures != NULL}">
                        <g:each in="${it.measures}" var="m">
                          <details>
                          <summary class="cat2">Measure: ${m.measureTitle}</summary>
                          <g:if test="${m.assessment_documents != NULL}">
                            <g:each in="${m.assessment_documents}">
                              <button class="assess" name="submitButton" onclick="revealInfo();" value="edit_${it.id}">Assessment: ${it.assessmentDocTitle}</button>
                              <br>
                            </g:each>
                            <input type="button" class="newAssess"  onclick="revealInfo();" value="New  &oplus;" value="edit_${m.id}"/>
                          </g:if>
                        </details>
                        </g:each>
                      </g:if>
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
                        <details>
                        <summary class="cat1">Indicator: ${it.indicatorName}</summary>
                        <g:if test="${it.measures != NULL}">
                          <g:each in="${it.measures}" var="m">
                            <details>
                            <summary class="cat2">Measure: ${it.measureTitle}</summary>
                            <g:if test="${it.assessment_documents != NULL}">
                              <g:each in="${it.assessment_documents}">
                                <button class="assess" name="submitButton" onclick="revealInfo();" value="edit_${it.id}">Assessment: ${it.assessmentDocTitle}</button>
                                <br>
                              </g:each>
                              <button class="newAssess" name="submitButton" onclick="revealInfo();" value="add_${it.id}">New<div class="plus"> &oplus;</div></button>
                            </g:if>
                            </details>
                          </g:each>
                        </g:if>
                        </details>
                      </g:each>
                    </g:if>
                  </details>
                </g:each>
              </div>
            </div>
        </div>
      </g:uploadForm>
    </body>
</html>
