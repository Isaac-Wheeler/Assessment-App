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
                <label for="indicatorTitle">Indicator Title:</label>
                <br>
                <g:textField type="text" id="indicatorTitle" name="indicatorTitle" value="${indicator?.title}" placeholder="Title" class="${hasErrors(bean:indicator,field:'indicatorTitle','errors')}"/>
                <br>
                <label for="indicatorDesc">Indicator Description:</label>
                <br>
                <g:textArea id="indicatorDesc" name="indicatorDesc" value="${indicator?.desc}" rows="10" cols="50"/>
                <g:submitButton class="button" name="submitButton" value="Create Outcome" />
                <g:submitButton class="button" name="cancelButton" value="Cancel" />
            </div>
        </div>
    </body>
</html>
