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
    <div class="backgrounds">
            <div class="labels">
                <label for="outcomeTitle">Outcome Title:</label>
                <br>
                <g:textField type="text" id="outcomeTitle" name="outcomeTitle" value="" placeholder="Title" class="${hasErrors(bean:outcome,field:'outcomeTitle','errors')}"/>
                <br>
                <label for="outcomeDesc">Outcome Description:</label>
                <br>
                <g:textArea id="outcomeDesc" name="outcomeDesc" rows="10" cols="50"/>
                <g:submitButton class="button" name="submitButton" value="Create Outcome" />
                <g:submitButton class="button" name="cancelButton" value="Cancel" />
            </div>
        </div>
    </body>
</html>