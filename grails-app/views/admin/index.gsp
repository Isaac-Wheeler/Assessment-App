<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <div class="newTab">
          <p>Assigned Courses
          </p>
        </div>
        <div class="mainArea">
        <g:each in="${Classes}" var="c">
        <g:if test="${session.teacher != null}">
          <g:if test="${c.teachers.id == [session.teacher.id]}">
            <div class="listings">
              <h1>${c.title}</h1>
              </br>
                <div class="indicatorList">
                  <g:if test="${c.indicators != NULL}">
                    <g:each in="${c.indicators}" var="i">
                      <h2>${i.indicatorName} - ${i.indicatorDescription}</h2>
                      </div>
                      <g:if test="${i.measures != NULL}">
                        <g:each in="${i.measures}" var="m">
                        <h3>${m.measureTitle} - ${m.measureDescription}</h3>
                          <g:if test="${m.assessment_documents != NULL}">
                            <g:each in="${m.assessment_documents}">
                              <g:if test="${!it.complete}">
                                <g:set var="submitButtonValue" value="${'edit_' + it.id}" />
                                <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:submitButtonValue]">
                                <button class="docButton">${it.assessmentDocTitle}</button></g:link>
                                </br>
                              </g:if>
                              <g:else>
                                <p> ${it.assessmentDocTitle} status:complete </p>
                              </g:else>
                            </g:each>
                          </g:if>
                          <g:else>
                            <g:set var="submitButtonValue" value="${'new_' + m.id}" />
                            <g:link controller="assessments" action="editAssessment" params="[courseLink:true, submitButton:submitButtonValue]">
                            <button class="docButton">Create Assessment Documentation</button></g:link>
                            </br>
                          </g:else>
                        </g:each>
                      </g:if>
                    </g:each>
                  </g:if>
                </div>
                </br>
              </div>
          </g:if>
        </g:if>
        </g:each>
        </div>
    </body>
</html>
