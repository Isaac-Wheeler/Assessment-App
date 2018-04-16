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
  </head>
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
        <div class="column">
          <g:select name="academicYear1" from="${Settings}" value="${year}" style="width:20%;" optionKey="id" optionValue="academicYear"/>
          <g:if test="${selectLeft == false}">
            <g:render template="sidebarCompare"/>
          </g:if>
          <g:else>
            <g:render template="mainForm" model="[assessment_documents:AD1, measureID:AD1.measure.id, show:true]"/>
          </g:else>
        </div>
        <div class="column">
            <g:render template="mainForm" model="[assessment_documents:AD2, measureID:AD2.measure.id, show:true]"/>
        </div>
      </div>
    </body>
</html>
