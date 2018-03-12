package data.assessment.project

class coursesController {

  def index() {
    def classes = Classes.list()
    def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
    def teachers = Teacher.list()

    [Classes:classes, Indicators:indicators, Teacher:teachers]
 }

 def createCourse(){
   def classes = Classes.list()
   if (request.method == 'POST') {
     if(!params.submitButton.contains("Cancel")){
       def c = new Courses()
       c.title = params.title
       c.targetGoal = Integer.parseInt(params.targetGoal) // will throw error if null
       c.requiredAction = params.requiredAction
        if(!c.save(flush:true)){
          c.errors.allErrors.each { println it }
          return [course:c]
        }
       }
        redirect(controller:"courses", action:"index")
     }
}

 def editCourse(){
   def classes = Classes.list()
   if (request.method == 'POST') {
     if(!params.submitButton.contains("Cancel")){
       def c = Classes.get(params.course)
       c.title = params.title
       c.targetGoal = Integer.parseInt(params.targetGoal) // will throw error if null
       c.requiredAction = params.requiredAction
        if(!c.save(flush:true)){
          return [course:c]
        }
       }
        redirect(controller:"courses", action:"index")
     }
     def c = Classes.get(params.course)
     [course:c]
}


 def assignNewTeacher(){
   def classes = Classes.list()
   def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
   def teachers = Teacher.list()

   def c = Classes.get(params.class)
   def teacher = Teacher.findByUsername(params.teacherUserName)
   c.addToTeachers(teacher)
   if(!c.save(flush:true)){
     return [c:c, Classes:classes, Indicators:indicators, Teacher:teachers]
   }
   redirect(controller:"courses", action:"index")
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
