<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
	<div class="pageTitle">
    		<h1>Create Outcome</h1>
      	<p>Complete the form below to create an Outcome</p>
    </div>
    <g:form class="simpleform" url="createOutcome">
   			 <g:hasErrors bean="${teacher}">
      			<div class="errors">
        				<g:renderErrors bean="${teacher}"/>
      			</div>
    			</g:hasErrors>
    		<div class="backgrounds">
            <div class="labels">
                <label for="outcomeTitle">Outcome Title:</label>
                <br>
                <g:textField type="text" id="outcome_category" name="outcome_category" value="${outcome?.outcome_category}" placeholder="Title" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
                <br>
                <label for="outcomeDesc">Outcome Description:</label>
                <br>
                <g:textArea id="outcome_category_description" name="outcome_category_description" value="${outcome?.outcome_category_description}" rows="10" cols="50"/>
                <g:submitButton class="button" name="submitButton" value="Create Outcome" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
