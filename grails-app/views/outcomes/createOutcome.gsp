<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:render template="/templates/security"/>
	<div class="pageTitle">
    		<h1>Create Outcome</h1>
      	<p>Complete the form below to create an Outcome</p>
    </div>
    <g:form class="simpleform" url="createOutcome">
    		<div class="backgrounds">
            <div class="labels">
                <label for="outcomeTitle">Outcome Title:</label>
                <br>
                <g:textField type="text" id="outcomeCategory" maxlength="1" name="outcomeCategory" value="${outcome?.outcomeCategory}" placeholder="Title" class="${hasErrors(bean:outcome,field:'outcomeCategory','errors')}"/>
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
                <g:submitButton class="button" name="submitButton" value="Create Outcome" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
