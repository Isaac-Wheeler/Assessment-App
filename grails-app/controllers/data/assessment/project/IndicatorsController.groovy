package data.assessment.project

class IndicatorsController {

    def index() { }

    def create() {
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          i.indicator_name = params.indicator_name
          i.indicator_description = params.indicator_description
          i.outcome_id = params.outcome_id
          i.classes_id = 0 //TODO
            if(!i.save()){
              return [indicator:o]
              redirect(view:"/indicators/create")
            }
          def o = Outcomes.get(params.outcome_id)
          if(o.outcomeIndicators == null){
            o.outcomeIndicators = [i.id]
          }else{
          o.outcomeIndicators[] + [i.id]
          }
          o.save(flush:true)
        }
        redirect(view:"/indicators/index")
      }
      return [outcome_id:params.givenOutcomeId]
    }
}
