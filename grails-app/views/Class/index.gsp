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
              <g:hasErrors bean="${c}">
           			<div class="errors">
             				<g:renderErrors bean="${c}"/>
           			</div>
              </g:hasErrors>
            <g:form class="simpleform" url="index">
                <g:textField type="text" id="title" name="title"  value="${c?.title}" placeholder="Name" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
                <button class="add">New<div class="plus"> &oplus;</div></button>
            </g:form>
            		<g:each in="${Classes}" var="i">
            			<div class="listings">
                			<h1>${i.title}</h1>
                      <div class="indicatorList">
                        <g:if test="${i.indicators != NULL}">
                          <g:each in="${i.indicators}">
                            Indicator: ${it.indicatorName} - ${it.indicatorDescription}
                          </br>
                          </g:each>
                        </g:if>
                			</div>
						          <g:link controller="class" action="delete" params="[classes:i.id]">
							               <button class="add">Delete</button>
						          </g:link>
        				  </div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
