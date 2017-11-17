package data.assessment.project

class IndicatorsController {

    def index() {
      def indicators = Indicators.findAllByAcademicYear(Settings.get(1).academicYear)
      [Indicators:indicators]
    }

    def create() {
      def classes = Classes.list()
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          def o = indicators.get(params.indicatorsId)
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
        redirect(controller:"indicators")
      }
      return [indicatorsId:params.givenindicatorsId, Classes:classes]
    }

    def delete() {
      def i = Indicators.get(params.indicator)
      i.delete(flush:true)
      redirect(controller:'Indicators')
    }
    def edit() {
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def o = indicators.get(params.id)
          o.indicatorName = params.indicatorName
          o.indicatorDescription = params.indicatorDescription
            if(!o.save(flush:true)){
              return [indicators:i, id:i.id]
              redirect(view:"/indicators/editIndicator")
              System.out.println("Error")
            }
        }
        redirect(view:"/indicator/index")
      }else{
        def o = indicators.get(params.indicators)
        return [indicators:o, id:o.id]
        redirect(view:"/indicators/editIndicator")
      }
    }

}
