package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.mock.web.MockMultipartFile
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


@TestFor(AssessmentsController)
@Mock([Outcomes, Indicators, Courses, Teacher, Measures, Document, Assessment_Documentation, Settings])
class AssessmentsControllerSpec extends Specification {

    def setup() {
      def newSetting = new Settings(academicYear: "2017-2018")
      newSetting.save(flush:true)
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to", academicYear: "2017-2018")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", academicYear: "2017-2018")
      def newMeasure = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
      newOutcome.addToIndicators(newIndicator)
      newIndicator.addToMeasures(newMeasure)
      newOutcome.save(flush:true)
    }

    def cleanup() {
    }

    void "testing index method for creating a new Assessment_Documentation"() {

          expect: "Setup() ran correctly"
            Settings.count() == 1
            Outcomes.count() == 1
            Indicators.count() == 1
            Measures.count() == 1



          when: "The index method is invoked and proper params are set for AD creation"
            params.targetGoal = "75"    //passed as string due to needed parseInt method
            params.needsImprovement = "10"    //passed as string due to needed parseInt method
            params.meetsExpectations = "12"   //passed as string due to needed parseInt method
            params.exceedsExpectations = "8"    //passed as string due to needed parseInt method
            params.comments = "Need to focus more on this material!"
            params.requiredAction = null
            params.resultComment = "target goal not met!"
            params.complete = true
            params.submitButton = "Submit"
            params.measureID = Measures.first().id    // the id from the only measure that was created in setup()

            Assessment_Documentation.count() == 0   // at this time there shouldn't be any AD's since none were saved yet
            request.method = 'POST'
            def file = new MockMultipartFile('myFile', 'Hello.docx', 'application/vnd.openxmlformats-officedocument.wordprocessingml.document' , "1234567" as byte[])   //create a new file to set as param for "myFile"
            request.addFile(file)   //add created file to the request under "myFile"
            controller.index()
            controller.response.reset()


          then: "The AD should have been saved successfully"
            Document.count() == 1   // file should have been saved
            Assessment_Documentation.count() == 1   // new AD should have been saved
            Assessment_Documentation.first().targetGoal == 75


          when: "The file delete method is called on an AD's file, then it should be deleted"
            def id =  Assessment_Documentation.first().documents.first().id
            controller.deleteFile(id)
            controller.response.reset()

          then: "The file should have been deleted successfully"
              Document.count() == 0


          when: "The edit method is called to edit an already existing AD"
            params.targetGoal = "80"    //passed as string due to needed parseInt method
            params.needsImprovement = "10"    //passed as string due to needed parseInt method
            params.meetsExpectations = "12"   //passed as string due to needed parseInt method
            params.exceedsExpectations = "8"    //passed as string due to needed parseInt method
            params.comments = "Need to focus more on this material!"
            params.requiredAction = null
            params.resultComment = "target goal not met!"
            params.complete = true
            params.submitButton = "Submit"
            params.measureID = Measures.first().id    // the id from the only measure that was created in setup()
            params.ADID = Assessment_Documentation.first().id
            request.method = 'POST'
            controller.editAssessment()
            controller.response.reset()


          then: "The AD should have been saved successfully"
            Assessment_Documentation.count() == 1   // new AD should have been saved
            Assessment_Documentation.first().targetGoal == 80


          when: "The delete method is called upon an AD, the AD should be deleted successfully"
          params.ad = Assessment_Documentation.first().id
          controller.delete()
          controller.response.reset()

          then: "AD should have been deleted successfully"
          Assessment_Documentation.count() == 0


    }
}
