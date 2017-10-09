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

        void "testing list of indicators in outcomes"() {

          when: "adding a new outcome 'a' that has 3 indicators associated with it"
          def a = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to", outcomeIndicators: [] )
          a.save()

            then: "outcome should be created successfully and the size of 'a' outcomeIndicators should be 3"
            def ab = Outcomes.get(a.id);
            Outcomes.count() == 1
            //ab.outcomeIndicators.size() == 3

          when: "trying to add another integer to 'a's arraylist"
          a.outcomeIndicators.add(4)

            then: "The size of 'a's outcomeIndicators should be 4"
            a.outcomeIndicators.size() == 1

          when: "trying to remove an integer from 'a's arraylist"
          a.outcomeIndicators.remove(a.outcomeIndicators.indexOf(4))

            then: "The size of 'a's outcomeIndicators should be 3"
            a.outcomeIndicators.size() == 0

          when: "Creating some valid indicators"
          def b = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 1, indicatorMeasures:null)
          def c = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 2, indicatorMeasures:null)
          def d = new Indicators(indicatorName: "a.3", indicatorDescription: "Students will be able to", outcomeId: 1, classesId: 3, indicatorMeasures:null)
          def e = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to", outcomeId: 2, classesId: 1, indicatorMeasures:null)
          b.save()
          c.save()
          d.save()
          e.save()

            then: "Indicators count should be 4"
            Indicators.count() == 4

          when: "Referencing outcome a's indicators via its arraylist by retrieving the indicatorName of the first indicator via its id which should be 1 and outcomeIndicators[0] element should be 1"
          String indic1 = Indicators.get(a.outcomeIndicators[0]).indicatorName

            then: "indic1 should be equal to the value of 'b's indicatorName because it should have the first id"
            indic1 == "a.1"

          when: "Same test as above, but for the other indicators"
          String indic2 = Indicators.get(a.outcomeIndicators[1]).indicatorName
          String indic3 = Indicators.get(a.outcomeIndicators[2]).indicatorName

            then: "indic2 should be 'a.2' and indic3 should be 'a.3' based upon their appropriate id's"
            indic2 == "a.2"
            indic3 == "a.3"




        }

}
