package data.assessment.project

class MainController {

    def index() {
      if(session.teacher){
        if(session.teacher.admin == true){
          redirect(controller:"Admin")
        }else if (session.teacher.admin == false){
          redirect(controller:"client")
        }
      }
     }

     def home(){
       if(session.teacher){
         if(session.teacher.admin == true){
           redirect(controller:"admin")
         }else if (session.teacher.admin == false){
           redirect(controller:"client")
         }
       }
     }
}
