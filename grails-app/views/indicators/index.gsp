<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Indicator
                  <g:link controller="Indicators" action="create">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Indicators}" var="i">
            			<div class="listings">
                			<h1>${i.indicatorName}</h1>
                			<p>Desc: ${i.indicatorDescription}</p>
                      <p>Outcome Id: ${i.outcomeId}</p>
                      <p>Id ${i.id}</p>
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
