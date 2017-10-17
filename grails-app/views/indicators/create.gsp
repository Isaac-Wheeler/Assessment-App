<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
	<div class="pageTitle">
    		<h1>Create Indicator</h1>
      	<p>Complete the form below to create an Indicator</p>
    </div>
    <g:form class="simpleform" url="create">
   			 <g:hasErrors bean="${indicator}">
      			<div class="errors">
        				<g:renderErrors bean="${indicator}"/>
      			</div>
    			</g:hasErrors>
    		<div class="backgrounds">
            <div class="labels">
                <label for="indicatorTitle">Indicator Title:</label>
                <br>
                <g:textField type="text" id="indicatorName" name="indicatorName" value="${indicator?.indicatorName}" placeholder="Title" class="${hasErrors(bean:indicator,field:'indicatorTitle','errors')}"/>
                <br>
                <label for="indicatorDesc">Indicator Description:</label>
                <br>
                <g:textArea id="indicatorDescription" name="indicatorDescription" value="${indicator?.indicatorDescription}" rows="10" cols="50"/>

                <g:if test="${indicator?.outcomeId != null}">
                  <g:hiddenField name="outcomeId" value="${indicator?.outcome.id}"/>
                </g:if>
                <g:else>
                    <g:hiddenField name="outcomeId" value="${outcomeId}"/>
                </g:else>
                <label for="classes">Choose The Class:</label>
                <br>
                <g:select name="classId" from="${Classes}" id="classes" value="" style="width:20%;" optionKey="id" optionValue="title" />
                <br>
                <g:submitButton class="button" name="submitButton" value="Create" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
