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
      <g:if test="${session?.teacher?.admin == false}">
        ${response.sendRedirect("/")}
      </g:if>
        <div class=leftPanel>
            <div class="profileInfo">
                <g:img class="img-circle" dir="images" file="blankPerson.jpg"/>
                <br>
                <p>${session?.teacher?.firstName} ${session?.teacher?.lastName}<p>
            </div>
            <g:link controller="admin">
            		<button class="button">Home</button>
            </g:link>
            <br>
            <g:link controller="admin" action="outcomes">
            		<button class="button button2">Outcomes</button>
            </g:link>
            <br>
            <g:link controller="admin" action="indicators">
            		<button class="button button2">Indicators</button>
            </g:link>
            <br>
            <g:link controller="admin" action="currentAssessments">
            		<button class="button button2">Assessments</button>
            </g:link>
            <br>
            <g:link controller="admin" action="completedAssessments">
            		<button class="button button2">Completed Assessments</button>
            </g:link>
            <br>
            <g:link controller="teachers">
            		<button class="button button2">Teachers</button>
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
