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
            <g:if env="development"><asset:stylesheet src="adminProfile.css"/></g:if>
    </head>
    <body>
        <div class=leftPanel>
            <div class="profileInfo">
                <img class="img-circle" src="blankPerson.jpg">
                <br>
                <p>D.Babcock<p>
            </div>
            <button class="button">Assessment Goals</button>
            <br>
            <button class="button button2">Completed Courses</button>
            <br>
            <button class="button button2">Teachers</button>
            <br>
            <button class="button button2">Log Out</button>
        </div>
        <div class="rightPanel">
            <div class="newTab">
                <p>Assessment Goals <button class="add">New <div class="plus"> &oplus; </div></button></p>
            </div>
        </div>
    </body>
</html>