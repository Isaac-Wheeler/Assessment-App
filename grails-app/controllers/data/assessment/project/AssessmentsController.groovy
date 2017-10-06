package data.assessment.project

class AssessmentsController {

    def createOutcome() {
      if (request.method == 'POST') {
      System.out.println(parms)
      } else{
        redirect(view:'/assessments/createOutcome')
      }
    }

    def editOutcome() {

    }

    def deleteOutcome() {

    }

    def createIndicator() {
      if (request.method == 'POST') {
      System.out.println(parms)
      } else{
        redirect(view:'/assessments/createIndicator')
      }
    }

    def editIndicator() {

    }

    def deleteIndicator(){

    }
}
