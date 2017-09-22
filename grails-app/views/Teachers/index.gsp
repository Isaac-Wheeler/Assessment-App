<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Teachers
                  <g:link controller="user" action="register">
                    <button class="add">Register<div class="plus"> &oplus;</div></button>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${User}" var="u" status="i">
            			<div class="listings">
                			<h1>${u.lastName}, ${u.firstName}</h1>
                			<p>Username: ${u.username}</p>
                			<g:if test="${true == u.admin}">
                					<p>Admin</p>
						</g:if>
						<p>Registered: ${u.dateCreated}</p>
						<g:link controller="user" action="edit">
							<button class="add">Edit</button>
						</g:link>
						<g:link controller="user" action="delete">
							<button class="add">Delete</button>
						</g:link>
        				</div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
