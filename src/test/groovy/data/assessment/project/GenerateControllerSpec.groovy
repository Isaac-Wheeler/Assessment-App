package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@TestFor(GenerateController)
@Mock([Outcomes, Indicators, Courses, Teacher, Measures, Document, Assessment_Documentation, Settings])
class GenerateControllerSpec extends Specification {

    def setup() {
      def newSetting = new Settings(academicYear: "2017-2018")
      newSetting.save(flush:true)
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Outcome A", academicYear: "2017-2018")
      def newOutcome2 = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Outcome B", academicYear: "2017-2018")
      def newOutcome3 = new Outcomes(outcomeCategory: 'C', outcomeCategoryDescription: "Outcome C", academicYear: "2016-2017")
      def newOutcome4 = new Outcomes(outcomeCategory: 'D', outcomeCategoryDescription: "Outcome D", academicYear: "2017-2018")
      def newOutcome5 = new Outcomes(outcomeCategory: 'E', outcomeCategoryDescription: "Outcome E", academicYear: "2015-2016")
      def newOutcome6 = new Outcomes(outcomeCategory: 'F', outcomeCategoryDescription: "Outcome F", academicYear: "2015-2016")
      newOutcome.save(flush:true)
      newOutcome2.save(flush:true)
      newOutcome3.save(flush:true)
      newOutcome4.save(flush:true)
      newOutcome5.save(flush:true)
      newOutcome6.save(flush:true)

    }

    def cleanup() {
    }

    void "test index method and that the correct Outcomes are retrieved based upon the settings academic year"() {


      given: "A bunch of outcomes created in setup, and verifying that setup() worked correctly"
        //verify setup ran correctly before proceeding
        Settings.count() == 1
        Outcomes.count() == 6
        //if above tests passed then test will proceed with controller test

      when: "The index() method is invoked in the GenerateController"
        def model = controller.index()
        controller.response.reset()


      then: "model.Outcomes.size() should be equal to 3"
        model.Outcomes.size() == 3  //the index controller returns a map [Outcomes:outcomes] so we can test to make sure that outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Outcomes in the map returned

      when: "The settings academicSemester is changed the size of the Outcomes in the returned map should change as well!"
        Settings.first().academicYear = "2015-2016"
        def model2 = controller.index()
        controller.response.reset()


      then: "Model.Outcomes.size() should be equal to 2 now"
        model2.Outcomes.size() == 2  //the index controller returns a map [Outcomes:outcomes] so we can test to make sure that outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Outcomes in the map returned



    }
}
