<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <div class="newTab">
          <p>Assigned Classes
            <g:link controller="Assessments" action="create">
              <button class="add">New<div class="plus"> &oplus;</div></button>
            </g:link>
          </p>
        </div>
        <div class="mainArea">
          <g:each in="${Classes}" var="class" status="c">
            <g:if test="${i.teachers != NULL}">
              <g:each in="${i.teachers}" var="o">
                <div class="listings">
                  <g:if test="${o.lastName = session?.teacher?.lastName}">
                    <h1>${c.title}</h1>
                  </g:if>
                </div>
              </g:each>
             	<br/>
            </g:if>
        	</g:each>
        </div>
    </body>
</html>
