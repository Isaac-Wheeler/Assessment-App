package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class MeasuresSpec extends Specification implements DomainUnitTest<Measures> {

    def setup() {
    }

    def cleanup() {
    }

    void "Testing adding and deleting a new Measure"() {

      when: 'adding a new Measure with correct properties'
      def u = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to", indicatorId: 1, assessmentDoc: 1)
      u.save()

        then: 'New Measure should be saved successfully'
        Measures.count() == 1


      when: 'Removing a Measure'
      u.delete()

        then: 'New Measure should be removed successfully'
        Measures.count() == 0

    }

   void "Testing Measures constraints"() {


    when: 'adding a new Measure with the measureTitle blank'
    def u = new Measures(measureTitle: " ", measureDescription: "Student will be able to", indicatorId: 1, assessmentDoc: 1)
    u.save()

       then: 'New Measure should not be saved successfully because it violates the blank constraint'
       Measures.count() == 0

    when: 'adding a new Measure with the measureDescription blank'
    def v = new Measures(measureTitle: "Exam1_Q1", measureDescription: " ", indicatorId: 1, assessmentDoc: 1)
    v.save()

       then: 'New Measure should not be saved successfully because it violates the blank constraint'
       Measures.count() == 0

    when: 'adding a new Measure with the indicatorId blank'
    def w = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to", indicatorId: null, assessmentDoc: 1)
    w.save()

       then: 'New Measure should not be saved successfully because it violates the blank constraint'
       Measures.count() == 0


      //start of test for 2 measures with the same measureTitle
    when: 'adding a new Measure'
    def x = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to", indicatorId: 1, assessmentDoc: 1)
    x.save()

       then: 'New Measure should be added successfully'
       Measures.count() == 1

     when: 'adding another measure with the same measureTitle but different indicatorId'
     def y = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to", indicatorId: 2, assessmentDoc: 1)
     y.save()

       then: 'New Measure should be added successfully because it does not violate any constraints'
       Measures.count() == 2
       x.delete()
       y.delete()
       //end of test for 2 measures with the same measureTitle








  }

}
