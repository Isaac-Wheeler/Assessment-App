package data.assessment.project

/*
* controller for client side code
*/
class ClientController {

  /*
  * sends current year to the index with courses
  */
    def index() {
      def courses = Courses.list()
      def year = BootStrap.GetYear(session)
      [Courses:courses, year:year]
     }
}
