<div class="sidebar" style="background-color: #464646;"><%--created for a side bar that wont add or delete--%>
    <!-- the slider switch bar at the top's left label-->
    <!-- the slider switch bar at the top-->
    <label class="switch">
        <input type="checkbox" onclick="hideShowOutcomesClasses();" id="reveal-Classes"><span class="slider round" ></span></input>
    </label>            <!-- the slider switch bar at the top's right label-->
    <div class="fileFolders">
      <%--Start of Outcomes organized folders--%>
      <%--Display of the Outcomes--%>
      <div class="Outcomes" id="Outcomes">
        <g:each in="${Outcomes}" var="o"><%--Outcomes Each--%>
        <details>
          <summary>Outcome ${o.outcomeCategory}:</summary>
            <g:if test="${o.indicators != NULL}"><%--if null indicators--%>
              <g:each in="${o.indicators}"><%--indicators each--%>
                <g:set var="c" value="${it.courses.find()}" />
                <g:render template="/templates/showOwnedOnly" model="['item':c]"><%--show owned template--%>
                  <%--Display of Indicators----%>
                  <details><%--indicator details--%>
                    <summary class="cat1">Indicator: ${it.indicatorName}</summary><%--indicators--%>
                    <g:if test="${it.measures != NULL}"><%--if measures is null--%>
                      <g:each in="${it.measures}" var="m"><%--measures each--%>
                        <details><%--Measures details--%>
                          <%--Display of Measures--%>
                          <summary class="cat2">Measure: ${m.measureTitle}</summary>
                            <g:if test="${m.assessment_documents != NULL}">
                              <g:each in="${m.assessment_documents}">
                                <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:'edit_' + it.id]">
                                <input type="button" class="assess" name="submitButton" onclick="revealInfo();">Assessment: ${it.measure.find().measureTitle}</input></g:link>
                                <br>
                              </g:each><%--Assessments document each--%>
                            </g:if><%--if assess docs is null--%>
                            <g:else><%--else assess docs is null--%>
                            </g:else><%--else assess docs is null--%>
                        </details><%--Measures details--%>
                      </g:each><%--measures each--%>
                    </g:if><%--if measures is null--%>
                  </details><%--indicators details--%>
                </g:render><%--show owned template--%>
              </g:each><%--indicators each--%>
            </g:if><%--if null indicators--%>
          </details><%--outcomes details--%>
        </g:each><%--outcomes each--%>
      </div><%--Closes outcomes div--%>
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
