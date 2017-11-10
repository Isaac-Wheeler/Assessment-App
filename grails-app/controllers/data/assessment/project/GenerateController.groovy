package data.assessment.project

class GenerateController {

    def index() {
        def outcomes = Outcomes.list()
        [Outcomes:outcomes]
     }
}
