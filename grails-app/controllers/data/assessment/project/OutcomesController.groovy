package data.assessment.project

class OutcomesController {

  def index (){

  }

  def createOutcome() {
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def o = new Outcomes(params)
          if(!o.save()){
            System.out.println("failed to save")
            //return [outcome:o]
          }else{
          System.out.println("created outcome " + o)
        }
      }
    }
    redirect(view:"/outcome/index")
  }

  def editOutcome() {

  }

  def deleteOutcome() {

  }
}
