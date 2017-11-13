package data.assessment.project

class coursesController {

def index() {
  def classes = Classes.list()
  def indicators = Indicators.list()
  def teachers = Teacher.list()

  if (request.method == 'POST') {
    if(params.type == "new"){
    def c = new Classes()
    c.title = params.title
      if(!c.save(flush:true)){
        return [c:c, Classes:classes, Indicators:indicators, Teacher:teachers]
        redirect(controller:"courses")
      }
    }else{
      def c = Classes.get(params.class)
      def teacher = Teacher.get(params.teacherId)
      c.addToTeachers(teacher)
      if(!c.save(flush:true)){
        return [c:c, Classes:classes, Indicators:indicators, Teacher:teachers]
        redirect(controller:"courses")
      }
    }
  }
    [Classes:classes, Indicators:indicators, Teacher:teachers]
 }


 def deleteAssignedTeacher(){
   def c = Classes.get(params.classes)
   def t = Teacher.get(params.teacher)
   c.removeFromTeachers(t)
   c.save(flush:true)
   redirect(controller:"courses")
 }


 def delete() {
   def c = Classes.get(params.classes)
   c.delete(flush:true)
   redirect(controller:"courses")
 }


}
