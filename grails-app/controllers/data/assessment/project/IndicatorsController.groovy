package data.assessment.project

class IndicatorsController {

    def index() { }

    def create() {
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          def i = new Indicators(params.outcome_id)
            if(!i.save()){
              return [indicator:o]
              redirect(view:"/indicators/create")
            }
        }
        redirect(view:"/indicators/index")
      }
    }
}
