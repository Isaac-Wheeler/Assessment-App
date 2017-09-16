<!DOCTYPE html>
<html>
    <head>
        <script type="text/javascript">
            if (screen.width <= 800) {
                window.location = "/MobileLogin.html";
            }
        </script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="tabIcon" href="palm.ico" />
            <title>Data Assesment</title>
            <g:if env="development"><asset:stylesheet src="style.css"/></g:if>
    </head>
    <body>
        <div class="welcomeMessage">
            <h1>Welcome</h1>
            <p>Our mission is to be the quality leader, service leader, technology leader and value-added leader in all areas of reprographics, especially large format presentation graphics. We will provide a variety of solutions to the design community and the corporate world for the imaging and dissemination of their designs and documents. We will support our customers by providing the most diverse choice of quality products and services that they require to be the leaders in their field, to improve their performance, be more efficient and enhance their competitive position. We will endeavor to serve our customers in such a manner that they will be totally satisfied with [Company Name] and will not want to use anyone else for their reprographic needs.
            
            We will continually reinforce our reputation for superior personal service by providing respect, training, involvement, recognition, reward, security and advancement opportunities to our associates.
            
            We will conduct research and development, use state-of-the-art equipment and review our methods of operation in a never ending effort to continually improve the quality of the products and services we offer.</p>
        </div>
        <div class="loginBox">
            <div class="banner">
                <p>Login</p>
            </div>
            <g:form controller="Login" action="login">
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="Password">
                <br>
                <small>
                	<g:if test="${flash.success}">
    					<div class="alert alert-success" style="display: block">${flash.success}</div>
					</g:if>
					<g:if test="${flash.error}">
   					 	<div class="alert alert-error" style="display: block">${flash.error}</div>
					</g:if>
				</small>
                <br>
                <input type="submit" value="login" </input>
            </g:form>
        </div>
    </body>
</html>