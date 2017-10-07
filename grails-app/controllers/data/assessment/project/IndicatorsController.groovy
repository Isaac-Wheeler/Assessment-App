package data.assessment.project

class IndicatorsController {

    def index() { }

    def create() {
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          i.outcomeId = params.outcomeId
          i.classesId = 1 //TODO
            if(!i.save()){
              return [indicator:o]
              redirect(view:"/indicators/create")
            }
          def o = Outcomes.get(params.outcomeId)
          if(o.outcomeIndicators == null){
            o.outcomeIndicators = [i.id]
          }else{
          o.outcomeIndicators[] + [i.id]
          }
          o.save(flush:true)
        }
        redirect(view:"/outcomes/index")
      }
      return [outcomeId:params.givenOutcomeId]
    }
}
