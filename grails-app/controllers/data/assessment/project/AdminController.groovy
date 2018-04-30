package data.assessment.project

/*
* controller for admin side code
*/
class AdminController {

    /*
    * sends data to admin index
    */
    def index() {
      def courses = Courses.list()
      def year = BootStrap.GetYear(session)
      def str = getCompleationLevel()
      [Courses:courses, year:year, CL:str]
    }

    def getCompleationLevel(){

      def teach = [:]
      def courses = Courses.list()

      courses.each{ c ->
        if(c.teachers != null){
          c.teachers.each{ t ->
            c.indicators.each{ i ->
              i.measures.each{ m  ->
                  if (m.assessment_documents.complete){
                    if(teach[t.username] == null){
                      teach[t.username] = ['ADnum': 1 , 'ADcomplete': 1]
                    }else{
                      teach[t.username].ADnum++
                      teach[t.username].ADcomplete++
                    }
                  }else{
                    if(teach[t.username] == null){
                      teach[t.username] = ['ADnum': 1 , 'ADcomplete': 0]
                    }else{
                      teach[t.username].ADnum++
                    }
                  }
              }
            }
          }
        }
      }

      def str = []
      teach.keySet().each{
        str << it + " " + teach[it].ADcomplete + "/" + teach[it].ADnum
      }
      return str
      }
}
