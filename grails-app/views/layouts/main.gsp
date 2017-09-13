<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            if (screen.width <= 800) {
                window.location = "/MobileLogin.html";
            }
        </script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assesment</title>
            <g:if env="development"><asset:stylesheet src="style.css"/></g:if>
    </head>
<body>
	<!-- username | logout link -->
    <g:if test="${session?.user}">
		<div id="login">
        	${session?.user?.firstName} ${session?.user?.lastName} |
        	<g:link controller="user" action="logout">Logout</g:link>
        </div>
    </g:if>
	<!-- END #login -->
    <g:layoutBody/>
</body>
</html>
