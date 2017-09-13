package data.assessment.project

class LoginController {

    def index() { 
     def username = params.username
     def password = params.password
     def usernameTF = false
     def passwordTF = false
     ["username": username, "password": password]
     
     //TODO: handle checking for username and password via database
     
     if(username == "admin"){ 
     	usernameTF = true
     }
 	 if(password == "pass"){ 
 	 	passwordTF = true
 	 }    
     
     
     //TODO: set user permission level
     if(usernameTF && passwordTF){
     	flash.success = "login succeed"
     	session.user = "admin"  //TODO: set here
     	redirect(action: '/') //TODO redirect to standared user page
     }else{
     	flash.error = "Your Username and/or Password was incorrect"
     		redirect(action: '/')
     
     
    }
    
    }
    
    def logout = {
    	session.user = null
    	redirect(action: '/')
    	
    }
    
}
