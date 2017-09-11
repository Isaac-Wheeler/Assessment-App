package data.assessment.project

class LoginController {

    def index() { 
     def username = prams.username
     def password = prams.password
     
     if(username == "admin" && password == "pass"){
     	flash.message = "login succeed"
     	session.user = "admin"
     }else{
     	flash.message = "login failed"
     }
     
     redirect(action: 'index')
     
    }
    
    def logout = {
    	session.user = null
    	redirect(action: 'index')
    	
    }
    
}

	