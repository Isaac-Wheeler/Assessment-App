package data.assessment.project

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    System.out.println(outcomes)
     return [Outcomes:outcomes, Indicators:indicators]
    System.out.println("called")
  }

  def create(){
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){

      }
    }

    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()
    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
    System.out.println("called")
  }

}
