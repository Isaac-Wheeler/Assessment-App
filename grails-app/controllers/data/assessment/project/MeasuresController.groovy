package data.assessment.project

class MeasuresController {

    def viewMeasuresAdmin() {
      return index()
    }

    def viewMeasuresUser() {
      return index()
    }

    def index(){
      def measures
      def indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear)
      indicators.each{ i ->
        if(i.measures != null){
          if(measures == null){
            measures = i.measures
          }else{
            measures = measures + i.measures
          }
        }
      }

      return [Measures:measures]
    }

    def delete(){
      def m = Measures.get(params.measure)
      m.delete(flush:true)
      if(params.isadmin){
        redirect(controller:"measures", action:"viewMeasuresAdmin")
      }else{
        redirect(controller:"measures", action:"viewMeasuresUser")
      }
    }

    def create(){
      def indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear)
      if (request.method == 'POST') {
        if(params.containsKey("submitButton")){
          if(!params.submitButton.contains("Cancel")){
            def m = new Measures()
            m.measureTitle = params.measureTitle
            m.measureDescription = params.measureDescription
            def i = Indicators.get(params.indicatorId)
            i.addToMeasures(m)
            if(!i.save(flush:true)){
              return [Measures:m, Iid:params.indicatorId, isadmin:params.isadmin, indicatorDisc:params.indicatorDisc]
            }
            if(!m.save(flush:true)){
              return [Measures:m, Iid:params.indicatorId, isadmin:params.isadmin, indicatorDisc:params.indicatorDisc]
            }
          }
          if(params.isadmin){
            redirect(controller:"measures", action:"viewMeasuresAdmin")
            }else{
              redirect(controller:"measures", action:"viewMeasuresUser")
            }
        }else{
          def m = new Measures()
          m.measureTitle = params.measureTitle
          m.measureDescription = params.measureDescription
          def disc = Indicators.get(params.indicatorId).indicatorDescription
          return [Measures:m, Iid:params.indicatorId, Indicators:indicators, isadmin:params.isadmin, indicatorDisc:disc]
        }
      }
      def disc = Indicators.first().indicatorDescription
      return [Indicators:indicators, isadmin:params.isadmin, indicatorDisc:disc]
    }

    def edit(){
      def indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear)
      if (request.method == 'POST') {
        if(params.containsKey("submitButton")){
          if(!params.submitButton.contains("Cancel")){
            def m = Measures.get(params.measure)
            m.measureTitle = params.measureTitle
            m.measureDescription = params.measureDescription
            def i = Indicators.get(params.indicatorId)
            i.addToMeasures(m)
            if(!i.save(flush:true)){
              return [Measures:m, measure:m.id, Iid:params.indicatorId]
            }
            if(!m.save(flush:true)){
              return [Measures:m, measure:m.id, Iid:params.indicatorId]
            }
          }
          if(params.isadmin){
            redirect(controller:"measures", action:"viewMeasuresAdmin")
          }else{
              redirect(controller:"measures", action:"viewMeasuresUser")
          }
        }else{
          def m = Measures.get(params.measure)
          m.measureTitle = params.measureTitle
          m.measureDescription = params.measureDescription
          def disc = Indicators.get(params.indicatorId).indicatorDescription
          return [Measures:m, measure:m.id,  Iid:params.indicatorId, Indicators:indicators, isadmin:params.isadmin, indicatorDisc:disc]
        }
      }
      def m = Measures.get(params.measure)
      def disc = Indicators.first().indicatorDescription
      return [Measures:m, measure:m.id, Indicators:indicators, isadmin:params.isadmin, indicatorDisc:disc]
    }
}
