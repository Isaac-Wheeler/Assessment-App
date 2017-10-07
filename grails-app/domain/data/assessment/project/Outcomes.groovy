package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    char outcomeCategory;
    String outcomeCategoryDescription;
    static hasMany = [outcomeIndicators:Integer]
    ArrayList<Integer> outcomeIndicators;




    static constraints = {
      outcomeCategory blank:false, size: 1..1, unique:true
      outcomeCategoryDescription blank:false
      //outcomeIndicators nullable:true

    }
}
