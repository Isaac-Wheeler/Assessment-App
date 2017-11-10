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

      given: 'adding a new Measure with correct properties'
      def newOutcome = new Outcomes(outcomeCategory: 'a', outcomeCategoryDescription: "Students will learn how to")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def newMeasure = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
      newOutcome.addToIndicators(newIndicator)
      newIndicator.addToMeasures(newMeasure)
      newOutcome.save(flush:true)

      when: "The measure is saved"
      newOutcome.save(flush:true)

      then: "Is saved successfully and can be found in the DB"
      newMeasure.errors.errorCount == 0
      newMeasure.id != null
      Measures.get(newMeasure.id).measureTitle == "Exam1_Q1"

      when: "A property is changed changed"
      def foundMeasure = Measures.get(newMeasure.id)
      foundMeasure.measureTitle = "Exam2_Q2"
      foundMeasure.save(flush:true)

      then: "the change should be reflected in the DB"
      Measures.get(newMeasure.id).measureTitle == "Exam2_Q2"

      when: "Measure is deleted"
      foundMeasure.delete(flush:true)

      then: "the Measure is removed from the DB"
      !Measures.exists(foundMeasure.id)
      !Measures.exists(newMeasure.id)


    }

   void "Testing Measures constraints"() {

     given: "an Indicator has fields that fail constraints"
     def newMeasure = new Measures(measureTitle: " ", measureDescription: " ")


     when: "Indicator is validated"
     newMeasure.validate()

     then:
     !newMeasure.validate(['measureTitle'])
     newMeasure.errors['measureTitle'].code == 'nullable'   // convertEmptyStringsToNull grails property
     !newMeasure.validate(['measureDescription'])
     newMeasure.errors['measureDescription'].code == 'nullable'




  }

  void "testing indicator/Outcome-Indicator relationship Querying"() {

    given: "A couple of Outcomes, indicators, and measures and linking their relationships correctly"
    def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
    def newIndicator2 = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to")
    def newIndicator3 = new Indicators(indicatorName: "a.3", indicatorDescription: "Students will be able to")
    def newIndicator4 = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to")
    def newIndicator5 = new Indicators(indicatorName: "b.2", indicatorDescription: "Students will be able to")
    def newIndicator6 = new Indicators(indicatorName: "c.1", indicatorDescription: "Students will be able to")
    def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to")
    def newOutcome2 = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Students will learn how to")
    def newOutcome3 = new Outcomes(outcomeCategory: 'C', outcomeCategoryDescription: "Students will learn how to")
    def newMeasure = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
    def newMeasure2 = new Measures(measureTitle: "Exam1_Q5", measureDescription: "Student will be able to")
    def newMeasure3 = new Measures(measureTitle: "Exam1_Q10", measureDescription: "Student will be able to")
    def newMeasure4 = new Measures(measureTitle: "Exam2_Q3", measureDescription: "Student will be able to")
    def newMeasure5 = new Measures(measureTitle: "Exam3_Q7", measureDescription: "Student will be able to")
    def newMeasure6 = new Measures(measureTitle: "Algorithm Group Project", measureDescription: "Student will be able to")
    def newMeasure7 = new Measures(measureTitle: "Assignment 5", measureDescription: "Student will be able to")
    def newMeasure8 = new Measures(measureTitle: "Lab 3", measureDescription: "Student will be able to")
    def newMeasure9 = new Measures(measureTitle: "Exam1_Q8", measureDescription: "Student will be able to")

    newOutcome.addToIndicators(newIndicator)
    newOutcome.addToIndicators(newIndicator2)
    newOutcome.addToIndicators(newIndicator3)

    newOutcome2.addToIndicators(newIndicator4)
    newOutcome2.addToIndicators(newIndicator5)

    newOutcome3.addToIndicators(newIndicator6)

    newIndicator.addToMeasures(newMeasure)
    newIndicator.addToMeasures(newMeasure2)

    newIndicator2.addToMeasures(newMeasure3)
    newIndicator2.addToMeasures(newMeasure4)

    newIndicator3.addToMeasures(newMeasure5)
    newIndicator3.addToMeasures(newMeasure6)

    newIndicator4.addToMeasures(newMeasure7)

    newIndicator5.addToMeasures(newMeasure8)

    newIndicator6.addToMeasures(newMeasure9)

    newOutcome.save(flush:true)
    newOutcome2.save(flush:true)
    newOutcome3.save(flush:true)


    when: "Querying for the data in the DB"
    def aa = Measures.findAllByMeasureTitleLike("%Exam%")
    def bb = Measures.findAllByMeasureTitleLike("%Algorithm%")
    def cc = Measures.findAllByMeasureTitleLike("%Lab%")
    def dd = Measures.findAllByMeasureTitleLike("%Assign%")


      then: "aa size should be 2 as well as bb size should be 2"
      aa.size() == 6
      bb.size() == 1
      cc.size() == 1
      dd.size() == 1

    when: "Querying for the data in the DB through the Outcomes to Measures"
    def ee = Outcomes.createCriteria().list() {
          indicators {
              eq('indicatorName', "a.1")
              measures {
                  eq('measureTitle', "Exam1_Q1")
                }
          }
      }
    def ff = Outcomes.createCriteria().list() {
          indicators {
              like('indicatorName', "c%")
              measures {
                  like('measureTitle', "Exam%")
                }
          }
      }


        then: "ee should be 1 with outcome A because outcome A has a.1 and that measure title associated with it, and ff should be 1 with Outcome C because only outcome C has any indicator names starting with 'c' "
        ee.size() == 1
        ee[0].outcomeCategory == 'A'
        ff.size() == 1
        ff[0].outcomeCategory == "C"





    }

}
