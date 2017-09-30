package data.assessment.project

class OutcomesController {

  def index (){

  }

  def createOutcome() {
    if (request.method == 'POST') {
    System.out.println(params)

    } else{
      redirect(view:'/admin/outcomes')
    }
    redirect(view:'/admin/outcomes')
  }

  def editOutcome() {

  }

  def deleteOutcome() {

  }
}
