<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
	<div class="pageTitle">
    		<h1>Edit Outcome</h1>
      	<p>Complete the form below to edit an Outcome</p>
    </div>
    <g:form class="simpleform" url="editOutcome">
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
                <g:hiddenField name="id" value="${id}" />
                <g:submitButton class="button" name="submitButton" value="Edit Outcome" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
