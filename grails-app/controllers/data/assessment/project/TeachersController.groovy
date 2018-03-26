package data.assessment.project

class TeachersController {

    def index() {
      def Teachers = Teacher.list()
      [Teacher:Teachers]
     }
}
