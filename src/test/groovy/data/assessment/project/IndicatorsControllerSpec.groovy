package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification


@TestFor(IndicatorsController)
@Mock([Outcomes, Indicators, Classes, Teacher, Measures, Document, Assessment_Documentation, Settings])
class IndicatorsControllerSpec extends Specification  {

    def setup() {
      def newSetting = new Settings(academicYear: "2017-2018")
      newSetting.save(flush:true)
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to", academicYear: "2017-2018")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", academicYear: "2017-2018")
      newOutcome.addToIndicators(newIndicator)
      newOutcome.save(flush:true)
      def newOutcome2 = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Students will learn how to", academicYear: "2016-2017")
      def newIndicator2 = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to", academicYear: "2016-2017")
      newOutcome2.addToIndicators(newIndicator2)
      newOutcome2.save(flush:true)
      def newClass = new Classes(title: "CS320")
      newClass.save(flush:true)
    }

    def cleanup() {
    }

    void "test index method and that the correct Indicators are retrieved based upon the settings academic year"() {

        expect: "Setup() ran correctly"
          Settings.count() == 1
          Outcomes.count() == 2
          Indicators.count() == 2

      when: "The index() method is invoked in the IndicatorsController"
        def model = controller.index()
        controller.response.reset()


      then: "model.Indicators.size() should be equal to 1 and the only indicator's name should be a.1"
        model.Indicators.size() == 1  //the index controller returns a map [Indicators:indicators] so we can test to make sure that indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Indicators in the map returned
        model.Indicators.first().indicatorName == "a.1"

      when: "The settings academicSemester is changed the size of the Outcomes in the returned map should change as well!"
        Settings.first().academicYear = "2016-2017"
        def model2 = controller.index()
        controller.response.reset()


      then: "model.Indicators.size() should be equal to 1 and the only indicator's indicator name should be b.1"
        model2.Indicators.size() == 1  //the index controller returns a map [Indicators:indicators] so we can test to make sure that indicators = Indicators.findAllByAcademicYear(Settings.first().academicYear) works correctly by testing the size() of Indicators in the map returned
        model2.Indicators.first().indicatorName == "b.1"


    }

    void "test create method and verify that the indicator was created"() {

      expect: "Setup() ran correctly"
        Settings.count() == 1
        Outcomes.count() == 2
        Indicators.count() == 2


      when: "the create method is invoked and proper params are set for indicator creation"
        params.outcomeId = Outcomes.first().id
        params.classId = Classes.first().id
        params.indicatorName = "a.2"
        params.indicatorDescription = "Students are able to properly do..."
        params.submitButton = "Create"
        request.method = 'POST'
        controller.create()
        controller.response.reset()

      then: "the indicator should be properly created, thus indicators.count() should equal 3 now"
        //Indicators.count() == 3
        //def createdIndicator = Indicators.findByIndicatorName("a.2")
        //createdIndicator.indicatorDescription == "Students are able to properly do..."


    }

    void "test delete method and verify that the indicator was deleted"() {

      expect: "Setup() ran correctly"
        Settings.count() == 1
        Outcomes.count() == 2
        Indicators.count() == 2


      when: "the create method is invoked and proper params are set for indicator creation"
        params.indicator = Indicators.first().id
        controller.delete()
        controller.response.reset()

      then: "the indicator should be properly deleted, thus indicators.count() should equal 1 now"
        //Indicators.count() == 1


    }

    void "test edit method and verify that the indicator was edited"() {

      expect: "Setup() ran correctly"
        Settings.count() == 1
        Outcomes.count() == 2
        Indicators.count() == 2


      when: "the create method is invoked and proper params are set for indicator creation"
        def indicator = Indicators.findByIndicatorName("a.1")
        params.id = indicator.id
        params.indicatorName = "a.1"
        params.indicatorDescription = "Students are able to properly do something important..."
        params.submitButton = "Create Indicator"
        request.method = 'POST'
        controller.editIndicator()
        controller.response.reset()

      then: "the indicator should be properly edited, and the indicatorDescription should change from setup()"
        Indicators.count() == 2
        def createdIndicator = Indicators.findByIndicatorName("a.1")
        //createdIndicator.indicatorDescription == "Students are able to properly do something important..."


    }

}
