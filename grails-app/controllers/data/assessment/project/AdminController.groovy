package data.assessment.project

class AdminController {

    def index() {
      def classes = Classes.list()
      def measures = Measures.list()
      def indicators = Indicators.list()
      def assessment_documents = Assessment_Documentation.list()
      [Classes:classes, Measures:measures, Indicators:indicators, Assessment_Documentation:assessment_documents]
    }


}
