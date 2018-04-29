package data.assessment.project

/*
* controller for the teacher.index view
*/
class TeachersController {

  /*
  *sends the list of teachers to the view so they can be displayed
  */
    def index() {
      def Teachers = Teacher.list()
      [Teacher:Teachers]
     }
}
