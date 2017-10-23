package data.assessment.project

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()


    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def mId = null
        def measure = null
        if(params.submitButton.startsWith('edit_')){
          mId = params.submitButton-"edit_"
          measure = Measures.get(mId)
        }
        if(params.submitButton.startsWith('add_')){
          mId = params.submitButton-"add_"
          measure = Measures.get(mId)
        }
        def AD = new Assessment_Documentation()
        AD.targetGoal = Integer.parseInt(params.targetGoal)
        //workUsed;     **leaving as a comment for now until ready to implement file uploads.
        def holder = Integer.parseInt(params.meetsExpectations) +
        Integer.parseInt(params.needsImprovement) +
        Integer.parseInt(params.exceedsExpectations)
        AD.numberOfStudents = holder
        AD.needsImprovement = Integer.parseInt(params.needsImprovement)
        AD.meetsExpectations = Integer.parseInt(params.meetsExpectations)
        AD.exceedsExpectations = Integer.parseInt(params.exceedsExpectations)
        AD.summary = params.summary
        if(params.requiredAction != null){
          AD.requiredAction = params.requiredAction
        }
        if(params.resultComment != null){
          AD.resultComment = params.resultComment
        }
        AD.academicSemester = params.academicSemester
        if(params.complete == null){
          AD.complete = false
        }else{
          AD.complete = params.complete
        }
        if(measure != null){
          measure.addToAssessment_documents(AD)
          if(!measure.save(flush:true)){
            return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes]
          }
        }
        if(!AD.save(flush:true)){
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes]
        }

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
