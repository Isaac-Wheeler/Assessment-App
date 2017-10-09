package data.assessment.project

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    [Outcomes:outcomes, Indicators:indicators]
  }

}
