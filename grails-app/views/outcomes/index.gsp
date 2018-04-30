<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Outcomes
                  <g:link controller="Outcomes" action="createOutcome">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link><%--Outcomes header with new button--%>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Outcomes}" var="o">
            			<div class="listings" style="font-size: 1.2em;"><%-- Start of Cards  --%>
                			<h1>${o.outcomeCategory}</h1>
                			<div class="outcomeDesc">Description: ${o.outcomeCategoryDescription}</div>
                      </br>
                			<div class="indicatorList">
                        <g:if test="${o.indicators != NULL}">
                          <g:each in="${o.indicators}">
                            &nbsp;Indicator: ${it.indicatorName} - ${it.indicatorDescription}<%-- Indicator section of card  --%>
                            <br>
                            <g:link controller="Indicators" action="editIndicator" params="[indicator:it.id]">
                              <button class="add" style="background-color: lightgray; padding: 1%; width: 17%;">Edit Indicator</button></g:link>
                            <g:link controller="Indicators" action="delete" params="[indicator:it.id]" onclick="return confirm('Are you sure you want to delete this indicator? indicator: $it.indicatorName?')">
                              <button class="add" style="background-color: lightgray; padding: 1%; width: 17%;">Delete Indicator</button></g:link>
                          </br>
                          </g:each>
                        </g:if>
                			</div>
                    </br><%-- Outcome section of Cards  --%>
                      <g:link controller="Outcomes" action="editOutcome" params="[outcome:o.id]">
							               <button class="add">Edit Outcome</button></g:link>
						          <g:link controller="Outcomes" action="deleteOutcome" params="[outcome:o.id]" onclick="return confirm('Are you sure you want to delete this outcome? outcome: $o.outcomeCategory')">
							               <button class="add">Delete Outcome</button></g:link>
                      <g:link controller="Indicators" action="create" params="[outcomeId:o.id]">
         							        <button class="add">Add Indicator</button></g:link>
        				</div>
        				<br/>
        			</g:each>
            </div>
    </body>
</html>
