<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="adminProfileLayout"/>
        <asset:stylesheet src="adminProfile.css"/>
    </head>
    <body>
    		<div class="newTab">
          <p>Settings</p>
        </div>
        <div class="mainArea">
          <g:hasErrors bean="${c}">
            <div class="errors">
              <g:renderErrors bean="${c}"/>
            </div>
          </g:hasErrors>
          <g:form class="simpleform" url="index">
            <g:textField type="text" id="academicYear"  name="title"  value="${c?.academicYear}" placeholder="Academic Year" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
            <g:hiddenField name="type" value="new" />
            <button id="classButton" class="add">Set</button>
          </g:form>
          <g:each in="${Settings}" var="s">
            Current Academic Year: ${s.academicYear}
          </g:each>
        </div>
    </body>
</html>
