package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@TestFor(SettingsController)
@Mock([Outcomes, Indicators, Classes, Teacher, Measures, Document, Assessment_Documentation, Settings])
class SettingsControllerSpec extends Specification {

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

    void "test something"() {

      expect:
        Settings.count() == 1
        Outcomes.count() == 1
        Indicators.count() == 1
        Measures.count() == 1


      when: "The index() method is invoked in the SettingsController"
        params.academicYear = "2018-2019"
        request.method = 'POST'
        def model =  controller.index()
        controller.response.reset()

      then: "the Outcomes and Indicators should be copied objects and given the new academicYear!"
        model.year == "2018-2019"
        def mirrorOutcome = Outcomes.findByAcademicYear("2018-2019")
        mirrorOutcome.outcomeCategory == 'A'



    }
}
