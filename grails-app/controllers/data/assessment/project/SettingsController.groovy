package data.assessment.project

class SettingsController {

    def index() {

      def curYear = Calendar.getInstance().get(Calendar.YEAR)
      def yearList = yearsList()
      def years = Settings.list()

        if (request.method == 'POST') {
          //prevents someone form setting the current year as a new year
          if(params.academicYear != Settings.first().academicYear){



            //does not allow doubles of years
            if(Settings.findByAcademicYear(params.academicYear) == null){
            def newYear = Settings.first()
            def oldSettings = new Settings(academicYear:newYear.academicYear)
            newYear.academicYear = params.academicYear
            newYear.save(flush:true)
            oldSettings.save(flush:true)

            def outcomes = Outcomes.findAllByAcademicYear(oldSettings.academicYear)
            def indicators
            def oNew
            def iNew
            def course

            outcomes.each{o  ->
              oNew = new Outcomes(outcomeCategory: o.outcomeCategory, outcomeCategoryDescription: o.outcomeCategoryDescription, academicYear: newYear.academicYear)
                oNew.save(flush:true)
              indicators = outcomes.indicators
              indicators.each{ i ->
                iNew = new Indicators()
                  iNew.indicatorName = i.indicatorName
                  iNew.indicatorDescription = i.indicatorDescription
                  iNew.academicYear = newYear.academicYear
                  course = Classes.get(i.classes.id)
                  course.addToIndicators(iNew)
                  iNew.setOutcome(o)
                  iNew.save(flush:true)
              }
            }
          }else{
            //updating main if already exists in list
            def settings = Settings.first()
            def oldSettings = new Settings(academicYear:settings.academicYear)
            settings.academicYear = params.academicYear
            settings.save(flush:true)
            oldSettings.save(flush:true)
          }
        }

        }

          [year:Settings.first().academicYear, Years:years, yearList:yearList]
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
