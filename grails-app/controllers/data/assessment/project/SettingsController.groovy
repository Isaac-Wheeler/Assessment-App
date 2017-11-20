package data.assessment.project

class SettingsController {

    def index() {

        if (request.method == 'POST') {
            def settings = Settings.get(1)
            def newSettins = new Settings(academicYear:settings.academicYear)
            settings.academicYear = params.academicYear
            settings.save(flush:true)
            newSettins.save(flush:true)

        }

          [year:Settings.get(1).academicYear]
     }
}
