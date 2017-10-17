package data.assessment.project

class IndicatorsController {

    def index() {
      def indicators = Indicators.list()
      [Indicators:indicators]
    }

    def create() {
      def classes = Classes.list()
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          def o = Outcomes.get(params.outcomeId)
          def c = Classes.get(params.classId)
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          o.addToIndicators(i)
          if(c != null){
          c.addToIndicators(i)
          if(!c.save(flush:true)){
            return [indicator:i, Classes:classes]
            redirect(view:"/indicators/create")
          }
          }
            if(!i.save(flush:true)){
              return [indicator:i, Classes:classes]
              redirect(view:"/indicators/create")
            }
          if(!o.save(flush:true)){
            return [indicator:i, Classes:classes]
            redirect(view:"/indicators/create")
          }

        }
        redirect(view:"/outcomes/index")
      }
      return [outcomeId:params.givenOutcomeId, Classes:classes]
    }
}
