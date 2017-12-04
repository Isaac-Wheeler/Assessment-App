package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    char outcomeCategory;
    String outcomeCategoryDescription;
    String academicYear;

    static hasMany = [ indicators : Indicators ]


    static mapping = {
        indicators sort: 'indicatorName', order: 'asc'
    }

    static constraints = {

      outcomeCategory blank:false
      outcomeCategoryDescription blank:false
      academicYear nullable:true
      }

}
