package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OutcomesSpec extends Specification implements DomainUnitTest<Outcomes> {

    def setup() {
      mockDomain(Indicators)
    }

    def cleanup() {
    }

    void "testing adding and deleting an Outcome"() {

      when: 'Adding a new Outcome "a" with correct properties '
      def u = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
      u.save(flush: true)

        then: 'Outcome should be saved successfully'
        Outcomes.count() == 1

      when: 'Removing an Outcome'
      def toBeDeleted = Outcomes.get(1)
      toBeDeleted.delete(flush: true)

        then: 'Outcome should be deleted successfully'
        Outcomes.count() == 0


    }

    void "testing Outcome constraints"() {

      when: 'Outcome category is left blank'
      def u = new Outcomes(outcomeCategory: ' ', outcomeCategoryDescription: "Students will learn how to")
      u.save(flush: true)

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

      when: 'Outcome category description is left blank'
      def v = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: " ")
      v.save(flush: true)

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

      when: 'Outcome category is more than 1 character'
      def w = new Outcomes(outcomeCategory: 'ab', outcomeCategoryDescription: "Students will learn how to")
      w.save(flush: true)

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

        //test for uniqueness
      when: 'Outcome category is added with correct fields and constraints'
      def x = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
      x.save(flush: true)

        then: 'Outcome should be saved'
        Outcomes.count() == 1


      when: 'Outcome category is added with an already taken outcomeCategory'
      def y = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
      y.save(flush: true)

        then: 'Outcome should not be saved because it violates the unique constraint on outcomeCategory'
        Outcomes.count() == 1
        //end of test for uniqueness

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
      e.save()
      f.save()

        then: "the 4 indicators and the 2 outcomes should have been saved correctly"
        Outcomes.count() == 2
        Indicators.count() == 4

      when : "Finding all indicators associated with outcome A and indicators associated with outcome B"
      def aa = Outcomes.findByOutcomeCategory("A")
      def bb = Outcomes.findByOutcomeCategory("B")

        then: "There should be 2 Indicators associated with A and 2 Indicators associated with B"
        aa.indicators.size() == 2
        bb.indicators.size() == 2

      when : "Deleting an outcome"
      f.delete()

        then: "All indicators associated with deleted outcome should also be deleted"
        Outcomes.count() == 1
        Indicators.count() == 4


    }

}
