package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class Assessment_DocumentationSpec extends Specification implements DomainUnitTest<Assessment_Documentation> {

    def setup() {
      mockDomain(Indicators)
      mockDomain(Outcomes)
      mockDomain(Measures)
    }

    def cleanup() {
    }

    void "testing adding and deleting a new Assessment_Documentation"() {

      given: "a correctly linked Assessment_Documentation with a correctly made Outcome, Indicator, and Measure"
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def newMeasure = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
      def newAD = new Assessment_Documentation(targetGoal: 75 , numberOfStudents: 20 , needsImprovement: 5, meetsExpectations: 10 , exceedsExpectations: 5,
                                                 comments: "Average results", requiredAction: " " , resultComment: "Do something", complete: true)

      when: "linking the objects to their relationships and saving the outcome"
      newOutcome.addToIndicators(newIndicator)
      newIndicator.addToMeasures(newMeasure)
      newMeasure.addToAssessment_documents(newAD)
      newOutcome.save(flush:true)

      then: "Everything is saved successfully and can be found in the DB"
      newOutcome.errors.errorCount == 0
      newOutcome.id != null
      Outcomes.get(newOutcome.id).outcomeCategory == "A"
      newIndicator.errors.errorCount == 0
      newIndicator.id != null
      Indicators.get(newIndicator.id).indicatorName == "a.1"
      newMeasure.errors.errorCount == 0
      newMeasure.id != null
      Measures.get(newMeasure.id).measureTitle == "Exam1_Q1"
      newAD.errors.errorCount == 0
      newAD.id != null

      when: "a property in the AD is changed"
      def foundAD = Assessment_Documentation.get(newAD.id)
      foundAD.save(flush:true)

      then: "the change should be reflected in the DB"

      when: "AD is deleted"
      foundAD.delete(flush:true)

      then: "the outcome is removed from the DB"
      !Assessment_Documentation.exists(newAD.id)
      !Assessment_Documentation.exists(foundAD.id)
      newMeasure.delete(flush:true)
      newIndicator.delete(flush:true)
      newOutcome.delete(flush:true)

    }

    void "testing retrievals from the DB"() {


      given: "a correctly linked Assessment_Documentation with a correctly made Outcome, Indicator, and Measure"
      def newOutcome = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to")
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def newMeasure = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
      def newAD = new Assessment_Documentation(targetGoal: 75 , numberOfStudents: 20 , needsImprovement: 5, meetsExpectations: 10 , exceedsExpectations: 5,
                                               comments: "Average results", requiredAction: " " , resultComment: "Do something", complete: true)


      def newOutcome2 = new Outcomes(outcomeCategory: 'B', outcomeCategoryDescription: "Students will learn how to")
      def newIndicator2 = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to")
      def newMeasure2 = new Measures(measureTitle: "Exam1_Q3", measureDescription: "Student will be able to")
      def newAD2 = new Assessment_Documentation(targetGoal: 80 , numberOfStudents: 15 , needsImprovement: 5, meetsExpectations: 5 , exceedsExpectations: 5,
                                                 comments: "Average results", requiredAction: " " , resultComment: "Do something", complete: true)


      when: "linking the objects to their relationships and saving the outcome"
      newOutcome.addToIndicators(newIndicator)
      newIndicator.addToMeasures(newMeasure)
      newMeasure.addToAssessment_documents(newAD)
      newOutcome.save(flush:true)

      newOutcome2.addToIndicators(newIndicator2)
      newIndicator2.addToMeasures(newMeasure2)
      newMeasure2.addToAssessment_documents(newAD2)
      newOutcome2.save(flush:true)

      then: "Should be able to correctly query for the data"
      def b = Assessment_Documentation.findAllByComplete(true)
      b.size() == 2
      def c = Outcomes.createCriteria().list() {
            indicators {
                eq('indicatorName', "a.1")
                  measures {
                    eq('measureTitle', "Exam1_Q1")

                  }
            }


        }

      c.size() == 1
      c[0].outcomeCategory == 'A'
      newMeasure.delete(flush:true)
      newIndicator.delete(flush:true)
      newOutcome.delete(flush:true)
      newAD.delete(flush:true)
      newMeasure2.delete(flush:true)
      newIndicator2.delete(flush:true)
      newOutcome2.delete(flush:true)
      newAD2.delete(flush:true)



    }
}
