package data.assessment.project

class SettingsController {

    def index() {

      def years = Settings.list()

        if (request.method == 'POST') {
            def settings = Settings.get(1)
            def oldSettings = new Settings(academicYear:settings.academicYear)
            //settings.academicYear = params.academicYear
            //settings.save(flush:true)
            //oldSettins.save(flush:true)

            def outcomes = Outcomes.findAllByAcademicYear(oldSettings.academicYear)
            def indicators
            outcomes.each{o  ->
              System.out.println(o)
              indicators = outcomes.indicators
              indicators.each{ i ->
                System.out.println(i)
              }
            }

        }

          [year:Settings.get(1).academicYear, Years:years]
     }
}
