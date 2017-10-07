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
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          i.outcomeId = params.outcomeId
          i.classesId = 1 //TODO
            if(!i.save(flush:true)){
              return [indicator:o]
              redirect(view:"/indicators/create")
            }
          def o = Outcomes.get(params.outcomeId)
          System.out.println(o.outcomeIndicators)
          if(o.outcomeIndicators == null){
            o.outcomeIndicators = new ArrayList<Integer>()
            o.outcomeIndicators.add(i.id)
            System.out.println(o.outcomeIndicators)
            System.out.println("new")
          }else{
            o.outcomeIndicators << i.id
            System.out.println(o.outcomeIndicators)
          }
          if(!o.save(flush:true)){
            System.out.println("Error")
          }
        }
        redirect(view:"/outcomes/index")
      }
      return [outcomeId:params.givenOutcomeId]
    }
}
