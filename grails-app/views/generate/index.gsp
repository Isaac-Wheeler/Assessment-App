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
            <p>Outcome ${o.outcomeCategory}</p>
            <g:if test="${o.indicators != NULL}">
              <g:each in="${o.indicators}" var="i">
                <g:each var="c" in="${i.classes}">
                  <p>${o.outcomeCategory}.${i.indicatorName}-${c.title}</p>
                  <g:each in="${i.measures}" var="m">
                    <g:set var="ad" value="${m.assessment_documents}"/>
                    <g:set var="totalprcentMet" value="${ad.meetsExpectations} / ${ad.numberOfStudents} * 100"/>
                    <g:set var="totalprcentMetConf" value="${ad.exceedsExpectations} / ${ad.numberOfStudents} * 100"/>
                    <g:set var="targetGoal" value="${ad.targetGoal}"/>
                    <p>${o.outcomeCategory}${i.indicatorName}-${c.title}-${m.measureTitle}</p>
                    <g:if test="${totalprcentMet > targetGoal}">
                      <p>Met</p>
                    </g:if>
                    <g:elseif test="${totalPrcentMet < totalprcentMetConf}">
                      <p>Met comfortably</p>
                    </g:elseif>
                    <p>${totalprcentMet}/${targetGoal}%</p>
                  </g:each>
                </g:each>
              </g:each>
            </g:if>
          </g:each>
        </div>
        <a href="#" onclick="HTMLtoPDF()">Download PDF</a>
    </body>
</html>
