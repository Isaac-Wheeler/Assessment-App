package data.assessment.project

class SettingsController {

    def index() {

      def curYear = Calendar.getInstance().get(Calendar.YEAR)
      def yearList = []

      curYear--
      curYear--

      yearList.add(curYear + "-" + ++curYear)
      yearList.add(curYear + "-" + ++curYear)

      for(int i = 0; i<6; i++){
        yearList.add(curYear + "-" + ++curYear)
      }

      def years = Settings.list()

        if (request.method == 'POST') {
            def settings = Settings.first().academicYear
            def oldSettings = new Settings(academicYear:settings.academicYear)
            settings.academicYear = params.academicYear
            settings.save(flush:true)
            oldSettings.save(flush:true)

            def outcomes = Outcomes.findAllByAcademicYear(oldSettings.academicYear)
            def indicators


            //outcomes.each{o  ->
            //  System.out.println(o)
            //  indicators = outcomes.indicators
            //  indicators.each{ i ->
            //    System.out.println(i)
            //  }
            //}

        }

          [year:Settings.first().academicYear, Years:years, yearList:yearList]
     }
}
