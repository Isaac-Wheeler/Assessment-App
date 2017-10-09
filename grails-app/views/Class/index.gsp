<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Classes</p>
            </div>
            <div class="mainArea">
            <g:link url="/class/create">
                <g:textField type="text" id="Title" name="Title"  value="${Classes?.Title}" placeholder="Name" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
                <button class="add">New<div class="plus"> &oplus;</div></button>
            </g:link>
            		<g:each in="${Classes}" var="o">
            			<div class="listings">
                			<h1>${o.outcomeCategory}</h1>
                      <g:link controller="Outcomes" action="editOutcome" params="[outcome:o.id]">
							               <button class="add">Edit</button>
						          </g:link>
						          <g:link controller="Outcomes" action="deleteOutcome" params="[outcome:o.id]">
							               <button class="add">Delete</button>
						          </g:link>
        				  </div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
