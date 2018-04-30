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
    <body><%--Template that contains left half of main pages for admins--%>
      <g:render template="/templates/security"/>
        <div class=leftPanel>
          <g:if test="${session.teacher != null}">
          <g:render template="/templates/profileInfo"/> <%--Displays name--%>
          </g:if>
            <div class="changeYear"><%--Allows for changing of year drop down--%>
              <g:form class="simpleform" controller="Main" action="changeYear">
                  <g:hiddenField name="location" value="${request.getRequestURI()}" />
                  <select name="setYear" onchange="submit()" id="setYear">
                    <g:loadSettings/>
                  </select>
              </g:form>
            </div>
          <div class="buttons"> <%--buttons displayed on left under name--%>
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
        <div class="rightPanel"><%--Right panel intergection--%>
        		<g:layoutBody/>
            <div> <%-- get rid of this div--%>
              <script type="text/javascript">
                function display(){
                  var div = document.getElementById("temp");
                  if (div.style.display == 'none') {
                    div.style.display = 'block';
                  }
                  else {
                    div.style.display = 'none';
                  }
                }
              </script>
              <style type="text/css">
                .temp{
                  display: none;
                }
              </style>
            <button type="button" onclick="display()">Suggestions</button>
            <div id="temp" class="temp">
              <iframe src="https://docs.google.com/forms/d/e/1FAIpQLScsLJsl51BMK2BMBV3wjQgL0MhGHm-QAoWW0-RHVm1YNsM_uQ/viewform?embedded=true" width="80%" height="500" frameborder="5" marginheight="0" marginwidth="0">Loading...</iframe>
            </div><%--Form fo suggestions REMOVE--%>
          </div>
    </body>
</html>
