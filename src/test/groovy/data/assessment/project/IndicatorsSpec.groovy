package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class IndicatorsSpec extends Specification implements DomainUnitTest<Indicators> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing adding and deleting new indicator"() {

      when: 'adding a new indicator with valid properties'
      def u = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 1, indicatorMeasures:null)
      u.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 1

      when: 'deleting an indicator'
      u.delete()

        then: 'New indicator should be deleted successfully'
        Indicators.count() == 0


    }

    void "testing indicator constraints except for uniqueness"() {

      when: 'adding a new indicator with a blank indicatorName'
      def u = new Indicators(indicatorName: " ", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 1, indicatorMeasures:null)
      u.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with a blank indicatorDescription'
      def aa = new Indicators(indicatorName: "a.1", indicatorDescription: " ", outcomeId: 1, classesId: 7, indicatorMeasures:null)
      aa.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with a blank outcomeId'
      def bb = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: null, classesId: 7, indicatorMeasures:null)
      bb.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with a blank classesId'
      def cc = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: null, indicatorMeasures:null)
      cc.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with less than 3 characters for indicatorName'
      def v = new Indicators(indicatorName: "a.", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 2, indicatorMeasures:null)
      v.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with more than 4 characters for indicatorName'
      def w = new Indicators(indicatorName: "a.100", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 3, indicatorMeasures:null)
      w.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0




    }

    void "testing indicator constraints, specifically uniqueness"() {
      //start of unique constrint test. Will test that an indicator cannot be saved if the indicatorName, outcomeId, and classesId all match with another already existing indicator
      when: 'adding a new indicator with valid properties'
      def u = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 2, classesId: 1, indicatorMeasures:null)
      u.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 1


      //clearing out any saved indicators
      u.delete()
      expect:
      Indicators.count() == 0
      //end of clearing indicators

      //series of tests to show that as long as a new indicator does not have values that match exactly with indicatorName, outcomeId, AND classesId together
      //then any other combination can match
      when: 'adding a new indicator with valid properties'
      def aa = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 2, classesId: 2, indicatorMeasures:null)
      aa.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 1

      when: 'adding a new indicator with matching indicatorName and matching outcomeId, but different classesId'
      def bb = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 2, classesId: 3, indicatorMeasures:null)
      bb.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 2

      when: 'adding a new indicator with matching indicatorName and matching classesId, but different outcomeId'
      def cc = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 3, classesId: 3, indicatorMeasures:null)
      cc.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 3

      when: 'adding a new indicator with matching outcomeId and matching classesId, but different indicatorName'
      def dd = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to", outcomeId: 3, classesId: 3, indicatorMeasures:null)
      dd.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 4




    }







}
