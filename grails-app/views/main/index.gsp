<!DOCTYPE html>
<html>
    <head>
      <link rel='shortcut icon' type='image/x-icon' href='/favicon.ico' />
      <link rel="shortcut icon" href="assets" type="image/x-icon" />
    	<!--<script type="text/javascript">
            if (screen.width <= 800) {
                window.location = "/MobileLogin.html";
            }
        </script>-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assesment</title>
            <asset:stylesheet src="style.css"/>
    </head>
    <body>
      <g:if test="${session?.teacher}">
      <!-- put homepage code here -->
        <g:if test="${session?.teacher.admin == true}">
        <p> is admin </p>
        </g:if>
      </g:if>
      <g:else>
        <div class="welcomeMessage">
            <h1>Welcome</h1>
            <p class="info">
		            <p>York College prepares its graduates for productive and purposeful lives. As a diverse community of educators and learners, we provide a high-quality, private education that emphasizes personal development, close faculty/student mentoring relationships, and real-world experiences. We partner with our community for the benefit of both our students and the broader region. We strive to make this world-class, private education financially accessible.</p><%--York college mission statement displayed on the login page--%>
     		     </p>
        </div>
        <div class="loginBox">
            <div class="banner">
                <p>Login</p>
            </div><%--Banner above login box--%>
            <g:form class="simpleform" url="login"><%--Login inputs--%>
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="Password">
                <br>
                <small>
                	<g:if test="${flash.success}">
    					<div class="alert alert-success" style="display: block">${flash.success}</div><%--Correct login message--%>
					</g:if>
					<g:if test="${flash.error}">
   					 	<div class="alert alert-error" style="display: block">${flash.error}</div><%--Incorrect login error--%>
					</g:if>
				</small>
                <br>
                <g:submitButton class="button" name="submitButton" value="Login" /><%--Login button--%>
            </g:form>
        </div>
        </g:else>
    </body>
</html>
