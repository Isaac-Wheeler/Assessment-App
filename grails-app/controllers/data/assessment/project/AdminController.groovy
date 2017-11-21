package data.assessment.project

class AdminController {

    def index() {
      def classes = Classes.list()
      def year = Settings.get(1).academicYear
      [Classes:classes, year:year]
    }


}
