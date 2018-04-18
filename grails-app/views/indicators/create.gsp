<!DOCTYPE html>
<html>
<head>
  <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
  <meta name="layout" content="dataInputLayout"/>
</head>
<body>
  <g:render template="/templates/security"/>
	<div class="pageTitle">
    		<h1>Create Indicator</h1>
      	<p>Complete the form below to create an Indicator</p>
    </div> <%--Basic Header above--%>
    <g:form class="simpleform" url="create">
    		<div class="backgrounds">
            <div class="labels"> <%--BAsic Form--%>
                <label for="indicatorTitle">Indicator Title:</label>
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
                <g:if test="${indicator?.outcomeId != null}">
                  <g:hiddenField name="outcomeId" value="${indicator?.outcome.id}"/>
                </g:if>
                <g:else>
                    <g:hiddenField name="outcomeId" value="${outcomeId}"/>
                </g:else>
                <label for="courses">Choose The Class: hold the Ctrl(windows)/Command(Mac) button to select multiple courses.</label> <%--Explination for selecting many courses--%>
                <br>
                <g:select name="classId" from="${Courses}" id="courses" value="${indicator?.courses}" style="width:20%;" optionKey="id" optionValue="title" multiple="multiple" />
                <p>Hold down the Ctrl (windows) / Command (Mac) button to select multiple options.</p>
                <br><%--Action/submit buttons below--%>
                <g:submitButton class="button" name="submitButton" value="Create" />
                <g:submitButton class="button" name="submitButton" value="Cancel" />
            </div>
        </div>
      </g:form>
    </body>
</html>
