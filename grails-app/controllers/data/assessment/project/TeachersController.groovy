package data.assessment.project

class TeachersController {

    def index() {
      def Teachers = User.list()
      [Teachers:User]
     }
}
