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
            <div class="listings">
                <h1>${c.title}</h1>
                <div class="outcomeDesc">Description: ${o.outcomeCategoryDescription}</div>
                </br>
                <div class="indicatorList">
                  <g:if test="${c.indicators != NULL}">
                    <g:each in="${c.indicators}">
                      <g:each in="${it.measures}">
                      <g:link controller="Indicators" action="editAssessment" params="[measures:it.id]">
                        <button class="">${it.measureTitle}</button></g:link>
                        </br>
                      </g:each>
                    </g:each>
                  </g:if>
                </div>
                </br>
          </div>
        </g:each>
        </div>
    </body>
</html>
