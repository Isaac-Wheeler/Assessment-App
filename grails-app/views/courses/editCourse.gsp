<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:if test="${session?.teacher?.admin == false}">
    ${response.sendRedirect("/")}
  </g:if>
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("/")}
  </g:if>
	<div class="pageTitle">
    		<h1>Edit Course</h1>
      	<p>Complete the form below to edit an Course</p>
    </div>
    <g:form class="simpleform" url="editcourse">

    		<div class="backgrounds">
            <div class="labels">
                <label for="courseName">Course Title:</label>
                <br>
                <g:textField type="text" id="courseName" name="courseName" value="${course?.courseName}" placeholder="Title"/>
                <g:hasErrors bean="${course}" field="courseName">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="courseName"/>
                  </div>
                </g:hasErrors>
                <br>
                <label for="courseTargetGoal">Course Target Goal:</label>
                <br>
                <g:textField type="text" id="courseTargetGoal" name="courseTargetGoal" value="${course?.courseTargetGoal}" placeholder="Title"/>
                <g:hasErrors bean="${course}" field="courseTargetGoal">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="courseTargetGoal"/>
                  </div>
                </g:hasErrors>
                <label for="courseAction">Course Actions:</label>
                <br>
                <g:textArea id="courseAction" name="course" value="${course?.courseAction}" rows="10" cols="50"/>
                <g:hasErrors bean="${course}" field="courseAction">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="courseAction"/>
                  </div>
                </g:hasErrors>
                <br>
                <g:submitButton class="button" name="submitButton" value="Edit Course" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
