<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
	<div class="pageTitle">
    		<h1>Url Signup</h1>
      	<p>Complete the form below to create account</p>
    </div><%--Header--%>
    <g:uploadForm class="simpleform" url="urlSignup">
   			 <g:hasErrors bean="${teacher}">
      			<div class="errors">
        				<g:renderErrors bean="${teacher}"/>
      			</div>
    			</g:hasErrors>
    		<div class="backgrounds"><%--user registration--%>
          <div class="labels">
            <label for="username">Username: ${teacher?.username}</label>
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
          	<g:hiddenField name="id" value="${id}" /><%--determines id--%>
      			<g:submitButton class="button" name="submitButton" value="Edit Account" />
      			<g:submitButton class="button" name="submitButton" value="Cancel" />
      		</div>
      	</div>
      </g:uploadForm>
</body>
</html>
