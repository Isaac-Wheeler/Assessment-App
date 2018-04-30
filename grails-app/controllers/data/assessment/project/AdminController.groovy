package data.assessment.project

/*
* controller for admin side code
*/
class AdminController {

    /*
    * sends data to admin index
    */
    def index() {
      def courses = Courses.list()
      def year = BootStrap.GetYear(session)
      [Courses:courses, year:year]
    }
}
