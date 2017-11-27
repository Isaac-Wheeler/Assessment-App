package data.assessment.project

class GenerateController {

    def index() {
        def outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear)
        [Outcomes:outcomes]
     }
}
