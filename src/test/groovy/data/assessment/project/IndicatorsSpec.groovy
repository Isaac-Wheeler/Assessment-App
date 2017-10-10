package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class IndicatorsSpec extends Specification implements DomainUnitTest<Indicators> {

    def setup() {
        mockDomain(Outcomes)
    }

    def cleanup() {
    }

    void "testing adding and deleting new indicator + relationships"() {


      when: "creating a new outcome + indicator set for relationships"
      def a = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
      def b = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      a.addToIndicators(b)
      a.save()

        then: "outcome count should be 1 and indicator count should be 1"
        Outcomes.count() == 1
        Indicators.count() == 1

        when: "deleting the outcome and indicator"
        a.delete()
        b.delete()

          then: "outcome count should be 1 and indicator count should be 1"
          Outcomes.count() == 0
          Indicators.count() == 0



      /*when: 'adding a new indicator with valid properties'
      def u = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      u.save()

        then: 'New indicator should be saved successfully'
        Indicators.count() == 1

      when: 'deleting an indicator'
      u.delete()

        then: 'New indicator should be deleted successfully'
        Indicators.count() == 0 */


    }

    void "testing indicator constraints except for uniqueness"() {

      /*when: 'adding a new indicator with a blank indicatorName'
      def u = new Indicators(indicatorName: " ", indicatorDescription: "Students will be able to")
      u.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with a blank indicatorDescription'
      def aa = new Indicators(indicatorName: "a.1", indicatorDescription: " ")
      aa.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0


      when: 'adding a new indicator with less than 3 characters for indicatorName'
      def v = new Indicators(indicatorName: "a.", indicatorDescription: "Students will be able to")
      v.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0

      when: 'adding a new indicator with more than 4 characters for indicatorName'
      def w = new Indicators(indicatorName: "a.100", indicatorDescription: "Students will be able to")
      w.save()

        then: 'New indicator should not be saved successfully'
        Indicators.count() == 0 */




    }






}
