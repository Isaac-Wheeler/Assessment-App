<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="userProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Outcomes</p>
            </div><%--Outcome header--%>
            <div class="mainArea">
            		<g:each in="${Outcomes}" var="o">
            			<div class="listings" style="font-size: 1.2em;"><%--Outcome cards un editable--%>
                			<h1>${o.outcomeCategory}</h1>
                			<div class="outcomeDesc">Description: ${o.outcomeCategoryDescription}</div>
                      </br>
                			<div class="indicatorList"><%--Shows each indicator for the respective outcome--%>
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
