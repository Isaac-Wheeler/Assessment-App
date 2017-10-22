package data.assessment.project

class ClassController {

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
        redirect(controller:'class')
      }
    }else{
      [teacherId:1, type:assign, class:1, controller:class, format:null, action:index]
      def c = Classes.get(params.class)
      def teacher = Teaacher.get(params.teacherId)
      c.addToteachers(teacher)
      if(!c.save(flush:true)){
        return [c:c, Classes:classes, Indicators:indicators, Teacher:teachers]
        redirect(controller:'class')
      }
    }
  }
    [Classes:classes, Indicators:indicators, Teacher:teachers]
 }


 def delete() {
   def c = Classes.get(params.classes)
   c.delete(flush:true)
   redirect(controller:'class')
 }


}
