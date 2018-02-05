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
    		<h1>Edit Outcome</h1>
      	<p>Complete the form below to edit an Outcome</p>
    </div>
    <g:form class="simpleform" url="editOutcome">
    		<div class="backgrounds">
            <div class="labels">
                <label for="outcomeTitle">Outcome Title:</label>
                <br>
                <g:textField type="text" id="outcomeCategory" name="outcomeCategory" maxlength="1" value="${outcome?.outcomeCategory}" placeholder="Title" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
                <g:hasErrors bean="${outcome}" field="outcomeCategory">
                  <div class="errors">
                      <g:renderErrors bean="${outcome}" field="outcomeCategory"/>
                  </div>
                </g:hasErrors>
                <br>
                <label for="outcomeDesc">Outcome Description:</label>
                <br>
                <g:textArea id="outcomeCategoryDescription" name="outcomeCategoryDescription" value="${outcome?.outcomeCategoryDescription}" rows="10" cols="50"/>
                <g:hasErrors bean="${outcome}" field="outcomeCategoryDescription">
                  <div class="errors">
                      <g:renderErrors bean="${outcome}" field="outcomeCategoryDescription"/>
                  </div>
                </g:hasErrors>
                <g:hiddenField name="id" value="${id}" />
                <g:submitButton class="button" name="submitButton" value="Edit Outcome" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
