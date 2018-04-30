<!DOCTYPE html>
<html>
    <head>
      <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <div class="newTab"> <%-- This div is dedicated to the header on the right --%>
          <p>Assigned Courses
          </p>
        </div>
        <div class="mainArea"><%-- Contains the "Main area" of the section on the right below the header --%>
        <div class="listings"><%--Admin completion level card--%>
          <%--<g:each in="${}">
          ${TEACHERNAME} Completed: ${COMPLETED ASSESSMENTS}/${TOTAL ASSESSMENTS}
        </g:each>--%>
        </div>
        <g:each in="${Courses}" var="c">
        <g:if test="${session.teacher != null}">
          <g:render template="/templates/lonelyAdmin" model="['item':c]"><%-- Shows the owners assigned courses if statement--%>
            <div class="listings">
              <h1>${c.title}</h1>
              </br>
                <div class="indicatorList">
                  <g:if test="${c.indicators != NULL}">
                    <g:each in="${c.indicators}" var="i"><%-- Start of the Cards for loop--%>
                      <g:if test="${i.academicYear == year}">
                        <h2>${i.indicatorName} - ${i.indicatorDescription}</h2>
                        <g:if test="${i.measures != NULL}">
                          <g:each in="${i.measures}" var="m">
                            <h3>${m.measureTitle} - ${m.measureDescription}</h3>
                            <g:if test="${m.assessment_documents != NULL}">
                              <g:each in="${m.assessment_documents}">
                                <p> Exceeds:${it.exceedsExpectations}/${it.numberOfStudents} Meets: ${it.meetsExpectations}/${it.numberOfStudents} Below:${it.needsImprovement }/${it.numberOfStudents}</p>
                                <g:if test="${!it.complete}">
                                  <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:'edit_' + it.id]">
                                  <button class="docButton">Go To</button></g:link>
                                  </br>
                                </g:if>
                                <g:else>
                                  <p>status:complete </p>
                                </g:else>
                              </g:each>
                            </g:if>
                            <g:else>
                              <g:link controller="assessments" params="[courseLink:true, submitButton:'new_' + m.id]">
                              <button class="docButton">Create Assessment Documentation</button></g:link>
                              </br>
                            </g:else>
                          </g:each>
                        </g:if>
                      </g:if>
                    </g:each><%-- End of the Cards for loop--%>
                  </g:if>
                </div>
                </br>
              </div>
          </g:render>
        </g:if>
        </g:each>
        </div>
    </body>
</html>
