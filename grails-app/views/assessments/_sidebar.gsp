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
          <g:if test="${o.indicators != NULL}">
            <g:each in="${o.indicators}">
              <g:set var="c" value="${it.classes.find()}" />
              <g:render template="/templates/showOwnedOnly" model="['item':c]">
                <details>
                  <summary>Outcome ${o.outcomeCategory}:</summary>
                <details>
                <summary class="cat1">Indicator: ${it.indicatorName}</summary>
                  <g:if test="${it.measures != NULL}">
                    <g:each in="${it.measures}" var="m">
                      <details>
                        <summary class="cat2">Measure: ${m.measureTitle}</summary>
                          <g:if test="${m.assessment_documents != NULL}">
                            <g:each in="${m.assessment_documents}">
                              <g:link controller="assessments" action="delete" params="[ad:it.id]" onclick="return confirm('Are you sure you want to delete this assessment? Assessment for Measure: $m.measureTitle')">
                              <input type="button" class="deleteButton" style="text-align: left;" value="-"></g:link>
                              <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:'edit_' + it.id]">
                              <input type="button" class="assess" name="submitButton" onclick="revealInfo();">Assessment: ${it.measure.find().measureTitle}</input></g:link>
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
              </g:render>
            </g:each>
          </g:if>
          </details>
        </g:each>
      </div>
      <div class="Outcomes" id="Classes">
        <g:each in="${Courses}" var="c">
          <g:render template="/templates/showOwnedOnly" model="['item':c]">
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
                                <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:'edit_' + it.id]">
                                <input type="button" class="assess" name="submitButton" onclick="revealInfo();">Assessment: ${it.measure.find().measureTitle}</input></g:link>
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
          </g:render>
        </g:each>
      </div>
    </div>
</div>
