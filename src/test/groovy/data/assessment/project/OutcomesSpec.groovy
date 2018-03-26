package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OutcomesSpec extends Specification implements DomainUnitTest<Outcomes> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing adding and deleting an Outcome"() {

      given: "A brand new outcome"
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to")

      when: "The outcome is saved"
      newOutcome.save(flush:true)

      then: "Is saved successfully and can be found in the DB"
      newOutcome.errors.errorCount == 0
      newOutcome.id != null
      Outcomes.get(newOutcome.id).outcomeCategory == "A"

      when: "A property is changed changed"
      def foundOutcome = Outcomes.get(newOutcome.id)
      foundOutcome.outcomeCategory = "B"
      foundOutcome.save(flush:true)

      then: "the change should be reflected in the DB"
      Outcomes.get(newOutcome.id).outcomeCategory == "B"

      when: "outcome is deleted"
      foundOutcome.delete(flush:true)

      then: "the outcome is removed from the DB"
      !Outcomes.exists(foundOutcome.id)
      !Outcomes.exists(newOutcome.id)


    }

    void "testing Outcome constraints"() {

      given: "an outcome has fields that fail constraints"
      def newOutcome = new Outcomes(outcomeCategory: ' ', outcomeCategoryDescription: " ")

      when: "outcome is validated"
      newOutcome.validate()

      then:
      !newOutcome.validate(['outcomeCategory'])
      //newOutcome.errors['outcomeCategory'].code == 'typeMismatch'   // convertEmptyStringsToNull grails property
      !newOutcome.validate(['outcomeCategoryDescription'])
      newOutcome.errors['outcomeCategoryDescription'].code == 'nullable'



    }

    void "testing list of indicators in outcomes"() {

      when: "creating a couple of indicators and outcomes to link the indicators to"
      def a = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def b = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to")
      def c = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to")
      def d = new Indicators(indicatorName: "b.2", indicatorDescription: "Students will be able to")
      def e = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to")
      def f = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Students will learn how to")
      e.addToIndicators(a)
      e.addToIndicators(b)
      f.addToIndicators(c)
      f.addToIndicators(d)
      e.save(flush:true)
      f.save(flush:true)

        then: "the 4 indicators and the 2 outcomes should have been saved correctly"
        Outcomes.count() == 2
        Indicators.count() == 4

      when : "Finding all indicators associated with outcome A and indicators associated with outcome B"
      def aa = Outcomes.findByOutcomeCategory("A")
      def bb = Outcomes.findByOutcomeCategory("B")

        then: "There should be 2 Indicators associated with A and 2 Indicators associated with B"
        aa.indicators.size() == 2
        bb.indicators.size() == 2



    }

}
