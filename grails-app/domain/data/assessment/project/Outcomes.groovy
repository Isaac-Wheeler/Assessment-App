package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    String outcomeCategory;   //this property holds the name of the outcome (EX A, B, C)
    String outcomeCategoryDescription;    // this property holds the description of what the Outcome is.
    String academicYear;    //this property holds what the academic year was when the outcome was created.

    static hasMany = [ indicators : Indicators ]    // this creates the relational mapping that an outcome can have many indicators


    static mapping = {    //this creates the way in which the indicators are linked to the outcomes such that when pulling them from the DB it pulls them by their indicatorName in ascending order.
        indicators sort: 'indicatorName', order: 'asc'
    }

    static constraints = {

      outcomeCategory blank:false   //this means that the outcomeCategory cannot be left as whitespace
      outcomeCategoryDescription blank:false    //this means that the outcomeCategoryDescription cannot be left as whitespace
      academicYear nullable:true    //this means that the academicYear property can be left as NULL for creation.
      }

}
