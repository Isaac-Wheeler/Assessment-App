<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Teachers
                  <g:link controller="Assessments" action="create">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${User}" var="u" status="i">
            			<div class="listings">
                			<h1>${i+1}. ${u.lastName}, ${u.firstName}</h1>
                			<p>Registered: ${u.dateCreated}</p>
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
