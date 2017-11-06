package data.assessment.project

class TeachersController {

    def index() {
      def Teachers = Teacher.list()
      [Teacher:Teachers]
      redirect(view:'/Teachers/index')
     }
     def delete() {
       def i = Teachers.get(params.teacher)
       i.delete(flush:true)
       redirect(controller:'Teachers')
     }
}
