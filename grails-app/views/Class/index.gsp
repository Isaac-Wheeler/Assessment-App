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
            		<g:each in="${Classes}" var="c">
            			<div class="listings">
                			<h1>${c.title}</h1>
						          <g:link controller="Classes" action="deleteClass" params="[classes:c.id]">
							               <button class="add">Delete</button>
						          </g:link>
        				  </div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
