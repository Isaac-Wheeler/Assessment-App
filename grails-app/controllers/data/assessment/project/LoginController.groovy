package data.assessment.project

class LoginController {

    def login() { 
     def username = prams.username
     def password = prams.password
     ["username": username, "password": password]
     
     if(username == "admin" && password == "pass"){
     	flash.message = "login succeed"
     	session.user = "admin"
     	// redirect(action: 'index') 
     }else{
     	flash.message = "login failed"
     	 redirect(action: '/failLogin')
     }
     
    
     
    }
    
    def logout = {
    	session.user = null
    	redirect(action: 'index')
    	
    }
    
}

	