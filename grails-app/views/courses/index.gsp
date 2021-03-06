<!DOCTYPE html>
<html>
    <head>
      <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Courses
                  <g:link controller="courses" action="createCourse" params="[isadmin:true]">
                    <button class="add">New<div class="plus"> &oplus;</div></button>
                </g:link></p>
            </div> <%--Above div is the header on the right half--%>
            <div class="mainArea">
              <g:hasErrors bean="${c}">
           			<div class="errors">
             				<g:renderErrors bean="${c}"/>
           			</div>
              </g:hasErrors>
            		<g:each in="${Courses}" var="i">
            			<div class="listings" > <%--Listing of courses in this div--%>
                			<h1>${i.title}</h1>
                      <g:if test="${i.teachers != NULL}">
                          <div class="teach" style="margin-left: 40%;width: 20%; text-align: left;">
                          <g:each in="${i.teachers}" var="t">
                                <g:link controller="courses" action="deleteAssignedTeacher" params="[courses:i.id, teacher:t.id]" onclick="return confirm('Are you sure you want to delete this assigned teacher? teacher: $t.firstName $t.lastName from $i.title')">
                                  <button class="deleteButton" style="text-align: left;">-</button></g:link>
                              ${t.toString()}
                              <br>
                          </g:each>
                          </div>
                          <br>
                      </g:if>
                      <g:form class="simpleform" url="assignNewTeacher">
                        <g:field list="Teacher" name="teacherUserName" type="search"/>
                        <datalist id="Teacher">
                          <g:each in="${Teacher}" var="t">
                            <option value="${t.username}">${t.toString()}</option>
                          </g:each> <%--Displays teachers in a searchable dropdwn list--%>
                        </datalist>
                        <%--<g:select name="teacherId" size="1" from="${Teacher}" id="teacherList" value="${Tid}" style="width:20%;" optionKey="id"/> --%>
                        <g:hiddenField name="type" value="assign" />
                        <g:hiddenField name="class" value="${i.id}" />
							          <button id="assign" class="add">Assign</button> <%--Assigns the teachers--%>
                      </g:form>
                      <br> <%--displays info on the course--%>
                      <p>Target Goal:${i.targetGoal}</p>
                      <p>Required Action:</p>
                      ${i.requiredAction}
                      <br>
                      <g:link controller="courses" action="editCourse" params="[course:i.id, isadmin:true]">
                       <button class="add">Edit</button></g:link> <%--allows editing of course--%>
						          <g:link controller="courses" action="delete" params="[courses:i.id]" onclick="return confirm('Are you sure you want to delete this course? course: $i.title')">
							               <button class="add">Delete</button> <%--unassigns the teachers assigned--%>
						          </g:link>
        				  </div>
        				<br/>
        			</g:each>
            </div>
    </body>
</html>
