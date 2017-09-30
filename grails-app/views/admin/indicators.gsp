<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Indicator
                  <g:link controller="assessments" action="createIndicator">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Indicator}" var="i">
            			<div class="listings">
                			<h1>$i.title</h1>
                			<p>Desc: ${i.desc}</p>
                			<g:link controller="assessments" action="editIndicator" params="[indicator:i.id]">
							<button class="add">Edit</button>
						</g:link>
						<g:link controller="assessments" action="deleteIndicator" params="[indicator:i.id]">
							<button class="add">Delete</button>
						</g:link>
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
