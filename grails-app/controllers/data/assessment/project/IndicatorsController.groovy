package data.assessment.project

class IndicatorsController {

    def index() {
      def indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear)
      [Indicators:indicators]
    }

    def create() {
      def classes = Classes.list()
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          def o = Outcomes.get(params.outcomeId)
          System.out.println(o)
          def c = Classes.get(params.classId)
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          i.academicYear = Settings.first().academicYear
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
        redirect(controller:"outcomes")
      }
      return [outcomeId:params.outcomeId, Classes:classes]
    }

    def delete() {
      def i = Indicators.get(params.indicator)
      i.delete(flush:true)
      redirect(controller:'Indicators')
    }

    def edit() {
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = indicators.get(params.id)
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
            if(!i.save(flush:true)){
              return [indicators:i, id:i.id]
              redirect(view:"/indicators/editIndicator")
              System.out.println("Error")
            }
        }
        redirect(controller:"outcomes")
      }else{
        def i = indicators.get(params.indicators)
        return [indicators:i, id:i.id]
        redirect(view:"/indicators/editIndicator")
      }
    }

}
