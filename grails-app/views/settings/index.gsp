<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
          <p>Settings</p>
        </div><%--Header Display--%>
        <div class="mainArea">
          <g:hasErrors bean="${c}">
            <div class="errors">
              <g:renderErrors bean="${c}"/>
            </div>
          </g:hasErrors>
          <g:form class="simpleform" url="index">
            <g:select id="academicYear"  name="academicYear" from="${yearList}"  value="${year}"/>
            <button id="classButton" class="add">Set</button><%--Dispaly for setting the year for the system--%>
          </g:form>
            Current Academic Year: ${year} <%--Displaying the currently set year--%>
          </br>
          </br>
            Past Years: <%--List of past years--%>
          </br>
              <g:each in="${Years}">
              <g:if test="${year != it.academicYear}">
                ${it}
              </br>
              </g:if>
              </g:each>
        </div>
    </body>
</html>
