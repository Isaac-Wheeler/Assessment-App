package data.assessment.project

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.oreilly.servlet.MultipartRequest;

class AssessmentsController {


  def index(){
    //def outcomes = Outcomes.findAllByAcademicYear(Settings.get(1).academicYear)
    //def indicators = Indicators.findAllByAcademicYear(Settings.get(1).academicYear)
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()
    def measures = Measures.list()

    def mId = null
    def measure = null
    def AD = null

    if (request.method == 'POST' || params.courseLink) {

      if(!params.submitButton.contains("Cancel")){
        if(params.submitButton.startsWith('new_')){
          mId = params.submitButton-"new_"
          return [Outcomes:outcomes, Indicators:indicators, Classes:classes, measureID:mId, show:true]
        }

      else{
          AD = new Assessment_Documentation()

          AD.targetGoal = Integer.parseInt(params.targetGoal)


          if (request.getFiles("myFile").get(0).isEmpty() == false) {   //code to handle all files uploaded and saving them/linking them to the current AD
          request.getFiles("myFile").each {
            def documentInstance = new Document();
            documentInstance.filename = it.originalFilename
            documentInstance.filedata = it.getBytes()
            AD.addToDocuments(documentInstance)
            //if (documentInstance.validate()) {
              //documentInstance.save(flush:true)
              //}
            //else {
                //  documentInstance.errors.allErrors.each {
                  //    println it
                  //}
            //}
          }
      }

        //handles student section and meets exceeds and needs section
        AD.needsImprovement = Integer.parseInt(params.needsImprovement)
        AD.meetsExpectations = Integer.parseInt(params.meetsExpectations)
        AD.exceedsExpectations = Integer.parseInt(params.exceedsExpectations)
        AD.numberOfStudents = AD.needsImprovement + AD.meetsExpectations + AD.exceedsExpectations

        if(params.summary != null){
          AD.summary = params.summary
        }
        if(params.assessmentDocTitle != null){
          AD.assessmentDocTitle = params.assessmentDocTitle
        }
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
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, show:true]
        }
        redirect(controller:"Assessments")
      }
      }else{
        redirect(controller:"Assessments")
      }
    }


    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
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
    //def outcomes = Outcomes.findAllByAcademicYear(Settings.get(1).academicYear)
    //def indicators = Indicators.findAllByAcademicYear(Settings.get(1).academicYear)
    def outcomes = Outcomes.list()
    def indicators = Indicators.list()
    def classes = Classes.list()
    def measures = Measures.list()
    def mId = null
    def measure = null
    def AD = null

    if (request.method == 'POST' || params.courseLink) {

      if(!params.submitButton.contains("Cancel")){
        if(params.submitButton.startsWith('edit_')){
          def ADId = params.submitButton-"edit_"
          AD = Assessment_Documentation.get(ADId)
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, measureID:AD.measure.id, show:true]
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
          //  if (documentInstance.validate()) {
              //documentInstance.save(flush:true)
            //  }
          //  else {
              //    documentInstance.errors.allErrors.each {
                  //    println it
                //  }
          //  }
          }
      }

        //handles student section and meets exceeds and needs section
        AD.needsImprovement = Integer.parseInt(params.needsImprovement)
        AD.meetsExpectations = Integer.parseInt(params.meetsExpectations)
        AD.exceedsExpectations = Integer.parseInt(params.exceedsExpectations)
        AD.numberOfStudents = AD.needsImprovement + AD.meetsExpectations + AD.exceedsExpectations

        if(params.summary != null){
          AD.summary = params.summary
        }
        if(params.assessmentDocTitle != null){
          AD.assessmentDocTitle = params.assessmentDocTitle
        }
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
          return [assessment_documents:AD, Outcomes:outcomes, Indicators:indicators, Classes:classes, show:true]
        }
        redirect(controller:"Assessments")
      }
      }else{
        redirect(controller:"Assessments")
      }
    }

    return [Outcomes:outcomes, Indicators:indicators, Classes:classes]
  }

  def delete(){
    def ad = Assessment_Documentation.get(params.ad)
    ad.delete(flush:true)
    redirect(controller:"assessments")
  }

}
