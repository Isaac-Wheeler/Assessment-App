package data.assessment.project

class MainController {

    def index() {
      if(session.user){
        if(session.user.admin == true){
          redirect(controller:"admin")
        }else if (session.user.admin == false){
          redirect(controller:"client")
        }
      }
     }

     def home(){
       if(session.user){
         if(session.user.admin == true){
           redirect(controller:"admin")
         }else if (session.user.admin == false){
           redirect(controller:"client")
         }
       }
     }
}
