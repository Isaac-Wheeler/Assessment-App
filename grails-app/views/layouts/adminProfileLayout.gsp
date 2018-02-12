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
            <g:layoutHead/>
    </head>
    <body>
      <g:render template="/templates/security"/>
        <div class=leftPanel>
            <div class="profileInfo">
              <g:if test="${session.teacher.profilePic == null}">
                <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
              </g:if>
              <g:else>

            </g:else>
                <br>
                <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>
            </div>
            <div class="changeYear">
              <g:form class="simpleform" controller="Main" action="changeYear">
                  <g:hiddenField name="location" value="${request.getRequestURI()}" />
                  <select name="setYear" onchange="submit()" id="setYear">
                    <g:loadSettings/>
                  </select>
              </g:form>
            </div>
          <div class="buttons">
            <g:link controller="admin">
            		<button class="button">Home</button>
            </g:link>
            <br>
            <g:link controller="teachers">
            		<button class="button button2">Faculty</button>
            </g:link>
            <br>
            <g:link controller="outcomes">
            		<button class="button button2">Outcomes</button>
            </g:link>
            <br>
            <g:link controller="courses">
            		<button class="button button2">Courses</button>
            </g:link>
            <br>
            <g:link controller="measures" action="viewMeasuresAdmin">
            		<button class="button button2">Measures</button>
            </g:link>
            <br>
            <g:link controller="assessments">
            		<button class="button button2">Assessments</button>
            </g:link>
            <br>
            <g:link controller="generate">
              <button class="button button2">Generate PDF</button>
            </g:link>
            <br>
            <g:link controller="settings">
              <button class="button button2">Settings</button>
            </g:link>
            <br>
            <g:link controller="user" action="logout">
                <button class="button button2">Log Out</button>
            </g:link>
          </div>
        </div>
        <div class="rightPanel">
        		<g:layoutBody/>
        </div>
    </body>
</html>
