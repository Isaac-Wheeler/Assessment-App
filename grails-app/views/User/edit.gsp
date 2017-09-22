<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assessment</title>
            <asset:stylesheet src="assessment.css"/>
</head>
<body>
<g:form class="simpleform" url="/register">
	<div class="pageTitle">
    		<h1>User Registration</h1>
      	<p>Complete the form below to create an account!</p>
    </div>
    <g:hasErrors bean="${user}">
      <div class="errors">
        <g:renderErrors bean="${user}"/>
      </div>
    </g:hasErrors>
    <div class="backgrounds">
            <div class="labels">
            <br>
      		<label for="username">Username:</label>
      		<br>
      		<g:textField name="username" value="${user?.username}" class="${hasErrors(bean:user,field:'username','errors')}"/>
    			<br>
      		<label for="password">Password:</label>
      		<br>
      		<g:passwordField name="password" class="${hasErrors(bean:user,field:'password','errors')}" />
			<br>
      		<label for="confirm">Confirm Password:</label>
      		<br>
      		<g:passwordField name="confirm" class="${hasErrors(bean:user,field:'password','errors')}" />
			<br>
      		<label for="firstName">First Name:</label>
      		<br>
      		<g:textField name="firstName" value="${user?.firstName}" class="${hasErrors(bean:user,field:'firstName','errors')}" />
      		<br>
      		<label for="lastName">Last Name:</label>
      		<br>
      		<g:textField name="lastName" value="${user?.lastName}" class="${hasErrors(bean:user,field:'lastName','errors')}" />
			<br>
      		<label for"admin">Admin:</label>
      		<g:checkBox name="admin" value="${user?.admin}" />
      		<br>
      		<g:submitButton class="button" name="submitButton" value="Edit Account" />
</g:form>
</body>
</html>
