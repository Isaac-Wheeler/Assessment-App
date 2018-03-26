package data.assessment.project

class OutcomesController {

  def index() {
    def outcomes = Outcomes.findAllByAcademicYear(BootStrap.GetYear(session))
    def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
    [Outcomes:outcomes, Indicators:indicators]
  }
  def viewOutcomesUser() {
    def outcomes = Outcomes.findAllByAcademicYear(BootStrap.GetYear(session))
    def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
    [Outcomes:outcomes, Indicators:indicators]
  }
  def createOutcome() {
    if (request.method == 'POST') {
      if(!BootStrap.isPerm(true, session)){
        redirect(controller:'main')
      }else{
      if(!params.submitButton.contains("Cancel")){
        def o = new Outcomes(outcomeCategory: params.outcomeCategory, outcomeCategoryDescription: params.outcomeCategoryDescription, academicYear:Settings.first().academicYear)
          if(!o.save(flush: true)){
            o.errors.allErrors.each { println it }
            return [outcome:o]
            redirect(view:"/outcome/create")
          }
      }
      redirect(view:"/outcome/index")
    }
  }
  }

  def editOutcome() {
    if (request.method == 'POST') {
      if(!BootStrap.isPerm(true, session)){
        redirect(controller:'main')
      }else{
      if(!params.submitButton.contains("Cancel")){
        def o = Outcomes.get(params.id)
          o.outcomeCategory = params.outcomeCategory
          o.outcomeCategoryDescription = params.outcomeCategoryDescription
          if(!o.save(flush:true)){
            return [outcome:o, id:o.id]
            redirect(view:"/outcome/editOutcome")
          }
      }
      redirect(view:"/outcome/index")
    }
    }else{
      def o = Outcomes.get(params.outcome)
      return [outcome:o, id:o.id]
      redirect(view:"/outcome/editOutcome")
    }
  }

  def deleteOutcome() {
    if(!BootStrap.isPerm(true, session)){
      redirect(controller:'main')
    }else{
    def o = Outcomes.get(params.outcome)
    def indicList = []
    if (o.indicators != null) {
      o.indicators.each { indic->
        if (indic.courses != null) {
            def coursesList = []
            indic.courses.each { course->
              coursesList.add(course.id)    //save the course IDs in a list for removing association from indicator
          }
          for (int j = 0; j<coursesList.size(); j++) {                //run through coursesList and get the course object and then remove from the indicator Courses association
              def courseToBeRemoved = Courses.get(coursesList[j])
              indic.removeFromCourses(courseToBeRemoved)
          }
        }
        indicList.add(indic.id)
      }
    }
    for (int k = 0; k<indicList.size(); k++) {
      def indicToBeRemoved = Indicators.get(indicList[k])
      o.removeFromIndicators(indicToBeRemoved)
      indicToBeRemoved.delete(flush:true)
    }
    o.delete(flush:true)
    redirect(controller:'outcomes')
  }
}
}
