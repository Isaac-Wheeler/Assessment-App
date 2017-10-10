package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MeasuresSpec extends Specification implements DomainUnitTest<Measures> {

    def setup() {
      mockDomain(Indicators)
      mockDomain(Outcomes)
    }

    def cleanup() {
    }

    void "Testing adding and deleting a new Measure"() {

      when: 'adding a new Measure with correct properties'
      def aa = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
      def a = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def b = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
      aa.addToIndicators(a)
      a.addToMeasures(b)
      aa.save()

        then: 'New Measure should be saved successfully'
        Outcomes.count() == 1
        Indicators.count() == 1
        Measures.count() == 1


      when: 'Removing a Measure'
      b.delete()
      a.delete()
      aa.delete()

        then: 'New Measure should be removed successfully'
        Indicators.count() == 0
        Measures.count() == 0
        Outcomes.count() == 0

    }

   void "Testing Measures constraints"() {


    when: 'adding a new Measure with the measureTitle blank'
    def u = new Measures(measureTitle: " ", measureDescription: "Student will be able to")
    u.save()

       then: 'New Measure should not be saved successfully because it violates the blank constraint'
       Measures.count() == 0

    when: 'adding a new Measure with the measureDescription blank'
    def v = new Measures(measureTitle: "Exam1_Q1", measureDescription: " ")
    v.save()

       then: 'New Measure should not be saved successfully because it violates the blank constraint'
       Measures.count() == 0

      //start of test for 2 measures with the same measureTitle
    when: 'adding a new Measure'
    def aa = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
    def a = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
    def x = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
    aa.addToIndicators(a)
    a.addToMeasures(x)
    aa.save()

       then: 'New Measure should be added successfully'
       Indicators.count() == 1
       Measures.count() == 1
       Outcomes.count() == 1


     when: 'adding another measure with the same measureTitle'
     def y = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
     a.addToMeasures(y)
     aa.save()

       then: 'New Measure should be added successfully because it does not violate any constraints'
       Indicators.count() == 1
       Measures.count() == 1
       Outcomes.count() == 1

    when: "deleting the indicator and measure"
    x.delete()
    a.delete()
    aa.delete()

      then: "counts should go to 0"
      Indicators.count() == 0
      Measures.count() == 0
      Outcomes.count() == 0

       //end of test for 2 measures with the same measureTitle








  }

}
