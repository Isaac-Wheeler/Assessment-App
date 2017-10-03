package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class OutcomesSpec extends Specification implements DomainUnitTest<Outcomes> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing adding and deleting an Outcome"() {

      when: 'Adding a new Outcome "a" with correct fields '
      def u = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to", outcomeIndicators: null)
      u.save()

        then: 'Outcome should be saved successfully'
        Outcomes.count() == 1

      when: 'Removing an Outcome'
      u.delete()

        then: 'Outcome should be deleted successfully'
        Outcomes.count() == 0


    }

    void "testing Outcome constraints"() {

      when: 'Outcome category is left blank'
      def u = new Outcomes(outcomeCategory: ' ', outcomeCategoryDescription: "Students will learn how to", outcomeIndicators: null)
      u.save()

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

      when: 'Outcome category description is left blank'
      def v = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: " ", outcomeIndicators: null)
      v.save()

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

      when: 'Outcome category is more than 1 character'
      def w = new Outcomes(outcomeCategory: 'ab', outcomeCategoryDescription: "Students will learn how to", outcomeIndicators: null)
      w.save()

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

        //test for uniqueness
      when: 'Outcome category is added with correct fields and constraints'
      def x = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to", outcomeIndicators: null)
      x.save()

        then: 'Outcome should be saved'
        Outcomes.count() == 1


      when: 'Outcome category is added with an already taken outcomeCategory'
      def y = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to", outcomeIndicators: null)
      y.save()

        then: 'Outcome should not be saved because it violates the unique constraint on outcomeCategory'
        Outcomes.count() == 1
        //end of test for uniqueness

    }

      void "testing relationship among outcomes and indicators"() {

        when: 'Adding many new Outcomes '
        def u = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to blah", outcomeIndicators: null)
        def v = new Outcomes(outcomeCategory: 'b', outcomeCategoryDescription: "Students will learn how to blah blah", outcomeIndicators: null)
        def w = new Outcomes(outcomeCategory: 'c', outcomeCategoryDescription: "Students will learn how to blah blah blah", outcomeIndicators: null)
        u.save()
        v.save()
        w.save()

          then: 'Outcome should be saved successfully'
          Outcomes.count() == 3



      }

}
