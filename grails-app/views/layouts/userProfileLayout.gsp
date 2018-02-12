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
            <g:layoutHead/>
    </head>
    <body>
      <g:render template="/templates/securityNotAdmin"/>
        <div class=leftPanel>
            <g:link controller="user" action="editFaculty" params="[teacher:session?.teacher?.id]">
            <g:if test="${session.teacher != null}">
              <div class="profileInfo">
                  <g:if test="${session.teacher.profilePic == null}">
                    <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
                  </g:if>
                  <g:else>

                </g:else>
                  <br>
                  <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>
              </div>
            </g:if>
            </g:link>
            <g:link controller="admin">
            		<button class="button">Home</button>
            </g:link>
            <br>
            <g:link controller="outcomes" action="viewOutcomesUser">
            		<button class="button button2">Outcomes</button>
            </g:link>
            <br>
            <g:link controller="measures" action="viewMeasuresUser" >
            		<button class="button button2">Measures</button></g:link>
            <br>
            <g:link controller="assessments">
            		<button class="button button2">Assessments</button>
            </g:link>
            <br>
            <g:link controller="generate">
              <button class="button button2">Generate PDF</button>
            </g:link>
            <br>
            <g:link controller="user" action="logout">
                <button class="button button2">Log Out</button>
            </g:link>
        </div>
        <div class="rightPanel">
            	<g:layoutBody/>
        </div>
    </body>
</html>
