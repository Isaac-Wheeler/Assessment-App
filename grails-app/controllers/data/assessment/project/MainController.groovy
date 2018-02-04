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

     def changeYear() {
       def setYear = params.setYear
       session.year = setYear
       //redirect user back to there page
       redirect(uri:params.location.drop(4))
     }
}
