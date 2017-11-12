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
    </head>
    <body>
      <g:if test="${session.teacher == null}">
        ${response.sendRedirect("/")}
      </g:if>
        <!-- right half of the page -->
          <div id="HTMLtoPDF">
          <g:each in="${Outcomes}" var="o">
            <p style="font-weight:bold; font-size:1.5em;">Outcome ${o.outcomeCategory}</p>
            <g:if test="${o.indicators != NULL}">
              <g:each in="${o.indicators}" var="i">
                <g:each var="c" in="${i.classes}">
                  <p>(${i.indicatorName}) - ${c.title}</p>
                  <g:each in="${i.measures}" var="m">
                    <g:set var="ad" value="${m.assessment_documents}"/>
                    <g:set var="totalprcentMet" value="${ad.meetsExpectations+ad.exceedsExpectations}"/>
                    <g:set var="totalprcentMetConf" value="${ad.exceedsExpectations/ad.numberOfStudents} "/>
                    <g:set var="targetGoal" value="${ad.targetGoal/ad.numberOfStudents}"/>
                    ${i.indicatorName}-${c.title}-${m.measureTitle}:
                    <g:if test="${totalprcentMet > targetGoal}">
                      <span style="background-color: #00FF00">Met Comfortably</span>
                    </g:if>
                    <g:elseif test="${totalPrcentMet == targetGoal}">
                      <span style="background-color: #FFFF00">Met</span>
                    </g:elseif>
                    <g:elseif test="${totalPrcentMet < targetGoal}">
                      <span style="background-color: #FF0000">Not Met</span>
                    </g:elseif>
                    (${totalprcentMet/ad.numberOfStudents * 100}%/${targetGoal * 100}%)
                    <br>${ad.requiredAction}<br>
                  </g:each>
                </g:each>
              </g:each>
            </g:if>
          </g:each>
          </div>
        <a href="#" onclick="HTMLtoPDF()">Download PDF</a>
    </body>
</html>
