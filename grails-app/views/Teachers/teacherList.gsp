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
            <title>Data Assesment</title>
            <g:if env="development"><asset:stylesheet src="teachersList.css"/></g:if>
    </head>
    <body>
        <h2>Registered Teachers</h2>
        <div class="mainArea">
            <g:each in="${teachers}" var="teacher" status="i">
                <h1>${i+1}. ${teacher.lastName}, ${teacher.firstName}</h1>
                    <p>Registered: ${person.registerDate}</p>
                <br/>
            </g:each>
        </div>
    </body>
</html>
