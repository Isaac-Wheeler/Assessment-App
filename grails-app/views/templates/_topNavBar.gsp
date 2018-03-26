<g:if test="${session.teacher.admin}">
  <div class="topNavBar">
    <g:link controller="admin">
      <button class="navButton">Home</button>
    </g:link>
    <g:link controller="teachers">
      <button class="navButton">Faculty</button>
    </g:link>
    <g:link controller="outcomes">
      <button class="navButton">Outcomes</button>
    </g:link>
    <g:link controller="courses">
      <button class="navButton">Courses</button>
    </g:link>
    <g:link controller="measures">
      <button class="navButton">Measures</button>
    </g:link>
    <g:link controller="assessments">
      <button class="navButton">Assessments</button>
    </g:link>
    <g:link controller="generate">
      <button class="navButton">Generate PDF</button>
    </g:link>
    <g:link controller="settings">
      <button class="navButton">Settings</button>
    </g:link>
    <g:link controller="user" action="logout">
      <button class="navButton">Log Out</button>
    </g:link>
  </div>
</g:if>
<g:else>
  <div class="topNavBar">
    <g:link controller="admin">
      <button class="navButton">Home</button>
    </g:link>
    <g:link controller="outcomes">
      <button class="navButton">Outcomes</button>
    </g:link>
    <g:link controller="measures">
      <button class="navButton">Measures</button>
    </g:link>
    <g:link controller="assessments">
      <button class="navButton">Assessments</button>
    </g:link>
    <g:link controller="generate">
      <button class="navButton">Generate PDF</button>
    </g:link>
    <g:link controller="user" action="logout">
      <button class="navButton">Log Out</button>
    </g:link>
  </div>
</g:else>
${raw(body())}
