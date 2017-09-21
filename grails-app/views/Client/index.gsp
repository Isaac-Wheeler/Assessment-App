<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="userProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <g:each in="${currentAssessment}" var="currentAssessment" status="i">
            	<div class="listings">
                	<h1>${currentAssessment.title}</h1>
                 <p>Completed: ${currentAssessment.completed}</p>
             </div>
             <br/>
        </g:each>
    </body>
</html>