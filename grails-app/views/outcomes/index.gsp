<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Outcomes
                  <g:link url="/outcomes/create">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Outcomes}" var="o">
            			<div class="listings">
                			<h1>${o.outcomeCategory}</h1>
                			<div class="outcomeDesc">Desc: ${o.outcomeCategoryDescription}</div>
                      <p> Id ${o.id} </p>
                			<div class="indicatorList">
                        <g:if test="${o.outcomeIndicators != NULL}">
                          <g:each in="${o.outcomeIndicators.toList()}">
                            ${Indicators.get(it-1).indicatorName}
                          </br>
                            ${Indicators.get(it-1).indicatorDescription}
                          </g:each>
                        </g:if>

                			</div>
                			<g:link controller="Outcomes" action="editOutcome" params="[outcome:o.id]">
							<button class="add">Edit</button>
						</g:link>
						<g:link controller="Outcomes" action="deleteOutcome" params="[outcome:o.id]">
							<button class="add">Delete</button>
						</g:link>
						<g:link controller="Indicators" action="create" params="[givenOutcomeId:o.id]">
							<button class="add">Add Indicator</button>
						</g:link>
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>