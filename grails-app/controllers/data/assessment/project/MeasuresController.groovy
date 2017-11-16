package data.assessment.project

class MeasuresController {

    def viewMeasuresAdmin() {
      def measures = Measures.list()
      def classes = Classes.list()
      return [Measures:measures, Classes:classes]
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

    def viewMeasuresUser() {
      def measures = Measures.list()
      def classes = Classes.list()
      return [Measures:measures, Classes:classes]
    }

    def create(){
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def m = new Measures()
          m.measureTitle = params.measureTitle
          m.measureDescription = params.measureDescription
          def i = Indicators.get(params.indicatorId)
          i.addToMeasures(m)
          if(!i.save(flush:true)){
            return [Measures:m, Iid:params.indicatorId]
          }
          if(!m.save(flush:true)){
            return [Measures:m, Iid:params.indicatorId]
          }
        }
        if(params.isadmin){
          redirect(controller:"measures", action:"viewMeasuresAdmin")
        }else{
          redirect(controller:"measures", action:"viewMeasuresUser")
        }
      }

      def outcomes = Outcomes.list()
      def indicators = Indicators.list()
      def classes = Classes.list()
      return [Outcomes:outcomes, Indicators:indicators, Classes:classes, isadmin:params.isadmin]
    }
}