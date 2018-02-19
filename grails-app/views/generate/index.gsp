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
      <g:select name="academicYear" from="${Settings}" value="${year}" style="width:20%;" optionKey="id" optionValue="academicYear" noSelection="['':'All Year(s)']"/>
      <button id="Button" class="add">Switch Year</button>
      <br>
      <%--<g:select name="classesSelect" from="${Settings}" value="${class}" style="width:20%;" optionKey="id" optionValue="classes" noSelection="['':'All Course(s)']"/> />--%>
      <button id="Button" class="add">Switch Class</button>
      </g:form>
      <br>
        <!-- right half of the page -->
          <div id="HTMLtoPDF" style="margin-left: 2%;">
          <g:each in="${Outcomes}" var="o">
            <p style="font-weight:bold; font-size:1.5em;">Outcome ${o.outcomeCategory}</p>
            <g:if test="${o.indicators != NULL}">
              <g:each in="${o.indicators}" var="i">
                <g:each var="c" in="${i.classes}">
                  <p>(${i.indicatorName}) - ${c.title}</p>
                  <g:each in="${i.measures}" var="m">
                    <g:set var="ad" value="${m.assessment_documents}"/>
                    ${i.indicatorName}-${c.title}-${m.measureTitle}:
                    <g:if test="${ad.meetsExpectations == null || ad.exceedsExpectations == null || ad.targetGoal == null || ad.needsImprovement == null}">
                      <br>
                      <span style="background-color: #000000; color:white;">Not Assessed</span>
                      <br>
                    </g:if>
                    <g:else>
                      <g:set var="totalMet" value="${ad.meetsExpectations+ad.exceedsExpectations}"/>
                      <g:set var="totalPrcentMet" value="${totalMet/ad.numberOfStudents * 100} "/>
                      <g:set var="targetGoal" value="${ad.targetGoal}"/>
                      <g:if test="${totalPrcentMet > targetGoal + 5}">
                        <p style="background-color: #00FF00">Met Comfortably</p>
                      </g:if>
                      <g:elseif test="${totalPrcentMet >= targetGoal}">
                        <p style="background-color: #FFFF00;"> Met </p>
                      </g:elseif>
                      <g:elseif test="${totalPrcentMet >= targetGoal - 5}">
                        <p style="background-color: #FFA500">Almost Met</p>
                      </g:elseif>
                      <g:elseif test="${totalPrcentMet < targetGoal - 5}">
                        <p style="background-color: #FF0000">Not Met</p>
                      </g:elseif>
                      (${totalPrcentMet}% / ${targetGoal} %)
                      <br>
                      ${ad.requiredAction}
                      <br>
                    </g:else>
                  </g:each>
                </g:each>
              </g:each>
            </g:if>
          </g:each>
          </div>
        <a href="#" onclick="HTMLtoPDF()" style="margin-left: 2%;">Download PDF</a>
    </body>
</html>
