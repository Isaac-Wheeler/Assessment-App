package data.assessment.project

class IndicatorsController {

    def index() {
      def indicators = Indicators.list()
      [Indicators:indicators]
    }

    def create() {
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          def o = Outcomes.get(params.outcomeId)
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          o.addToIndicators(i)
            if(!i.save(flush:true)){
              return [indicator:i]
              redirect(view:"/indicators/create")
            }
          if(!o.save(flush:true)){
            return [indicator:i]
            redirect(view:"/indicators/create")
          }

          //TODO Classes


        }
        redirect(view:"/outcomes/index")
      }
      return [outcomeId:params.givenOutcomeId]
    }
}
