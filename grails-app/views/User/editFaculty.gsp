<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("/")}
  </g:if>
	<div class="pageTitle">
    		<h1>Edit Faculty</h1>
      	<p>Complete the form below to create an Outcome</p>
    </div>
    <g:form class="simpleform" url="/edit">
   			 <g:hasErrors bean="${teacher}">
      			<div class="errors">
        				<g:renderErrors bean="${teacher}"/>
      			</div>
    			</g:hasErrors>
    		<div class="backgrounds">
          <div class="labels">
      			<label for="password">Password:</label>
      			<br>
      			<g:passwordField name="password" class="${hasErrors(bean:user,field:'password','errors')}" />
				    <br>
      			<label for="confirm">Confirm Password:</label>
      			<br>
      			<g:passwordField name="confirm" class="${hasErrors(bean:user,field:'password','errors')}" />
				    <br>
      			<label for="profilePic">Profile Picture:</label>
      			<br>
      			<input type="file" name="profilePic" />
				    <br>
          	<g:hiddenField name="id" value="${id}" />
      			<g:submitButton class="button" name="submitButton" value="Edit Account" />
      			<g:submitButton class="button" name="submitButton" value="Cancel" />
      		</div>
      	</div>
      </g:form>
</body>
</html>