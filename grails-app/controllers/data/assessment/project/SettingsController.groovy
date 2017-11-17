package data.assessment.project

class SettingsController {

    def index() {

        if (request.method == 'POST') {
            def settings = Settings.get(1)
            settings.academicYear = params.academicYear
            settings.save(flush:true)

        }

          [year:Settings.get(1).academicYear]
     }
}
