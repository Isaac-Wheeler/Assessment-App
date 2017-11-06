package data.assessment.project

class AdminController {

    def index() {
      def classes = Classes.list()
      def measures = Measures.list()
      def indicators = Indicators.list()
      [Classes:classes, Measures:measures, Indicators:indicators]
    }


}
