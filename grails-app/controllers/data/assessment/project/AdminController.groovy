package data.assessment.project

class AdminController {

    def index() {
      def classes = Classes.list()
      def year = Settings.first().academicYear
      [Classes:classes, year:year]
    }


}
