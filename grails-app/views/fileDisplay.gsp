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
            <meta name="layout" content="dataInputLayout"/>
    </head>
    <body>
        <div class="sidebar">
            <!-- the slider switch bar at the top's left label-->
            <!-- the slider switch bar at the top-->
            <label class="switch">
                <input type="checkbox"><span class="slider round"></span>
            </label>            <!-- the slider switch bar at the top's right label-->
            <div class="fileFolders">
                <label class="folder">
                    <div class="Outcomes">
                        <input type="checkbox" id="btnControl"/><i class="fa fa-chevron-right" style="font-size:24px"></i>
                        <label class="btn" for="btnControl"></label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Outcome: A
                    </div>
                    <div class="Classes">
                    </div>
                </label>
            </div>
        </div>
        <!-- right half of the page -->
        <div class="main">
            <div class="info">
                <h1>Edit Assessment</h1>
                <label for="Title">Title:</label>
                <br>
                <input type="text" id="outcomeTitle" name="outcomeTitle" width="100px" placeholder="Title" class="shortText">
                <br>
                <label for="Desc">Description:</label>
                <br>
                <g:textArea id="Desc" name="Desc" rows="10" cols="100" resize="none"></textarea>
                <br>
                <label for="targetGoal">Target Goal:</label>
                <label for="belowExpectation" class="labelEx">Below Expectation:</label>
                <label for="meetsExpectation" class="labelEx">Meets Expectation:</label>
                <label for="exceedsExpectation" class="labelEx">Exceeds Expectation:</label>
                <br>
                <form>
                <input type="text" id="targetGoal" name="targetGoal" placeholder="____" class="targetGoal">
                <input type=button value="+" class="plus">
                <input type="text" id="belowExpectation" name="belowExpectation" value="0" class="oneChar">
                <input type=button value="-" >
                </form>
                <form>
                <input type=button value="+" class="plus">
                <input type="text" id="meetsExpectation" name="meetsExpectation" value="0" class="oneChar">
                <input type=button value="-">
                </form>
                <form>
                <input type=button value="+" class="plus">
                <input type="text" id="exceedsExpectation" name="exceedsExpectation" value="0" class="oneChar">
                <input type=button value="-">
                </form>
                <br>
                <label for="comment">Comment:</label>
                <br>
                <textArea id="comment" name="comment" rows="10" cols="100" resize="none"></textarea>
                <br>
                <label for="observations">Observations:</label>
                <br>
                <textArea id="observation" name="observation" rows="10" cols="100" resize="none"></textarea>
                <br>
            </div>
            <!--<g:submitButton class="button" name="submitButton" value="Create Outcome" />
            <g:submitButton class="button" name="cancelButton" value="Cancel" />-->
        </div>
    </body>
    <script>
    		var btn = document.querySelector('input');
    		var text = document.querySelector('input');

		btn.addEventListener('click', updateBtn);

		function updateBtn() {
			if(btn.value ="+")
				{btn.value = btn.value+1;}
			if(btn.value ="-")
				{btn.value = btn.value-1;}
  		}
    </script>
</html>
