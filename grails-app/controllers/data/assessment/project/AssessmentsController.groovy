package data.assessment.project

class AssessmentsController {

    def index() { }

    def create() {
      System.out.println("Hit")
      redirect(uri: "/createAssessment")
    }
}
