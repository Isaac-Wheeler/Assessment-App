<!DOCTYPE html>
<html>
    <head>
      <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <!--<script type="text/javascript">
            if (screen.width <= 800) {
                window.location = "/MobileLogin.html";
            }
        </script>-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assesment</title>
            <asset:stylesheet src="fileDisplay.css"/>
            <asset:javascript src="jspdf.js"/>
            <asset:javascript src="jquery-2.1.3.js"/>
            <asset:javascript src="pdfFromHTML.js"/>
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
      <g:render template="/templates/securityNotAdmin"/>
      <i class="w3-xlarge"> <g:link controller="main" class="fa fa-home"  style="float: left; margin-left: 1%; margin-top: 1%;"></g:link></i>
      <br>
      <br>
      <g:form class="simpleform" url="index">
      <g:select name="academicYear" from="${Settings}" value="${year}" style="width:20%;" optionKey="id" optionValue="academicYear" noSelection="['null':'All Year(s)']"/>
      <button id="Button" class="add">Switch Year</button>
      <br>
      <g:select name="coursesSelect" from="${Courses}" value="${title}" style="width:20%;" optionKey="title" optionValue="title" noSelection="['null':'All Course(s)']"/>
      <button id="Button" class="add">Switch Course</button>
      </g:form>
      <br>
        <g:if test="${SelectValue == 2 }">
          <g:render template="/templates/HTMLtoPDFOutcomes"/> <%-- render for outcomes --%>
        </g:if>
        <g:if test="${SelectValue == 1 }">
          <g:render template="/templates/HTMLtoPDFCourses"/> <%-- render for courses --%>
        </g:if>
    </body>
</html>
