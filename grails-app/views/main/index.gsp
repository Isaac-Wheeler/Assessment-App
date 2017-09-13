<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <div class="welcomeMessage">
            <h1>Welcome</h1>
            <p class="info">
        	tempory register button <br>
        	<g:link controller="user" action="register">Sign up now!</g:link>
     		 </p>
        </div>
        <div class="loginBox">
            <div class="banner">
                <p>Login</p>
            </div>
            <g:form class="simpleform" url="/login">
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="Password">
                <br>
                <small>
                	<g:if test="${flash.success}">
    					<div class="alert alert-success" style="display: block">${flash.success}</div>
					</g:if>
					<g:if test="${flash.error}">
   					 	<div class="alert alert-error" style="display: block">${flash.error}</div>
					</g:if>
				</small>
                <br>
                <g:submitButton class="button" name="submitButton" value="Login" />
            </g:form>
        </div>
    </body>
</html>
