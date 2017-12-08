package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@TestFor(MeasuresController)
@Mock([Outcomes, Indicators, Classes, Teacher, Measures, Document, Assessment_Documentation, Settings])
class MeasuresControllerSpec extends Specification {

    def setup() {
      def newSetting = new Settings(academicYear: "2017-2018")
      newSetting.save(flush:true)
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to", academicYear: "2017-2018")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", academicYear: "2017-2018")
      def newMeasure = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
      newOutcome.addToIndicators(newIndicator)
      newIndicator.addToMeasures(newMeasure)
      newOutcome.save(flush:true)
      def newClass = new Classes(title: "CS320")
      newClass.save(flush:true)
    }

    def cleanup() {
    }

    void "test viewMeasuresAdmin method and that the correct Measures and Classes are retrieved based upon the settings academic year"() {

        expect: "Setup() ran correctly"
          Settings.count() == 1
          Outcomes.count() == 1
          Indicators.count() == 1
          Measures.count() == 1

        when: "The viewMeasureAdmin() method is invoked in the MeasuresController"
          def model = controller.viewMeasuresAdmin()
          controller.response.reset()


        then: "model.Measures.size() should be equal to 1 and model.Classes.size() should be equal to 1"
          model.Measures.size() == 1

      }

      void "test viewMeasuresUser method and that the correct Measures and Classes are retrieved based upon the settings academic year"() {

          expect: "Setup() ran correctly"
            Settings.count() == 1
            Outcomes.count() == 1
            Indicators.count() == 1
            Measures.count() == 1

          when: "The viewMeasureUser() method is invoked in the MeasuresController"
            def model = controller.viewMeasuresUser()
            controller.response.reset()


          then: "model.Measures.size() should be equal to 1 and model.Classes.size() should be equal to 1"
            model.Measures.size() == 1

        }

        void "test create method and that the new measure was created correctly"() {

            expect: "Setup() ran correctly"
              Settings.count() == 1
              Outcomes.count() == 1
              Indicators.count() == 1
              Measures.count() == 1

            when: "The create method is invoked in the MeasuresController"
              params.measureTitle = "Exam2_Question5"
              params.measureDescription = "Student was able to properly demonstrate indicator task by...."
              params.indicatorId = Indicators.first().id
              params.isadmin = true
              params.submitButton = "Create"
              request.method = 'POST'
              controller.create()



            then: "Measure.count() should equal 2 now since a new one was created and only 1 existed from setup() and the redirectedUrl should go to viewMeasureAdmin since the user is an Admin"
              Measures.count() == 2
              def createdMeasure = Measures.findByMeasureTitle("Exam2_Question5")
              createdMeasure.measureDescription == "Student was able to properly demonstrate indicator task by...."
              response.redirectedUrl == '/measures/viewMeasuresAdmin'
              controller.response.reset()


            when: "The create method is invoked in the MeasuresController"
              params.measureTitle = "Exam2_Question10"
              params.measureDescription = "Student was able to properly locate error by...."
              params.indicatorId = Indicators.first().id
              params.isadmin = false
              params.submitButton = "Create"
              request.method = 'POST'
              controller.create()


            then: "Measure.count() should equal 3 now since a new one was created and only 2 existed from setup() + previous create() call and the redirectedUrl should go to viewMeasureUser since the user is not an Admin"
              Measures.count() == 3
              def createdMeasure2 = Measures.findByMeasureTitle("Exam2_Question10")
              createdMeasure2.measureDescription == "Student was able to properly locate error by...."
              response.redirectedUrl == '/measures/viewMeasuresUser'
              controller.response.reset()

          }

          void "test edit method and that the new measure was edited correctly"() {

              expect: "Setup() ran correctly"
                Settings.count() == 1
                Outcomes.count() == 1
                Indicators.count() == 1
                Measures.count() == 1

              when: "The edit method is invoked in the MeasuresController"
                params.id = Measures.first().id
                params.indicatorId = Indicators.first().id
                params.measureTitle = "Exam2_Question4"
                params.measureDescription = "Student was able to located the issue with...."
                params.isadmin = true
                params.submitButton = "Create"
                request.method = 'POST'
                controller.edit()

              then: "The measure was edited correctly, Measures.count() == 1 still, and the indicator was properly edited by evidence that the old measureTitle cannot be found in the DB"
                Measures.count() == 1
                def createdMeasure2 = Measures.findByMeasureTitle("Exam2_Question4")
                createdMeasure2.measureDescription == "Student was able to located the issue with...."
                def previousMeasure = Measures.findByMeasureTitle("Exam1_Q1")
                previousMeasure == null

              }

              void "test delete method and that the measure is deleted correctly by an Admin"() {

                  expect: "Setup() ran correctly"
                    Settings.count() == 1
                    Outcomes.count() == 1
                    Indicators.count() == 1
                    Measures.count() == 1

                  when: "The delete method is invoked in the MeasuresController"
                    params.measure = Measures.first().id
                    params.isadmin = true
                    controller.delete()

                  then: "Measures.count() should equal 0 because the only measure was deleted and the redirectedUrl should send the user to viewMeasureAdmin because the user is an Admin"
                    Measures.count() == 0
                    response.redirectedUrl == '/measures/viewMeasuresAdmin'

              }

              void "test delete method and that the measure is deleted correctly by a non-Admin"() {

                  expect: "Setup() ran correctly"
                    Settings.count() == 1
                    Outcomes.count() == 1
                    Indicators.count() == 1
                    Measures.count() == 1

                  when: "The delete method is invoked in the MeasuresController"
                    params.measure = Measures.first().id
                    params.isadmin = false
                    controller.delete()

                  then: "Measures.count() should equal 0 because the only measure was deleted and the redirectedUrl should send the user to viewMeasureuser because the user is not an Admin"
                    Measures.count() == 0
                    response.redirectedUrl == '/measures/viewMeasuresUser'

              }

}
