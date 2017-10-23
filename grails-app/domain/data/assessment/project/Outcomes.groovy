package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    char outcomeCategory;
    String outcomeCategoryDescription;

    static hasMany = [ indicators : Indicators ]




    static constraints = {
      outcomeCategory blank:false, unique:true
      outcomeCategoryDescription blank:false

    }
}
