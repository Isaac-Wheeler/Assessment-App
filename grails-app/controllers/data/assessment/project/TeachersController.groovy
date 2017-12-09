package data.assessment.project

class TeachersController {

    def index() {
      def Teachers = Teacher.list()
      [Teacher:Teachers]
     }
     def delete() {
       def i = Teacher.get(params.teacher)
       i.delete(flush:true)
       redirect(controller:'Teachers')
     }
}
