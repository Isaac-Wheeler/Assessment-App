package data.assessment.project
/*
* controller for all indicator realated items
*/
class IndicatorsController {

    /*
    * sends the indicators to the index for displaying indicators, gets by current year
    */
    def index() {
      def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
      [Indicators:indicators]
    }

    /*
    * allows for the creation of a indicator
    */
    def create() {
      //needed to link to the correct course
      def courses = Courses.list()
      //checks if its data being passed or page load
      if (request.method == 'POST') {
        //checks to make sure post is from someone with permission to create
        if(!BootStrap.isPerm(true, session)){
          redirect(controller:'main')
        }else{
          //checks if the cancel button was clicked
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          def o = Outcomes.get(params.outcomeId)
          def c = params.classId
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          i.academicYear = Settings.first().academicYear
          o.addToIndicators(i)
          if(c != null){
            c.each {
              def courseToAdd = Courses.get(it)
              i.addToCourses(courseToAdd)
            }
          }
            if(!i.save(flush:true)){
              return [indicator:i, outcomeId:params.outcomeId, Courses:courses]
              redirect(view:"/indicators/create")
            }
          if(!o.save(flush:true)){
            return [indicator:i, outcomeId:params.outcomeId, Courses:courses]
            redirect(view:"/indicators/create")
          }
        }
        redirect(controller:"outcomes")
      }
    }
      return [outcomeId:params.outcomeId, Courses:courses]
    }

    /*
    * allows for the deleting of indicators
    */
    def delete() {
      if(!BootStrap.isPerm(true, session)){
        redirect(controller:'main')
      }else{
      def i = Indicators.get(params.indicator)
      if (i.courses != null) {
          def coursesList = []
          i.courses.each { course->
            //i.removeFromCourses(course)                           //save the course IDs in a list for removing association from indicator
            coursesList.add(course.id)
        }
        for (int j = 0; j<coursesList.size(); j++) {                //run through coursesList and get the course object and then remove from the indicator Courses association
            def courseToBeRemoved = Courses.get(coursesList[j])
            i.removeFromCourses(courseToBeRemoved)
        }
      }
      i.delete(flush:true)
      redirect(controller:'outcomes')
    }
    }

    /*
    * allows for the editing of indicators
    */
    def editIndicator() {
      def courses = Courses.list()
      if (request.method == 'POST') {
        if(!BootStrap.isPerm(true, session)){
          redirect(controller:'main')
        }else{
        if(!params.submitButton.contains("Cancel")){
          def i = Indicators.get(params.id)
          i.indicatorName = params.indicatorName
          i.indicatorDescription = params.indicatorDescription
          def c = params.classId
          if (c != null) {
            def coursesList = []
            i.courses.each { course->
              coursesList.add(course.id)
           }
            for (int j = 0; j<coursesList.size(); j++) {                //run through coursesList and get the course object and then remove from the indicator Courses association
              def courseToBeRemoved = Courses.get(coursesList[j])
              i.removeFromCourses(courseToBeRemoved)
           }
           c.each {
             def courseToAdd = Courses.get(it)
             i.addToCourses(courseToAdd)
           }
          }
            if(!i.save(flush:true)){
              return [indicator:i, Courses:courses]
              redirect(view:"/indicators/editIndicator")
            }
        }
        redirect(controller:"outcomes")
      }
      }else{
        def i = Indicators.get(params.indicator)
        return [indicator:i, Courses:courses]
        redirect(view:"/indicators/editIndicator")
      }
    }

}
