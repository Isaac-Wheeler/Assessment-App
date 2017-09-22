<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <div class="newTab">
                <p>Current Assessments
                  <g:link controller="Assessments" action="create">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${currentAssessment}" var="currentAssessment" status="i">
            			<div class="listings">
                			<h1>${currentAssessment.title}</h1>
                 		<p>Completed: ${currentAssessment.completed}</p>
             		</div>
             	<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
