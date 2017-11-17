package data.assessment.project

class GenerateController {

    def index() {
        def outcomes = Outcomes.findAllByAcademicYear(Settings.get(1).academicYear)
        [Outcomes:outcomes]
     }
}
