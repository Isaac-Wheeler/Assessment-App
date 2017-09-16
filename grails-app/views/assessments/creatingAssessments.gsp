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
            <title>Data Assessment</title>
            <g:if env="development"><asset:stylesheet src="assessment.css"/></g:if>
    </head>
    <body>
        <div class="pageTitle">
            <h1>Create Assessment</h1>
        </div>
        <div class="backgrounds">
            <div class="labels">
                <label for="assessmentTitleInput">Assessment Title:</label>
                <br>
                <input type="text" id="assessmentTitleInput" name="assessmentTitleInput" value="" placeholder="Title">
                <br>
                <label for="assessmentDescInput">Assessment Description:</label>
                <br>
                <textarea id="assessmentDescInput" name="assessmentDescInput" rows="10" cols="50"></textarea>
                <br>
                <label for="courseInput">Course Title:</label>
                <br>
                <input type="text" id="courseInput" name="courseInput" value="" placeholder="Title">
                <br>
                <label for="workUsedInput">Work Used:</label>
                <br>
                <input type="file" id="workUsedInput">
                <br>
                <label for="targetGoalInput">Target Goal:</label>
                <br>
                <input type="text" id="targetGoalInput" name="targetGoalInput" value="" placeholder="Goal">
                <br>
                <label for="needsImprovmentInput">Needs Improvment:</label>
                <br>
                <input type="text" id="needsImprovmentInput" name="needsImprovmentInput" value="0">
                <br>
                <label for="meetsExpectationsInput">Meets Expectations:</label>
                <br>
                <input type="text" id="meetsExpectationsInput" name="meetsExpectationsInput" value="0">
                <br>
                <label for="exceedsExpectationsInput">Exceeds Expectations:</label>
                <br>
                <input type="text" id="exceedsExpectationsInput" name="exceedsExpectationsInput" value="0">
                <br>
                <label for="summaryObservationsInput">Summary/Observation:</label>
                <br>
                <textarea id="summaryObservationsInput" name="summaryObservationsInput" rows="10" cols="50"></textarea>
                <br>
                <input type="button" class="button" value="Submit">
                <input type="button" class="button" value="Cancel">
            </div>
        </div>
    </body>
</html>
