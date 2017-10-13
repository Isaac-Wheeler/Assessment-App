package data.assessment.project

class ClassController {

def index() {
  if (request.method == 'POST') {
    def c = new Classes()
    c.title = params.title
      if(!c.save(flush:true)){
        return [c:c]
        redirect(controller:"class")
      }
  }
    def classes = Classes.list()
    def indicators = Indicators.list()
    [Classes:classes, Indicators:indicators]
 }


 def delete() {
   def c = Classes.get(params.classes)
   c.delete(flush:true)
   redirect(controller:'class')
 }

}
