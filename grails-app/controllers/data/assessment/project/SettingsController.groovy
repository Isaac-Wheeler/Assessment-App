package data.assessment.project

class SettingsController {

    def index() {

      def curYear = Calendar.getInstance().get(Calendar.YEAR)
      def yearList = yearsList()
      def years = Settings.list()

        if (request.method == 'POST') {
          if(!BootStrap.isPerm(true, session)){
            redirect(controller:'main')
          }else{
          //prevents someone form setting the current year as a new year
          if(params.academicYear != Settings.first().academicYear){

            //does not allow doubles of years
            if(Settings.findByAcademicYear(params.academicYear) == null){

              def newYear = Settings.first()
              def oldSettings = new Settings(academicYear:newYear.academicYear)
              newYear.academicYear = params.academicYear
              newYear.save(flush:true)
              oldSettings.save(flush:true)

              yearChangeLoop(oldSettings,newYear)

          }else{

            //updating main if already exists in list
            def settings = Settings.first()
            def oldSettings = new Settings(academicYear:settings.academicYear)
            def inSettings = Settings.findByAcademicYear(params.academicYear)
              if(!inSettings.delete(flush:true)){
                inSettings.errors.allErrors.each { println it }
              }
            settings.academicYear = params.academicYear
            if(!settings.save(flush:true)){
              settings.errors.allErrors.each { println it }
            }
            if(!oldSettings.save(flush:true)){
              oldSettings.errors.allErrors.each { println it }
            }
          }
        }

        }
      }
          [year:Settings.first().academicYear, Years:years, yearList:yearList]
     }

     def yearChangeLoop(def oldSettings, def newYear){
       def outcomes = Outcomes.findAllByAcademicYear(oldSettings.academicYear)
       def indicators
       def measures
       def oNew
       def iNew
       def mNew
       def course

       outcomes.each{o  ->
         oNew = new Outcomes(outcomeCategory: o.outcomeCategory, outcomeCategoryDescription: o.outcomeCategoryDescription, academicYear: newYear.academicYear)
           oNew.save(flush:true)
           indicators = outcomes.indicators
           if(indicators != null){
             indicators.each{ i ->
               iNew = new Indicators()
               if(i.indicatorName.size() > 0 && i.indicatorDescription.size() > 0){
                 iNew.indicatorName = i.indicatorName.pop()
                 iNew.indicatorDescription = i.indicatorDescription.pop()
               }
               iNew.academicYear = newYear.academicYear
               measures = i.measures
               measures.each { m ->
                 mNew = new Measures()
                 if(m.measureTitle.size() > 0 && m.measureDescription.size() > 0){
                   mNew.measureTitle = m.measureTitle.pop()
                   mNew.measureDescription = m.measureDescription.pop()
                }
                 mNew.academicYear = newYear.academicYear
                 iNew.addToMeasures(mNew)
                 iNew.save(flsuh:true)
               }
               course = Courses.get(i.courses.id)
               if(course != null){
                 course.addToIndicators(iNew)
               }
               oNew.addToIndicators(iNew)
               oNew.save(flush:true)
             }
           }
         }
     }

     /**
     * creates a list of years to use in finding past and future years
     */
      def yearsList() {
       def curYear = Calendar.getInstance().get(Calendar.YEAR)
       def yearList = []

       curYear--
       curYear--

       yearList.add(curYear + "-" + ++curYear)
       yearList.add(curYear + "-" + ++curYear)

       for(int i = 0; i<6; i++){
         yearList.add(curYear + "-" + ++curYear)
       }

       return yearList
     }
}
