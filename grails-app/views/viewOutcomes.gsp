<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Outcomes
                  <g:link controller="outcome" action="createOutcome">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Outcome}" var="o">
            			<div class="listings">
                			<h1>$o.title</h1>
                			<p>Desc: ${o.desc}</p>
                			<g:link controller="outcome" action="edit" params="[outcome:o.id]">
							<button class="add">Edit</button>
						</g:link>
						<g:link controller="outcome" action="delete" params="[outcome:o.id]">
							<button class="add">Delete</button>
						</g:link> 
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
