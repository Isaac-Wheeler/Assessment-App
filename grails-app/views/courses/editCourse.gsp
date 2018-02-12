<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:render template="/templates/security"/>
	<div class="pageTitle">
    		<h1>Edit Course</h1>
      	<p>Complete the form below to edit an Course</p>
    </div>
    <g:form class="simpleform" url="editcourse">

    		<div class="backgrounds">
            <div class="labels">
                <label for="courseName">Course Title:</label>
                <br>
                <g:textField type="text" id="title" name="title" value="${course?.title}" placeholder="Title"/>
                <g:hasErrors bean="${course}" field="title">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="title"/>
                  </div>
                </g:hasErrors>
                <br>
                <label for="courseTargetGoal">Course Target Goal:</label>
                <br>
                <g:textField type="text" id="targetGoal" name="targetGoal" value="${course?.targetGoal}" placeholder="50"/>
                <g:hasErrors bean="${course}" field="targetGoal">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="targetGoal"/>
                  </div>
                </g:hasErrors>
                <label for="courseAction">Course Actions:</label>
                <br>
                <g:hiddenField name="course" value="${course}" />
                <g:textArea id="requiredAction" name="requiredAction" value="${course?.requiredAction}" rows="10" cols="50"/>
                <g:hasErrors bean="${course}" field="requiredAction">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="requiredAction"/>
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
