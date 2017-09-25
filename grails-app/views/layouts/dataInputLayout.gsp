<!DOCTYPE html>
<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assessment</title>
            <asset:stylesheet src="assessment.css"/>
            <g:layoutHead/>
</head>
<body>
<g:form class="simpleform" url="/register">
    <g:hasErrors bean="${teacher}">
      <div class="errors">
        <g:renderErrors bean="${teacher}"/>
      </div>
    </g:hasErrors>
    <g:layoutBody/>
</g:form>
</body>
</html>
