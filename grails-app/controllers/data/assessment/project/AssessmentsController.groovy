package data.assessment.project
<<<<<<< HEAD
import grails.validation.Validateable
import org.springframework.web.multipart.MultipartFile
=======

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.oreilly.servlet.MultipartRequest;
>>>>>>> 489ad93755f942a282dee3d2c4f22d64d8194d60

class AssessmentsController {

  def editAssessment() {
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()

<<<<<<< HEAD

=======
    if(request instanceof MultipartHttpServletRequest)
    {
      MultipartHttpServletRequest mpr = (MultipartHttpServletRequest)request;
      CommonsMultipartFile f = (CommonsMultipartFile) mpr.getFile("myFile");
      if(!f.empty)
        flash.message = 'success'
      else
       flash.message = 'file cannot be empty'
    }
    else
      flash.message = 'request is not of type MultipartHttpServletRequest'
>>>>>>> 489ad93755f942a282dee3d2c4f22d64d8194d60

    if (request.method == 'POST') {
    def upload() {
      if(!params.submitButton.contains("Cancel")){
        if(!params.submitButton.startsWith('edit_')){
        def mId = null
        def measure = null
        if(params.submitButton.startsWith('add_')){
          mId = params.submitButton-"add_"
          measure = Measures.get(mId)
        }
        def AD = new Assessment_Documentation()
        AD.targetGoal = Integer.parseInt(params.targetGoal)
        //workUsed;     **leaving as a comment for now until ready to implement file uploads.
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
          measure = Measures.get(params.measureID)
        }
        AD.setMeasure(measure)
        if(!AD.save(flush:true)){
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes]
        }
      }else{
        System.out.println(params)
        def ADId = params.submitButton-"edit_"
        def AD = Assessment_Documentation.get(ADId)

        return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, measureID:AD.measure.id]
      }
      }
    }

    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
    System.out.println("called")
  }

  def viewMeasuresAdmin() {
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
