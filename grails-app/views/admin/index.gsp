<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <div class="newTab">
          <p>Assigned Classes
          </p>
        </div>
        <div class="mainArea">
          <g:each in="${Classses}" var="c">
          <g:if test="${c.teachers} = ${session.teacher}"
          <h1>${c.title}</h1>
          </br>
            <div class="listings">
                <div class="indicatorList">
                  <g:if test="${c.indicators != NULL}">
                    <g:each in="${c.indicators}">
                      <g:each in="${it.measures}">
                      <g:link controller="Measures" action="editAssessment" params="[measures:it.id]">
                        <button> ${it.measureTitle}</button></g:link>
                        </br>
                      </g:each>
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
