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
      <g:if test="${session.teacher == null}">
        ${response.sendRedirect("/")}
      </g:if>
        <div class=leftPanel>
            <g:link controller="user" action="editFaculty" params="[teacher:session?.teacher?.id]">
             <g:render template="/templates/profileInfo"/><%--display name and user info--%>
            </g:link><%--left column navigation buttons under name--%>
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
            	<g:layoutBody/><%--body interjection--%>
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
              </div>
            </div>
        </div>
    </body>
</html>
