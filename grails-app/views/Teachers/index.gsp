<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <g:each in="${Teachers}" var="Teachers" status="i">
            	<div class="listings">
                <h1>${i+1}. ${Teachers.lastName}, ${Teachers.firstName}</h1>
                <p>Registered: ${Teachers.dateCreated}</p>
        		</div>
        		<br/>
        </g:each>
    </body>
</html>
