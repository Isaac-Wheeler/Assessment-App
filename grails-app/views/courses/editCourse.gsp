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
    </div> <%--The above div is the header--%>
    <g:form class="simpleform" url="editCourse">

    		<div class="backgrounds">
            <div class="labels"><%--Simple form for inputing in the information--%>
                <label for="courseName">Course Title:</label>
                <br>
                <g:textField type="text" id="title" name="title" value="${course?.title}" placeholder="Title"/>
                <g:hasErrors bean="${course}" field="title">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="title"/>
                  </div>
                </g:hasErrors>
                <br>
                <label for="courseTargetGoal">Course Target Goal(in Percent):</label>
                <br>
                <g:textField type="text" list="target" id="targetGoal" name="targetGoal" value="${course?.targetGoal}" placeholder="50"/>
                <datalist id="target">
                  <option value="60">Freshman Course</option>
                  <option value="70">Sophmore Course</option>
                  <option value="80">Junior Course</option>
                  <option value="90">Senior Course</option>
                </datalist> <%--Planning on changing this above data list as its temporary untill put in database put option of changing in setting acessible by admin--%>
                <g:hasErrors bean="${course}" field="targetGoal">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="targetGoal"/>
                  </div>
                </g:hasErrors>
                <label for="courseAction">Course Actions:</label> <%--Actions for suggesting course has been changed to be set in here--%>
                <br>
                <g:hiddenField name="course" value="${course.id}" />
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
