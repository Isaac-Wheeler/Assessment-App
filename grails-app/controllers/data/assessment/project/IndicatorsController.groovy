package data.assessment.project

class IndicatorsController {

    def index() {
      def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
      [Indicators:indicators]
    }

    def create() {
      def courses = Courses.list()
      if (request.method == 'POST') {
        if(!BootStrap.isPerm(true, session)){
          redirect(controller:'main')
        }else{
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators()
          def o = Outcomes.get(params.outcomeId)
          //def c = Courses.get(params.classId)
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
