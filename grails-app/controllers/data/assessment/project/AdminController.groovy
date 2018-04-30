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
      [Courses:courses, year:year, compleationLevel:str]
    }


    /*
    * gets the number of complete AD's for each teacher
    */
    def getCompleationLevel(){
      //empty map to hold the teacher name and values
      def teach = [:]
      //gets all the courses
      def courses = Courses.list()

      //loop thru each course
      courses.each{ c ->
        //check if teacher is not null
        if(c.teachers != null){
          //loop thru each teacher
          c.teachers.each{ t ->
            //go thru each indicator linked to the course
            c.indicators.each{ i ->
              //go thru each measure linked to indcator
              i.measures.each{ m  ->
                  //check if the ad is complete or not
                  if (m.assessment_documents.complete){
                    //check if entry already exists
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

      //change the map to a string array
      def str = []
      teach.keySet().each{
        str << it + " Completed:" + teach[it].ADcomplete + "/" + teach[it].ADnum
      }
      return str
      }
}
