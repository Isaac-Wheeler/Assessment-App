<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
                <p>Faculty
                  <g:link controller="user" action="register">
                    <button class="add">Register<div class="plus"> &oplus;</div></button><%--Header with button option for registering--%>
                </g:link>
                </p>
            </div>
            <div class="mainArea">
            		<g:each in="${Teacher}" var="u">
            			<div class="listings"><%--display cards of each teacher with his/her info--%>
                			<h1>${u.lastName}, ${u.firstName}</h1>
                			<p>Username: ${u.username}</p>
                			<g:if test="${true == u.admin}">
                				<p>Admin</p>
						          </g:if>
						          <p>Registered: ${u.dateCreated}</p>
                      <p> Last login: ${u.lastLogin} </p><%--Basic info displayed--%>
                      <g:if test="${u.urlSignup == true}"><%--Creating sign up link or display of having the URL sign up--%>
                       <p>Url Signup Link: </p>
                       <g:createLink controller="User" absolute="true" action="urlSignup" params="${[teacher:u.id]}"/>
                      </g:if>
                      <br>
                      <br>
						          <g:link controller="user" action="edit" params="[teacher:u.id]">
							             <button class="add">Edit</button></g:link><%--Edit Button--%>
						          <g:link controller="user" action="delete" params="[teacher:u.id]" onclick="return confirm('Are you sure you want to delete this teacher? teacher: $u.firstName $u.lastName')">
							             <button class="add">Delete</button><%--Delete Button--%>
						          </g:link>
        				   </div>
        				<br/>
        			</g:each>
            </div>
        </div>
    </body>
</html>
