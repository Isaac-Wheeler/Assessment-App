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
            <asset:stylesheet src="style.css"/>
    </head>
<body>
	<!-- username | logout link -->
    <g:if test="${session?.teacher}">
		<div id="login">
        	${session?.teacher?.firstName} ${session?.teacher?.lastName} |
        	<g:link controller="user" action="logout">Logout</g:link>
        </div>
    </g:if>
	<!-- END #login -->
    <g:layoutBody/>
</body>
</html>
