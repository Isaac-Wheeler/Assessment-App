package data.assessment.project

class TeachersController {

    def index() {
      def Users = User.list()
      [User:Users]
     }
}
