package data.assessment.project

class OutcomesController {

  def index () {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    [Outcomes:outcomes, Indicators:indicators]
  }

  def createOutcome() {
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def o = new Outcomes(outcomeCategory: params.outcomeCategory, outcomeCategoryDescription: params.outcomeCategoryDescription)
          if(!o.save()){
            return [outcome:o]
            redirect(view:"/outcome/create")
          }
      }
      redirect(view:"/outcome/index")
    }
  }

  def editOutcome() {
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def o = Outcomes.get(params.id)
        o.outcomeCategory = params.outcome_category
        o.outcomeCategoryDescription = params.outcome_category_description
          if(!o.save(flush:true)){
            return [outcome:o, id:o.id]
            redirect(view:"/outcome/editOutcome")
            System.out.println("Error")
          }
      }
      redirect(view:"/outcome/index")
    }else{
      def o = Outcomes.get(params.outcome)
      return [outcome:o, id:o.id]
      redirect(view:"/outcome/editOutcome")
    }
  }

  def deleteOutcome() {
    def o = Outcomes.get(params.outcome)
    o.delete(flush:true)
    redirect(controller:'outcomes')
  }
}
