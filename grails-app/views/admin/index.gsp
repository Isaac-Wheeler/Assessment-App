<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
<<<<<<< HEAD
        <g:each in="${currentAssessment}" var="currentAssessment" status="i">
            	<div class="listings">
                	<h1>${currentAssessment.title}</h1>
                 <p>Completed: ${currentAssessment.completed}</p>
             </div>
             <br/>
        </g:each>
=======
        <div class=leftPanel>
            <div class="profileInfo">
                <img class="img-circle" src="blankPerson.jpg">
                <br>
                <p>${session?.user?.firstName} ${session?.user?.lastName}<p>
            </div>
            <button class="button">Assessment Goals</button>
            <br>
            <button class="button button2">Completed Courses</button>
            <br>
            <g:link controller="teachers">
              <button class="button button2">Teachers</button>
            </g:link>
            <br>
            <g:link controller="user" action="register">
            	<button class="button button2">Register</button>
            </g:link>
            <br>
            <g:link controller="user" action="logout">
                <button class="button button2">Log Out</button>
            </g:link>
        </div>
        <div class="rightPanel">
            <div class="newTab">
                <p>Assessment Goals
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
>>>>>>> 4ab201d1ba88074bbadd07f73671f430e6af34fe
    </body>
</html>
