package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class IndicatorsSpec extends Specification implements DomainUnitTest<Indicators> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing adding and deleting an Indicator"() {

      given: "A brand new indicator"
      def newOutcome = new Outcomes(OutcomeCategory: 'A', OutcomeCategoryDescription: "Students will learn how to")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      newOutcome.addToIndicators(newIndicator)

      when: "The indicator is saved"
      newOutcome.save(flush:true)

      then: "Is saved successfully and can be found in the DB"
      newIndicator.errors.errorCount == 0
      newIndicator.id != null
      Indicators.get(newIndicator.id).indicatorName == "a.1"

      when: "A property is changed changed"
      def foundIndicator = Indicators.get(newIndicator.id)
      foundIndicator.indicatorName = "b.1"
      foundIndicator.save(flush:true)

      then: "the change should be reflected in the DB"
      Indicators.get(newIndicator.id).indicatorName == "b.1"

      when: "Indicator is deleted"
      foundIndicator.delete(flush:true)

      then: "the Indicator is removed from the DB"
      !Indicators.exists(foundIndicator.id)
      !Indicators.exists(newIndicator.id)


    }

    void "testing indicator constraints"() {

      given: "an Indicator has fields that fail constraints"
      def newIndicator = new Indicators(indicatorName: " ", indicatorDescription: " ")


      when: "Indicator is validated"
      newIndicator.validate()

      then:
      !newIndicator.validate(['indicatorName'])
      newIndicator.errors['indicatorName'].code == 'nullable'   // convertEmptyStringsToNull grails property
      !newIndicator.validate(['indicatorDescription'])
      newIndicator.errors['indicatorDescription'].code == 'nullable'


        //test for uniqueness
    /*  when: 'Indicator is added with correct fields and constraints'

      def newOutcome = new Outcomes(OutcomeCategory: 'A', OutcomeCategoryDescription: "Students will learn how to")
      newOutcome.save(flush:true)
      def newIndicator2 = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def newIndicator3 = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to blah")
      newOutcome.addToIndicators(newIndicator2)
      newOutcome.save(flush:true)
      newOutcome.addToIndicators(newIndicator3)
      newOutcome.save(flush: true)

        then: 'Indicator should be saved'
        Indicators.count() == 1 */


        //end of test for uniqueness


    }

    void "testing indicator/Outcome-Indicator relationship Querying"() {

      given: "creating a couple of indicators and outcomes to link the indicators to"
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def newIndicator2 = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to")
      def newIndicator3 = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to")
      def newIndicator4 = new Indicators(indicatorName: "b.2", indicatorDescription: "Students will be able to")
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to")
      def newOutcome2 = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Students will learn how to")
      newOutcome.addToIndicators(newIndicator)
      newOutcome.addToIndicators(newIndicator2)
      newOutcome2.addToIndicators(newIndicator3)
      newOutcome2.addToIndicators(newIndicator4)
      newOutcome.save(flush:true)
      newOutcome2.save(flush:true)

      when: "Querying for the data in the DB"
      def aa = Indicators.findAllByIndicatorNameLike("%a%")
      def bb = Indicators.findAllByIndicatorNameLike("%b%")

        then: "aa size should be 2 as well as bb size should be 2"
        aa.size() == 2
        bb.size() == 2

      when: "Querying for the data in the DB through the Outcomes to Indicators"
      def cc = Outcomes.createCriteria().list() {
            indicators {
                eq('indicatorName', "b.1")
            }
        }
      def dd = Outcomes.createCriteria().list() {
            indicators {
                like('indicatorName', "a%")
            }
        }


        then: "aa size should be 2 as well as bb size should be 2"
        cc.size() == 1
        cc[0].outcomeCategory == 'B'
        dd.size() == 1
        dd[0].outcomeCategory == "A"



    }

}
