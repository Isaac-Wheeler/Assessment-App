<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="userProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Outcomes</p>
            </div>
            <div class="mainArea">
            		<g:each in="${Outcomes}" var="o">
            			<div class="listings">
                			<h1>${o.outcomeCategory}</h1>
                			<div class="outcomeDesc">Description: ${o.outcomeCategoryDescription}</div>
                      </br>
                			<div class="indicatorList">
                        <g:if test="${o.indicators != NULL}">
                          <g:each in="${o.indicators}">
                            &nbsp;Indicator: ${it.indicatorName} - ${it.indicatorDescription}
                          </br>
                          </g:each>
                        </g:if>
                			</div>
                      </br>
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>