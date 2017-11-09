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
          <g:if test="${c.teachers.id == [session.teacher.id]}">
            <div class="listings">
              <h1>${c.title}</h1>
              </br>
                <div class="indicatorList">
                  <g:if test="${c.indicators != NULL}">
                    <g:each in="${c.indicators}" var="i">
                      <g:if test="${i.measures != NULL}">
                        <g:each in="${i.measures}" var="m">
                          <g:if test="${m.assessment_documents != NULL}">
                            <g:each in="${m.assessment_documents}">
                              <g:link controller="Measures" action="editAssessment" params="[assessment_documents:it.id]">
                              <button class="docButton"> ${m.measureTitle} - ${it.assessmentDocTitle}</button></g:link>
                              </br>
                            </g:each>
                          </g:if>
                        </g:each>
                      </g:if>
                    </g:each>
                  </g:if>
                </div>
                </br>
              </div>
          </g:if>
        </g:each>
        </div>
    </body>
</html>
