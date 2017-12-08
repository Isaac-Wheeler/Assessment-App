package data.assessment.project

class MeasuresController {

    def viewMeasuresAdmin() {
      //def measures = Measures.list()
      //def classes = Classes.list()
      //return [Measures:measures, Classes:classes]
      return index()
    }

    def viewMeasuresUser() {
      //def measures = Measures.list()
      //def classes = Classes.list()
      //return [Measures:measures, Classes:classes]
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

      def indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear)
      return [Indicators:indicators, isadmin:params.isadmin]
    }

    def edit(){
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def m = Measures.get(params.id)
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

      def indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear)
      return [Indicators:indicators, isadmin:params.isadmin]
    }
}
