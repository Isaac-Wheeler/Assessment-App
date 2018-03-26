package data.assessment.project

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.oreilly.servlet.MultipartRequest;

class AssessmentsController {


  def index(){
    def outcomes = Outcomes.findAllByAcademicYear(BootStrap.GetYear(session))
    def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
    def classes = Classes.list()
    def measures = Measures.list()
    def year = BootStrap.GetYear(session)

    def mId = null
    def measure = null
    def AD = null

    if (request.method == 'POST' || params.courseLink) {
      if(!BootStrap.isPerm(false, session)){
        redirect(controller:'main')
      }else{

      if(!params.submitButton.contains("Cancel")){
        if(params.submitButton.startsWith('new_')){
          mId = params.submitButton-"new_"
          measure = Measures.get(Integer.parseInt(mId))
          System.out.println(measure)
          return [Outcomes:outcomes, Indicators:indicators, Classes:classes, measures:measures, measureID:mId, measure:measure, show:true, Year:year]
        }

      else{
          AD = new Assessment_Documentation()

          if(params.targetGoal != ""){
            AD.targetGoal = Integer.parseInt(params.targetGoal)
          }

          if (request.getFiles("myFile").get(0).isEmpty() == false) {   //code to handle all files uploaded and saving them/linking them to the current AD
          request.getFiles("myFile").each {
            def documentInstance = new Document();
            documentInstance.filename = it.originalFilename
            documentInstance.filedata = it.getBytes()
            AD.addToDocuments(documentInstance)
          }
      }

        //handles student section and meets exceeds and needs section
        if(params.needsImprovement != null){
        AD.needsImprovement = Integer.parseInt(params.needsImprovement)
        }
        if(params.meetsExpectations != null){
        AD.meetsExpectations = Integer.parseInt(params.meetsExpectations)
        }
        if(params.exceedsExpectations != null){
        AD.exceedsExpectations = Integer.parseInt(params.exceedsExpectations)
        }
        AD.numberOfStudents = AD.needsImprovement + AD.meetsExpectations + AD.exceedsExpectations




        if(params.comments != null){
          AD.comments = params.comments
        }
        if(params.requiredAction != null){
          AD.requiredAction = params.requiredAction
        }
        if(params.resultComment != null){
          AD.resultComment = params.resultComment
        }
        if(params.complete == null){
          AD.complete = false
        }else{
          AD.complete = params.complete
        }
        if(params.measureID != null){
          measure = Measures.get(params.measureID)
          AD.setMeasure(measure)
        }
        if(!AD.save(flush:true)){
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, measures:measures, measure:measure, show:true, Year:year]
        }
        redirect(controller:"Assessments")
      }
      }else{
        redirect(controller:"Assessments")
      }
    }
  }


    return [Outcomes:outcomes, Indicators:indicators, Classes:classes, measures:measures, Year:year]
  }

  def deleteFile(long id) {
      Document documentInstance = Document.get(id)
      if ( documentInstance == null) {
          System.out.println("Sorry! that document wasn't retreived correctly!")
      } else {
          documentInstance.delete(flush:true)
          redirect(controller:"Assessments")
      }

  }

  def downloadFile(long id) {
    Document documentInstance = Document.get(id)
    if ( documentInstance == null) {
        System.out.println("Sorry! that document wasn't retreived correctly!")
    } else {
        response.setContentType("APPLICATION/OCTET-STREAM")
        response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")
        def outputStream = response.getOutputStream()
        outputStream << documentInstance.filedata
        outputStream.flush()
        outputStream.close()
        }
      }



  def editAssessment() {
    def outcomes = Outcomes.findAllByAcademicYear(BootStrap.GetYear(session))
    def indicators = Indicators.findAllByAcademicYear(BootStrap.GetYear(session))
    def classes = Classes.list()
    def measures = Measures.list()
    def year = BootStrap.GetYear(session)
    def mId = null
    def measure = null
    def AD = null

    if (request.method == 'POST' || params.courseLink) {
      if(!BootStrap.isPerm(false, session)){
        redirect(controller:'main')
      }else{

      if(!params.submitButton.contains("Cancel")){
        if(params.submitButton.startsWith('edit_')){
          def ADId = params.submitButton-"edit_"
          AD = Assessment_Documentation.get(ADId)
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, measures:measures, measureID:AD.measure.id, show:true, Year:year]
        }

      else{
          AD = Assessment_Documentation.get(params.ADID)

          AD.targetGoal = Integer.parseInt(params.targetGoal)


          if (request.getFiles("myFile").get(0).isEmpty() == false) {   //code to handle all files uploaded and saving them/linking them to the current AD
          request.getFiles("myFile").each {
            def documentInstance = new Document();
            documentInstance.filename = it.originalFilename
            documentInstance.filedata = it.getBytes()
            AD.addToDocuments(documentInstance)
          }
      }

        //handles student section and meets exceeds and needs section
        AD.needsImprovement = Integer.parseInt(params.needsImprovement)
        AD.meetsExpectations = Integer.parseInt(params.meetsExpectations)
        AD.exceedsExpectations = Integer.parseInt(params.exceedsExpectations)
        AD.numberOfStudents = AD.needsImprovement + AD.meetsExpectations + AD.exceedsExpectations




        if(params.comments != null){
          AD.comments = params.comments
        }
        if(params.requiredAction != null){
          AD.requiredAction = params.requiredAction
        }
        if(params.resultComment != null){
          AD.resultComment = params.resultComment
        }
        if(params.academicSemester != null){
          AD.academicSemester = params.academicSemester
        }
        if(params.complete == null){
          AD.complete = false
        }else{
          AD.complete = params.complete
        }
        if(params.measureID != null){
          measure = Measures.get(params.measureID)
          AD.setMeasure(measure)
        }
        if(!AD.save(flush:true)){
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, measures:measures, show:true, Year:year]
        }
        redirect(controller:"Assessments")
      }
      }else{
        redirect(controller:"Assessments")
      }
    }
  }

    return [Outcomes:outcomes, Indicators:indicators, Classes:classes, measures:measures, Year:year]
  }

  def delete(){
    if(!BootStrap.isPerm(false, session)){
      redirect(controller:'main')
    }else{
    def ad = Assessment_Documentation.get(params.ad)
    ad.delete(flush:true)
    redirect(controller:"assessments")
    }
  }

}
