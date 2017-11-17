<!DOCTYPE html>
<html>
    <head>
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
      <g:if test="${session.teacher == null}">
        ${response.sendRedirect("/")}
      </g:if>
      <i class="w3-xlarge"> <g:link controller="main" class="fa fa-home"  style="float: left; margin-left: 1%; margin-top: 1%;"></g:link></i>
      <br>
      <g:select name="academicYear" from="${Settings}" value="" style="width:20%;" optionKey="id" optionValue="academicYear" />
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
                    <g:if test="${it == null || ad.meetsExpectations == null || !ad.exceedsExpectations || !ad.targetGoal || !ad.needsImprovement}">
                      <br>
                      <span style="background-color: #000000; color:white;">Not Assessed</span>
                      <br>
                    </g:if>
                    <g:else>
                      <g:set var="totalMet" value="${ad.meetsExpectations+ad.exceedsExpectations}"/>
                      <g:set var="totalprcentMet" value="${totalMet/ad.numberOfStudents} "/>
                      <g:set var="targetGoal" value="${ad.targetGoal}"/>
                      <g:if test="${totalprcentMet > targetGoal + 5}">
                        <span style="background-color: #00FF00">Met Comfortably</span>
                      </g:if>
                      <g:elseif test="${totalPrcentMet >= targetGoal}">
                        <span style="background-color: #FFFF00">Met</span>
                      </g:elseif>
                      <g:elseif test="${totalPrcentMet >= targetGoal - 5}">
                        <span style="background-color: #FFA500">Almost Met</span>
                      </g:elseif>
                      <g:elseif test="${totalPrcentMet < targetGoal - 5}">
                        <span style="background-color: #FF0000">Not Met</span>
                      </g:elseif>
                      (${totalprcentMet/ad.numberOfStudents * 100}%/${targetGoal}%)
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
