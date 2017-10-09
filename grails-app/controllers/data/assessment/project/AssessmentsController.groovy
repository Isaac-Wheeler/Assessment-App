package data.assessment.project

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    System.out.println(outcomes)
     return [Outcomes:outcomes, Indicators:indicators]
    System.out.println("called")
  }

}
