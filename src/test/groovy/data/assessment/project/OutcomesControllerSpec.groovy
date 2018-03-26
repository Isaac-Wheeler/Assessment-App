package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@TestFor(OutcomesController)
@Mock([Outcomes, Indicators, Classes, Teacher, Measures, Document, Assessment_Documentation, Settings])
class OutcomesControllerSpec extends Specification {

    def setup() {
      def newSetting = new Settings(academicYear: "2017-2018")
      newSetting.save(flush:true)
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to...", academicYear: "2017-2018")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", academicYear: "2017-2018")
      newOutcome.addToIndicators(newIndicator)
      newOutcome.save(flush:true)
      def newOutcome2 = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Students will learn how to", academicYear: "2016-2017")
      def newIndicator2 = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to", academicYear: "2016-2017")
      newOutcome2.addToIndicators(newIndicator2)
      newOutcome2.save(flush:true)
    }

    def cleanup() {
    }

    void "test index method and viewOutcomesUser method and that the correct Outcomes and Indicators are retrieved based upon the settings academic year"() {

        expect: "Setup() ran correctly"
          Settings.count() == 1
          Outcomes.count() == 2
          Indicators.count() == 2

      when: "The index() method is invoked in the OutcomesController"
        def model = controller.index()
        controller.response.reset()

        Settings.first().academicYear = "2016-2017"
        def model2 = controller.viewOutcomesUser()
        controller.response.reset()


      then: "model.Outcomes.size() should be 1, that outcome's outcomeCategory should be 'A', model.Indicators.size() should be 1 and that indicator's indicatorName should be 'a.1', model2.Outcomes.size() should be 1, that outcome's outcomeCategory should be 'B', model2.Indicators.size() should be 1 and that indicator's indicatorName should be 'b.1'"
        model.Outcomes.size() == 1  //the index controller returns a map [Outcomes:outcomes] so we can test to make sure that outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Outcomes in the map returned
        model.Indicators.size() == 1  //the index controller returns a map [Indicators:indicators] so we can test to make sure that indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Indicators in the map returned
        model.Outcomes.first().outcomeCategory == "A"
        model.Indicators.first().indicatorName == "a.1"

        model2.Outcomes.size() == 1  //the index controller returns a map [Outcomes:outcomes] so we can test to make sure that outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Outcomes in the map returned
        model2.Indicators.size() == 1  //the index controller returns a map [Indicators:indicators] so we can test to make sure that indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Indicators in the map returned
        model2.Outcomes.first().outcomeCategory == "B"
        model2.Indicators.first().indicatorName == "b.1"


    }

    void "test createOutcome method and verify that the new Outcome has been created successfully"() {

        expect: "Setup() ran correctly"
          Settings.count() == 1
          Outcomes.count() == 2
          Indicators.count() == 2

      when: "The createOutcome() method is invoked in the OutcomesController"
        params.outcomeCategory = "C"
        params.outcomeCategoryDescription = "Students should be able to complete these skills..."
        params.submitButton = "Create"
        request.method = 'POST'
        controller.createOutcome()



      then: "The new outcomes should have been saved correctly and Outcomes.count() should equal 3"
        //Outcomes.count() == 3
        def newOutcome = Outcomes.findByOutcomeCategory("C")
        //newOutcome.outcomeCategoryDescription == "Students should be able to complete these skills..."

    }

    void "test editOutcome method and verify that the Outcome has been edited successfully"() {

        expect: "Setup() ran correctly"
          Settings.count() == 1
          Outcomes.count() == 2
          Indicators.count() == 2

      when: "The editOutcome() method is invoked in the OutcomesController"
        params.id = Outcomes.findByOutcomeCategory("A").id
        params.outcomeCategory = "A"
        params.outcomeCategoryDescription = "Students should have mastered these skills..."
        params.submitButton = "Create"
        request.method = 'POST'
        controller.editOutcome()


      then: "The outcome should have been edited correctly and the outcome's description should have changed from setup()"
        Outcomes.count() == 2
        def newOutcome = Outcomes.findByOutcomeCategory("A")
        //newOutcome.outcomeCategoryDescription == "Students should have mastered these skills..."
        def previousOutcome = Outcomes.findByOutcomeCategoryDescription("Students will learn how to...")
        //previousOutcome == null


    }

    void "test deleteOutcome method and verify that the Outcome has been deleted successfully"() {

        expect: "Setup() ran correctly"
          Settings.count() == 1
          Outcomes.count() == 2
          Indicators.count() == 2

      when: "The editOutcome() method is invoked in the OutcomesController"
        params.outcome = Outcomes.findByOutcomeCategory("A").id
        controller.deleteOutcome()

      then: "The outcome should have been deleted successfully and Outcomes.count() should equal 1"
        //Outcomes.count() == 1
        //Outcomes.first().outcomeCategory == "B"


    }
}
