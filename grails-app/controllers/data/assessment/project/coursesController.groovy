package data.assessment.project

/*
* controller for courses methods
*/
class coursesController {

  /*
  * sends data to the index view
  */
  def index() {
    def courses = Courses.list()
    def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
    def teachers = Teacher.list()

    [Courses:courses, Indicators:indicators, Teacher:teachers]
 }

 /*
 * allows for the creating of a course
 */
 def createCourse(){
   def courses = Courses.list()
   def suggestedTargetGoals = SuggestedTargetGoals.list()
   if (request.method == 'POST') {
     if(!BootStrap.isPerm(true, session)){
       redirect(controller:'main')
     }else{
     if(!params.submitButton.contains("Cancel")){
       def c = new Courses()
       c.title = params.title
       c.targetGoal = Integer.parseInt(params.targetGoal) // will throw error if null
       c.requiredAction = params.requiredAction
        if(!c.save(flush:true)){
          c.errors.allErrors.each { println it }
          return [course:c, STG:suggestedTargetGoals]
        }
       }
        redirect(controller:"courses", action:"index")
     }
   }
   [STG:suggestedTargetGoals]
}

  /*
  * allows for the editing of courses
  */
 def editCourse(){
   def courses = Courses.list()
   def suggestedTargetGoals = SuggestedTargetGoals.list()
   if (request.method == 'POST') {
     if(!BootStrap.isPerm(true, session)){
       redirect(controller:'main')
     }else{
     if(!params.submitButton.contains("Cancel")){
       def c = Courses.get(params.course)
       c.title = params.title
       c.targetGoal = Integer.parseInt(params.targetGoal) // will throw error if null
       c.requiredAction = params.requiredAction
        if(!c.save(flush:true)){
          return [course:c, STG:suggestedTargetGoals]
        }
       }
        redirect(controller:"courses", action:"index")
     }
   }
     def c = Courses.get(params.course)
     [course:c, STG:suggestedTargetGoals]
}

  /*
  * allows for the assigning of a teacher to a course
  */
 def assignNewTeacher(){
   if(!BootStrap.isPerm(true, session)){
     redirect(controller:'main')
   }else{
   def courses = Courses.list()
   def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
   def teachers = Teacher.list()

   def c = Courses.get(params.class)
   def teacher = Teacher.findByUsername(params.teacherUserName)
   c.addToTeachers(teacher)
   if(!c.save(flush:true)){
     return [c:c, Courses:courses, Indicators:indicators, Teacher:teachers]
   }
   redirect(controller:"courses", action:"index")
 }
 }

 /*
 * allows for the deletion of a assigned teacher
 */
 def deleteAssignedTeacher(){
   if(!BootStrap.isPerm(true, session)){
     redirect(controller:'main')
   }else{
   def c = Courses.get(params.courses)
   def t = Teacher.get(params.teacher)
   c.removeFromTeachers(t)
   c.save(flush:true)
   redirect(controller:"courses")
 }
 }

 /*
 * allows for the deletion of courses
 */
 def delete() {
   if(!BootStrap.isPerm(true, session)){
     redirect(controller:'main')
   }else{
   def c = Courses.get(params.courses)
   c.delete(flush:true)
   redirect(controller:"courses")
  }
 }


}
