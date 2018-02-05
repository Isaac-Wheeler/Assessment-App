<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:if test="${session?.teacher?.admin == false}">
    ${response.sendRedirect("/")}
  </g:if>
  <g:if test="${session.teacher == null}">
    ${response.sendRedirect("/")}
  </g:if>
	<div class="pageTitle">
    		<h1>Edit Indicator</h1>
      	<p>Complete the form below to edit an Indicator</p>
    </div>
    <g:form class="simpleform" url="editIndicator">

    		<div class="backgrounds">
            <div class="labels">
                <label for="indicatorName">Indicator Title:</label>
                <br>
                <g:textField type="text" id="indicatorName" name="indicatorName" value="${indicator?.indicatorName}" placeholder="Title"/>
                <g:hasErrors bean="${indicator}" field="indicatorName">
                  <div class="errors">
                      <g:renderErrors bean="${indicator}" field="indicatorName"/>
                  </div>
                </g:hasErrors>
                <br>
                <label for="indicatorDesc">Indicator Description:</label>
                <br>
                <g:textArea id="indicatorDescription" name="indicatorDescription" value="${indicator?.indicatorDescription}" rows="10" cols="50"/>
                <g:hasErrors bean="${indicator}" field="indicatorDescription">
                  <div class="errors">
                      <g:renderErrors bean="${indicator}" field="indicatorDescription"/>
                  </div>
                </g:hasErrors>
                <g:hiddenField name="id" value="${indicator?.id}" />
                <label for="classes">Choose The Class: hold the Ctrl(windows)/Command(Mac) button to select multiple courses.</label>
                <br>
                <g:select name="classId" from="${Classes}" id="classes" value="${indicator?.classes}" style="width:20%;" optionKey="id" optionValue="title" multiple="multiple" />
                <p>Hold down the Ctrl (windows) / Command (Mac) button to select multiple options.</p>
                <br>
                <g:submitButton class="button" name="submitButton" value="Edit Indicator" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
