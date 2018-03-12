package data.assessment.project


class AdminController {

    def index() {
      def courses = Courses.list()
      def year = BootStrap.GetYear(session)
      [Courses:courses, year:year]
    }
}
