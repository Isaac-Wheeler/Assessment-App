<!-- right half of the page -->
  <div id="HTMLtoPDF" style="margin-left: 2%;">
  <g:each in="${Outcomes}" var="o"><%--breakdown from outcomes--%>
    <p style="font-weight:bold; font-size:1.5em;">Outcome ${o.outcomeCategory}</p>
    <g:if test="${o.indicators != NULL}">
      <g:each in="${o.indicators}" var="i">
        <g:each var="c" in="${i.courses}">
          <p>(${i.indicatorName}) - ${c.title}</p>
          <g:each in="${i.measures}" var="m">
            <g:set var="ad" value="${m.assessment_documents}"/>
            <g:if test="${ad != null}">
              ${i.indicatorName}-${c.title}-${m.measureTitle}:
              <g:if test="${ad.meetsExpectations == null || ad.exceedsExpectations == null || ad.targetGoal == null || ad.needsImprovement == null}">
                <br>
                <span style="background-color: #000000; color:white;">Not Assessed</span>
                <br>
              </g:if>
              <g:else>
                <g:set var="totalMet" value="${ad.meetsExpectations+ad.exceedsExpectations}"/><%--used to determine percents--%>
                <g:set var="totalPrcentMet" value="${totalMet/ad.numberOfStudents * 100} "/>
                <g:set var="targetGoal" value="${ad.targetGoal}"/>
                <g:if test="${totalPrcentMet > targetGoal + 5}">
                  <p style="background-color: #00FF00">Met Comfortably</p>
                </g:if><%--used to determine color--%>
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
            </g:if>
            <g:else>
              <p>Assessment Documentation not created yet</p>
            </g:else>
          </g:each>
        </g:each>
      </g:each>
    </g:if>
  </g:each>
  </div>
<a href="#" onclick="HTMLtoPDF()" style="margin-left: 2%;">Download PDF</a>
