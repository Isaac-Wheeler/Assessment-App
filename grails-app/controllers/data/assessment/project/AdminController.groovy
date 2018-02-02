package data.assessment.project


class AdminController {

    def index() {
      def classes = Classes.list()
      def year = BootStrap.GetYear(session)
      [Classes:classes, year:year]
    }
}
