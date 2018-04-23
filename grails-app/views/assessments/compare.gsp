<!DOCTYPE html>
<html>
  <head>
    <link rel="shortcut icon" href="${createLinkTo(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
    <%--<script type="text/javascript">
              if (screen.width <= 800) {
                  window.location = "/MobileLogin.html";
              }
          </script>--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="tabIcon" href="palm.ico" />
    <title>Data Assesment</title>
    <asset:stylesheet src="fileDisplay.css"/>
    <asset:javascript src="editAssessment.js"/>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </head><%--Basic head including most style sheets--%>
  <body>
    <style>
      * {
            box-sizing: border-box;
      }

        /* Create two equal columns that floats next to each other */
        .column {
            float: left;
            width: 50%;
            padding: 10px;
            height: 300px; /* Should be removed. Only for demonstration */
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }
      </style>
      <div class="row">
        <div class="column" >
          <g:form class="simpleform" url="compare">
            <i class="w3-xlarge"> <g:link controller="main" class="fa fa-home"  style="float: left; margin-top: 1%; margin-left: 1%; margin-right: 1%;"></g:link></i> <%--home button to get back to main home--%>
            <g:select name="academicYear" from="${Years}" value="${year}" style="width:35%;" optionKey="id" optionValue="academicYear" noSelection="['null':'All Year(s)']"/><%--selects year for which of the AD's you want to compare to--%>
            <g:hiddenField name="submitButton" value="yearSet" />
            <g:hiddenField name="AD2" value="${AD2.id}" />
            <button id="Button" class="add">Switch Year</button><%--Button to set compare year to--%>
          </g:form>
          <g:if test="${selectLeft == false}"> <%--determines if the user has selected the AD he wants to compare to--%>
            <g:render template="sidebarCompare" model="[AD2:AD2]"/>
          </g:if>
          <g:else>
            <g:render template="mainFormCompare" model="[assessment_documents:AD1, measureID:AD1.measure.id, show:true]"/>
          </g:else> <%--When selected gives un editable form to display the information--%>
        </div>
        <div class="column">
           <g:render template="mainFormCompare" model="[assessment_documents:AD2, measureID:AD2.measure.id, show:true]"/> <%--this is the right half of the page that displays the current year form--%>
        </div>
      </div>
    </body>
</html>
