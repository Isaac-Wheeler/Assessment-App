<div class="sidebar" style="background-color: #464646;"><%--created for a side bar that wont add or delete--%>
    <!-- the slider switch bar at the top's left label-->
    <!-- the slider switch bar at the top-->
    <label class="switch">
        <input type="checkbox" onclick="hideShowOutcomesClasses();" id="reveal-Classes"><span class="slider round" ></span></input>
    </label>            <!-- the slider switch bar at the top's right label-->
    <div class="fileFolders">
      <div class="Outcomes" id="Outcomes">
        <g:each in="${Outcomes}" var="o">
          <g:if test="${o.indicators != NULL}">
            <g:each in="${o.indicators}">
              <g:set var="c" value="${it.courses.find()}" />
              <g:render template="/templates/showOwnedOnly" model="['item':c]">
                <details>
                  <summary>Outcome ${o.outcomeCategory}:</summary>
                <details>
                <summary class="cat1" style="background-color:#464646">Indicator: ${it.indicatorName}</summary>
                  <g:if test="${it.measures != NULL}">
                    <g:each in="${it.measures}" var="m">
                      <details>
                        <summary class="cat2">Measure: ${m.measureTitle}</summary>
                          <g:if test="${m.assessment_documents != NULL}">
                            <g:each in="${m.assessment_documents}">
                              <g:link controller="assessments" action="compare" params="[courseLink:true, submitButton:'Choice_' + it.id, AD2:AD2.id]">
                              <input type="button" class="assess" name="submitButton"style="background-color:#464646" onclick="revealInfo();">Assessment: ${it.measure.find().measureTitle}</input></g:link>
                              <br><%--Main difference from "_sidebar" is the absence of creating and deleting old AD's --%>
                            </g:each>
                          </g:if>
                          <g:else>
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
                                <g:link controller="assessments" action="compare" params="[courseLink:true, submitButton:'Choice_' + it.id, AD2:AD2.id]">
                                <input type="button" class="assess" name="submitButton" style="background-color:#464646" onclick="revealInfo();">Assessment: ${it.measure.find().measureTitle}</input></g:link>
                                <br><%--Main difference from "_sidebar" is the absence of creating and deleting old AD's --%>
                              </g:each>
                            </g:if>
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
