<!DOCTYPE html>
<html>
    <head>
        <!--<script type="text/javascript">
            if (screen.width <= 800) {
                window.location = "/MobileLogin.html";
            }
        </script>-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assessment</title>
            <g:if env="development"><asset:stylesheet src="assessment.css"/></g:if>
    </head>
    <body>
    <g:form class="simpleform" url="&#91;controller:'user',action:'register'&#93;">
  	<fieldset>
        <div class="pageTitle">
            <h1>User Register</h1>
        </div>
        <div class="backgrounds">
            <div class="labels">
                <label for="username">Username:</label>
                <br>
                <g:input type="text" id="username" name="username" value="${user?.username}" placeholder="" class="${hasErrors(bean:user,field:'username','errors')}"/>
                <br>
                <label for="password">Password:</label>
                <br>
                <g:input type="password" id="password" name="password" class="${hasErrors(bean:user,field:'password','errors')}" placeholder="Password" />
                <br>
                <label for="confirmPassword">Confirm Password:</label>
                <br>
                <g:input type="password" name="confirmPassword" class="${hasErrors(bean:user,field:'password','errors')}" placeholder="Confirm Password"/>
                <br>
                <label for="firstName">First Name:</label>
                <br>
                <g:input type="text" name="firstName" value="${user?.firstName}" class="${hasErrors(bean:user,field:'firstName','errors')}"placeholder="First Name"/>
                <br>
                <label for="lastName">Last Name:</label>
                <br>
                <g:input type="text" name="lastName" value="${user?.lastName}" class="${hasErrors(bean:user,field:'lastName','errors')}"placeholder="Last Name"/>
                <g:input type="button" class="button" value="Register"/>
                <g:input type="button" class="button" value="Cancel"/>
            </div>
        </div>
    </fieldset>
	</g:form>
    </body>
</html>
