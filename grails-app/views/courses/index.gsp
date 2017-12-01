<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Courses</p>
            </div>
            <div class="mainArea">
              <g:hasErrors bean="${c}">
           			<div class="errors">
             				<g:renderErrors bean="${c}"/>
           			</div>
              </g:hasErrors>
            <g:form class="simpleform" url="newCourse">
                <g:textField type="text" id="classTitle"  name="title"  value="${c?.title}" placeholder="Name" class="${hasErrors(bean:outcome,field:'classTitle','errors')}"/>
                <g:hiddenField name="type" value="new" />
                <button id="classButton" class="add">Add<div class="plus"> &oplus;</div></button>
            </g:form>
            		<g:each in="${Classes}" var="i">
            			<div class="listings" >
                			<h1>${i.title}</h1>
                      <g:if test="${i.teachers != NULL}">
                          <div class="teach" style="margin-left: 40%;width: 20%; text-align: left;">
                          <g:each in="${i.teachers}" var="t">

                                <g:link controller="courses" action="deleteAssignedTeacher" params="[classes:i.id, teacher:t.id]">
                                  <button class="deleteButton" style="text-align: left;">-</button></g:link>
                              ${t.toString()}
                              <br>
                          </g:each>
                          </div>
                          <br>
                      </g:if>
                      <g:form class="simpleform" url="assignNewTeacher">
                        <g:select name="teacherId" from="${Teacher}" id="teacherList" value="${Tid}" style="width:13%;" optionKey="id"/>
                        <g:hiddenField name="type" value="assign" />
                        <g:hiddenField name="class" value="${i.id}" />
							          <button id="assign" class="add">Assign</button>
                      </g:form>
                      <br>
						          <g:link controller="courses" action="delete" params="[classes:i.id]">
							               <button class="add">Delete</button>
						          </g:link>
        				  </div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
