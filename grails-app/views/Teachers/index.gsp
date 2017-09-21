<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
        <g:each in="${Users}" var="u" status="i">
            	<div class="listings">
                <h1>${i+1}. ${u.lastName}, ${u.firstName}</h1>
                <p>Registered: ${u.dateCreated}</p>
        		</div>
        		<br/>
        </g:each>
        ......
    </body>
</html>
