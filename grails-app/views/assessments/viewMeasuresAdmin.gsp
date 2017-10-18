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
            		<g:each in="${Measures}" var="m" status="i">
            			<div class="listings">
                			<h1>${m.measureTitle}</h1>
                 		   <p>Class: CS320</p>
             		   </div>
                   <g:link controller="Measures" action="delete" params="[measure:m.id]">
       							<button class="add">Delete</button></g:link>
             	<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
