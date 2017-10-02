package data.assessment.project

class OutcomesController {

  def index (){
    def outcomes = Outcomes.list()
    [Outcomes:outcomes]
  }

  def createOutcome() {
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        System.out.println(params)
        def o = new Outcomes(outcome_category: params.outcome_category, outcome_category_description: params.outcome_category_description)
          if(!o.save()){
            o.errors.each {
                println it
              }
            //return [outcome:o]
          }else{
            System.out.println("created outcome " + o)
        }
      }
    }
    redirect(view:"/outcome/index")
  }

  def editOutcome() {

  }

  def deleteOutcome() {
    def o = Outcomes.get(params.outcome)
    o.delete(flush:true)
    redirect(controller:'outcomes')
  }
}
