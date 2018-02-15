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
