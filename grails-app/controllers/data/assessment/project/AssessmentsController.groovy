package data.assessment.project

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()

    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def AD = new Assessment_Documentation()
        AD.targetGoal = params.targetGoal
        //workUsed;     **leaving as a comment for now until ready to implement file uploads.
        AD.numberOfStudents = params.numberOfStudents
        AD.needsImprovement = params.needsImprovement
        AD.meetsExpectations = params.meetsExpectations
        AD.exceedsExpectations = params.exceedsExpectations
        AD.summary = params.summary
        AD.requiredAction = params.requiredAction
        AD.resultComment = params.resultComment
        AD.academicSemester = params.academicSemester
        AD.complete = params.complete
      }
    }

     return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
    System.out.println("called")
  }

  def viewMeasuresAdmin() {
    def measures = Measures.list()
    def classes = Classes.list()
    return [Measures:measures, Classes:classes]
  }

  def create(){
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def m = new Measures()
        m.measureTitle = params.measureTitle
        m.measureDescription = params.measureDescription
        def i = Indicators.get(params.indicatorId)
        i.addToMeasures(m)
        if(!i.save(flush:true)){
          return [Measures:m, Iid:params.indicatorId]
        }
        if(!m.save(flush:true)){
          return [Measures:m, Iid:params.indicatorId]
        }
      }
      redirect(controller:"Admin")
    }

    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()
    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
    System.out.println("called")
  }

}
