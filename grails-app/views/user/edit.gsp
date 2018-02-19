<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:render template="/templates/security"/>
	<div class="pageTitle">
    		<h1>Edit Faculty</h1>
      	<p>Complete the form below to create an Outcome</p>
    </div>
    <g:form class="simpleform" url="edit">
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
          		<g:hiddenField name="id" value="${id}" />
      			<g:submitButton class="button" name="submitButton" value="Edit Account" />
      			<g:submitButton class="button" name="submitButton" value="Cancel" />
      		</div>
      	</div>
      </g:form>
</body>
</html>
