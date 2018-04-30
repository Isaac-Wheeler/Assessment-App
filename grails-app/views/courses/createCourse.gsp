<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:render template="/templates/security"/>
	<div class="pageTitle">
    		<h1>Create Course</h1>
      	<p>Complete the form below to create a Course</p>
    </div><%--Above div basic header--%>
    <g:form class="simpleform" url="createCourse">

    		<div class="backgrounds">
            <div class="labels"> <%--BAsic form for inputing information same as editCourse--%>
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
                <g:textField type="text" id="targetGoal" list="target" name="targetGoal" value="${course?.targetGoal}" placeholder="Target Goal"/>
                <datalist id="target"><%--suggested target goals dynamically set in bootstrap--%>
                  <option value="${STG[0].gradeLevelTargetGoal}">Freshman Course</option>
                  <option value="${STG[1].gradeLevelTargetGoal}">Sophmore Course</option>
                  <option value="${STG[2].gradeLevelTargetGoal}">Junior Course</option>
                  <option value="${STG[3].gradeLevelTargetGoal}">Senior Course</option>
                </datalist>
                <g:hasErrors bean="${course}" field="targetGoal">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="targetGoal"/>
                  </div>
                </g:hasErrors>
                <label for="courseAction">Course Actions:</label>
                <br>
                <g:textArea id="requiredAction" name="requiredAction" value="${course?.requiredAction}" rows="10" cols="50"/>
                <g:hasErrors bean="${course}" field="requiredAction">
                  <div class="errors">
                      <g:renderErrors bean="${course}" field="requiredAction"/>
                  </div>
                </g:hasErrors>
                <br> <%--Submit/action buttons below--%>
                <g:submitButton class="button" name="submitButton" value="Create" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
