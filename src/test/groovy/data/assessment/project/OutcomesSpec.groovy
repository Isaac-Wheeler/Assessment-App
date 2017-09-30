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
      def u = new Outcomes(outcome_category: 'a', outcome_category_description: "Students will learn how to")
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
      def u = new Outcomes(outcome_category: ' ', outcome_category_description: "Students will learn how to")
      u.save()

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

      when: 'Outcome category description is left blank'
      def v = new Outcomes(outcome_category: 'a', outcome_category_description: " ")
      v.save()

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

      when: 'Outcome category is more than 1 character'
      def w = new Outcomes(outcome_category: 'ab', outcome_category_description: "Students will learn how to")
      w.save()

        then: 'Outcome should not be saved'
        Outcomes.count() == 0

        //test for uniqueness
      when: 'Outcome category is added with correct fields and constraints'
      def x = new Outcomes(outcome_category: 'a', outcome_category_description: "Students will learn how to")
      x.save()

        then: 'Outcome should be saved'
        Outcomes.count() == 1


      when: 'Outcome category is added with an already taken outcome_category'
      def y = new Outcomes(outcome_category: 'a', outcome_category_description: "Students will learn how to")
      y.save()

        then: 'Outcome should not be saved because it violates the unique constraint on outcome_category'
        Outcomes.count() == 1
        //end of test for uniqueness

    }

}
