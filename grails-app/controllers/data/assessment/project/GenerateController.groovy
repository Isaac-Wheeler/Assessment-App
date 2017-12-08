package data.assessment.project

class GenerateController {

    def index() {
      if (request.method == 'POST') {
        def outcomes = Outcomes.findAllByAcademicYear(Settings.get(params.academicYear).academicYear)
        def settings = Settings.list()
        [Outcomes:outcomes, Settings:settings, year:Settings.get(params.academicYear).id]
      }else{
        def outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear)
        def settings = Settings.list()
        [Outcomes:outcomes, Settings:settings]
      }
     }
}
