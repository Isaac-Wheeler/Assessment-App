<!DOCTYPE html>
<html>
    <head>
      <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
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
      <g:render template="/templates/securityNotAdmin"/>
      <g:uploadForm class="simpleform" url="index" >
        <!-- right half of the page -->
        <div class="main">
          <div class="info" id="info">
            <h1>Assessment Documentation</h1>
            <label for="assessmentDocTitle">Assessment Documentation Title:</label>
            <br>
            <g:field type="text" value="${assessment_documents?.assessmentDocTitle}" id="assessmentDocTitle" name="assessmentDocTitle" style="width:35%;" placeholder="Title" class="shortText"/>
            <g:hasErrors bean="${assessment_documents}" field="assessmentDocTitle">
              <div class="errors">
                  <g:renderErrors bean="${assessment_documents}" field="assessmentDocTitle"/>
              </div>
            </g:hasErrors>
            <br>
            <label for="Desc">Description:</label>
            <br>
            <g:textArea id="Desc" value="${assessment_documents?.summary}" name="summary" rows="10" cols="100" resize="none"/>
            <g:hasErrors bean="${assessment_documents}" field="summary">
              <div class="errors">
                  <g:renderErrors bean="${assessment_documents}" field="summary"/>
              </div>
            </g:hasErrors>
            <br>
            <label for="workUsed">Work Used:</label>
            <br>
              <g:each in="${assessment_documents?.documents}" var="o">
                <g:link action="downloadFile" id="${o.id}">${o.filename}</g:link>
              </g:each>
              <br>
              <input type="file" name="myFile" multiple />
            <br>
            <label for="targetGoal">Target Goal(in percent):</label>
            <label for="belowExpectation" class="labelEx" >Below Expectation:<a id="BE"></a></label>
            <label for="meetsExpectation" class="labelEx" style="margin-left:9%;">Meets Expectation:<a id="ME"></a></label>
            <label for="exceedsExpectation" class="labelEx" style="margin-left:8%;">Exceeds Expectation:<a id="EE"></a></label>
            <br>
            <g:field type="number" value="${assessment_documents?.targetGoal}" id="targetGoal" name="targetGoal" placeholder="____" class="targetGoal"/>

            <input type="button" value="-" onclick="minusBelowExpectation();" class="minus"/>
            <g:if test="${assessment_documents?.needsImprovement != null}">
              <g:field type="text" id="belowExpectation" name="needsImprovement" value="${assessment_documents?.needsImprovement}" class="oneChar"/>
            </g:if>
            <g:else>
              <g:field type="text" id="belowExpectation" name="needsImprovement" value="0" class="oneChar"/>
            </g:else>
            <input type="button" onclick="addBelowExpectation();" value="+" />

            <input type="button" value="-" onclick="minusMeetsExpectation();" class="minus">
            <g:if test="${assessment_documents?.meetsExpectations != null}">
              <g:field type="text" id="meetsExpectation" name="meetsExpectations" value="${assessment_documents?.meetsExpectations}" class="oneChar"/>
            </g:if>
            <g:else>
              <g:field type="text" id="meetsExpectation" name="meetsExpectations" value="0" class="oneChar"/>
            </g:else>
            <input type="button"  onclick="addMeetsExpectation();" value="+">

            <input type=button value="-" onclick="minusExceedsExpectation();" class="minus">
            <g:if test="${assessment_documents?.exceedsExpectations != null}">
              <g:field type="text" id="exceedsExpectation" name="exceedsExpectations" value="${assessment_documents?.exceedsExpectations}" class="oneChar"/>
            </g:if>
            <g:else>
              <g:field type="text" id="exceedsExpectation" name="exceedsExpectations" value="0" class="oneChar"/>
            </g:else>
            <input type="button" onclick="addExceedsExpectation();" value="+">

            <br>
            <label for="comment">Comment:</label>
            <br>
            <g:textArea id="comment" value="${assessment_documents?.comments}" name="comments" rows="10" cols="100" resize="none"/>
            <g:hasErrors bean="${assessment_documents}" field="comments">
              <div class="errors">
                  <g:renderErrors bean="${assessment_documents}" field="comments"/>
              </div>
            </g:hasErrors>
            <br>
            <label for="observations">Observations:</label>
            <br>
            <g:textArea id="observation" value="${assessment_documents?.resultComment}" name="resultComment" rows="10" cols="100" resize="none"/>
            <g:hasErrors bean="${assessment_documents}" field="resultComment">
              <div class="errors">
                  <g:renderErrors bean="${assessment_documents}" field="resultComment"/>
              </div>
            </g:hasErrors>
            <br>
            <label for="semseter">Completed:</label>
            <g:checkBox style="display: inline-block;margin-left:0%;"id="completed" name="complete" value="${assessment_documents?.complete}"/>
            <br>
            <input type="button" class="actionButton" name="action" id="action" value="Actions "onclick="revealAction();"/>
            <br>
            <label for="requiredAction" id="actionLabel" class="actionsText">Required Actions:</label>
            <g:textArea id="requiredAction" value="${assessment_documents?.requiredAction}" name="requiredAction" rows="10" cols="100" class="actionsText" />
            <br>
            <g:hiddenField name="measureID" value="${measureID}"/>
            <g:submitButton class="button" name="submitButton" value="Submit" />
            <g:submitButton class="button" name="submitButton" value="Cancel" />
            <br>
            <input type="button" class="button" value="Clear" onclick="clearForm();">
          </div>
          <g:if test="${show}">
          <script type="text/javascript" >
           console.log("ran");
            if(${show}){
              document.getElementById("info").style.visibility = "visible";
              console.log("worked");
            }
          </script>
        </g:if>
        </div>
        <div class="sidebar">
            <!-- the slider switch bar at the top's left label-->
            <!-- the slider switch bar at the top-->
            <i class="w3-xlarge"> <g:link controller="main" class="fa fa-home"  style="float: left; margin-top: 4%; margin-left: 3%"></g:link></i>
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
                              <g:link controller="assessments" action="delete" params="[ad:it.id]">
                              <input type="button" class="deleteButton" style="text-align: left;" value="-"></g:link>
                              <g:set var="submitButtonValue" value="${'edit_' + it.id}" />
                              <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:submitButtonValue]">
                              <input type="button" class="assess" name="submitButton" onclick="revealInfo();">Assessment: ${it.assessmentDocTitle}</input></g:link>
                              <br>
                            </g:each>
                            </g:if>
                            <g:else>
                              <button class="newAssess"  name="submitButton" value="new_${m.id}">New  <div class="plus"> &oplus;</div></button>
                              </g:else>
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
                          <g:if test="${it.academicYear == Year}">
                            <summary class="cat1">Indicator: ${it.indicatorName}</summary>
                            <g:if test="${it.measures != NULL}">
                              <g:each in="${it.measures}" var="m">
                                <details>
                                  <summary class="cat2">Measure: ${m.measureTitle}</summary>
                                  <g:if test="${m.assessment_documents != NULL}">
                                    <g:each in="${m.assessment_documents}">
                                      <g:link controller="assessments" action="delete" params="[ad:it.id]">
                                        <input type="button" class="deleteButton" style="text-align: left;" value="-"></g:link>
                                        <g:set var="submitButtonValue" value="${'edit_' + it.id}" />
                                      <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:submitButtonValue]">
                                        <input type="button" class="assess" name="submitButton" onclick="revealInfo();">Assessment: ${it.assessmentDocTitle}</input></g:link>
                                      <br>
                                    </g:each>
                                  </g:if>
                                  <g:else>
                                    <button class="newAssess"  name="submitButton" value="new_${m.id}">New  <div class="plus"> &oplus;</div></button>
                                  </g:else>
                                </details>
                              </g:each>
                            </g:if>
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
