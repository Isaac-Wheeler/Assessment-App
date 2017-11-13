package data.assessment.project

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.oreilly.servlet.MultipartRequest;

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()
    def measures = Measures.list()

    if (request.method == 'POST' || params.courseLink) {

      if(!params.submitButton.contains("Cancel")){
        if(params.submitButton.startsWith('edit_')){
        def mId = null
        def measure = null
        def ADId = params.submitButton-"edit_"
        def AD = Assessment_Documentation.get(ADId)

        return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, measureID:AD.measure.id, show:true]


        }else if(params.submitButton.startsWith('new_')){
          def mId = params.submitButton-"new_"

          return [Outcomes:outcomes, Indicators:indicators, Classes:classes, measureID:mId, show:true]
        }

      else{
        def AD = new Assessment_Documentation()
        AD.targetGoal = Integer.parseInt(params.targetGoal) //TODO:handle incorrect input


        def file = request.getFile('myFile')
        if (file != null) {
          def documentInstance = new Document();
          documentInstance.filename = file.originalFilename
          documentInstance.filedata = file.getBytes()
          if (documentInstance.validate()) {
            documentInstance.save(flush:true)
            AD.addToDocuments(documentInstance)
            }
          else {
                documentInstance.errors.allErrors.each {
                    println it
                }
          }
        }

        def holder = Integer.parseInt(params.meetsExpectations) +
        Integer.parseInt(params.needsImprovement) +
        Integer.parseInt(params.exceedsExpectations)
        AD.numberOfStudents = holder
        AD.needsImprovement = Integer.parseInt(params.needsImprovement)
        AD.meetsExpectations = Integer.parseInt(params.meetsExpectations)
        AD.exceedsExpectations = Integer.parseInt(params.exceedsExpectations)
        AD.summary = params.summary
        AD.assessmentDocTitle = params.assessmentDocTitle
        AD.comments = params.comments
        if(params.requiredAction != null){
          AD.requiredAction = params.requiredAction
        }
        if(params.resultComment != null){
          AD.resultComment = params.resultComment
        }
        AD.academicSemester = params.academicSemester
        if(params.complete == null){
          AD.complete = false
        }else{
          AD.complete = params.complete
        }
        if(params.measureID != null){
          def measure = Measures.get(params.measureID)
          AD.setMeasure(measure)
        }
        if(!AD.save(flush:true)){
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, show:true]
        }
        redirect(controler:"Assessments", action:"editAssessment")
      }
      }else{
        redirect(controler:"Assessments", action:"editAssessment")
      }
    }

    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
  }

  def viewMeasuresAdmin() {
    def measures = Measures.list()
    def classes = Classes.list()
    def indicators = Indicators.list()
    return [Measures:measures, Classes:classes, Indicators:indicators]
  }

  def deleteMeasure(){
    def m = Measures.get(params.measure)
    m.delete(flush:true)
    redirect(controler:"admin")
  }

  def viewMeasuresUser() {
    def measures = Measures.list()
    def classes = Classes.list()
    return [Measures:measures, Classes:classes]
  }

  def create(){
    if (request.method == 'POST') {
      if(!params.submitButton.contains("Cancel")){
        def m = new Measures()
        m.measureTitle = params.measureTitle
        m.measureDescription = params.measureDescription
        def i = Indicators.get(params.indicatorId)
        i.addToMeasures(m)
        if(!i.save(flush:true)){
          return [Measures:m, Iid:params.indicatorId]
        }
        if(!m.save(flush:true)){
          return [Measures:m, Iid:params.indicatorId]
        }
      }
      redirect(controller:"Admin")
    }

    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()
    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
    System.out.println("called")
  }

}
