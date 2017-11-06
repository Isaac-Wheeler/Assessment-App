<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
	<div class="pageTitle">
    		<h1>Faculty Registration</h1>
      	<p>Complete the form below to create an account!</p>
    </div>
    <g:form class="simpleform" url="/register">
   			 <g:hasErrors bean="${teacher}">
      			<div class="errors">
        				<g:renderErrors bean="${teacher}"/>
      			</div>
    			</g:hasErrors>
    		<div class="backgrounds">
            <div class="labels">
            		<br>
      			<label for="username">Username:</label>
      			<br>
      			<g:textField name="username" value="${teacher?.username}" class="${hasErrors(bean:user,field:'username','errors')}"/>
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
      			<g:textField name="firstName" value="${teacher?.firstName}" class="${hasErrors(bean:user,field:'firstName','errors')}" />
      			<br>
      			<label for="lastName">Last Name:</label>
      			<br>
      			<g:textField name="lastName" value="${teacher?.lastName}" class="${hasErrors(bean:user,field:'lastName','errors')}" />
				<br>
      			<label for"admin">Admin:</label>
      			<g:checkBox name="admin" value="${teacher?.admin}" />
      			<br>
      			<g:submitButton class="button" name="submitButton" value="Create Account" />
      			<g:submitButton class="button" name="cancelButton" value="Cancel" />
      		</div>
      	</div>
	</g:form>
</body>
</html>
