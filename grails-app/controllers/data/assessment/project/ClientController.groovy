package data.assessment.project

class ClientController {

    def index() {
      def classes = Courses.list()
      def year = BootStrap.GetYear(session)
      [Courses:classes, year:year]
     }
}
