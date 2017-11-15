package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    char outcomeCategory;
    String outcomeCategoryDescription;
    String academicSemester;

    static hasMany = [ indicators : Indicators ]


    static mapping = {
        indicators sort: 'indicatorName', order: 'asc'
    }


    static constraints = {

      outcomeCategory blank:false, unique:true
      outcomeCategoryDescription blank:false
      academicSemester nullable:true
      }

}
