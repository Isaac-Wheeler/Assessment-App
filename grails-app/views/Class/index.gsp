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
                <g:textField type="text" id="classTitle"  name="title"  value="${c?.title}" placeholder="Name" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
                <button id="classButton" class="add">Add<div class="plus"> &oplus;</div></button>
            </g:form>
            		<g:each in="${Classes}" var="i">
            			<div class="listings">
                			<h1>${i.title}</h1>
                      <g:if test="${i.teachers != NULL}">
                          <g:each in="${i.teachers}" var="o">
                              <p>${o.lastName}</p>
                          </g:each>
                      </g:if>
                      <g:select name="teacherId" from="${Teachers}" id="teacherList" value="${Tid}" style="width:13%;" optionKey="id" optionValue="teacherLastName" />
                      <g:link controller="class" action="assign" params="[classses:i.id]">
							               <button class="add">Assign</button>
						          </g:link>
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
