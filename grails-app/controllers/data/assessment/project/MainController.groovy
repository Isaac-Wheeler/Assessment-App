package data.assessment.project

class MainController {

    def index() { }

    def home() {
      if(session.user.admin == true){
        redirect(controller:"admin")
      }else{
        redirect(controller:"client")
      }
    }
}
