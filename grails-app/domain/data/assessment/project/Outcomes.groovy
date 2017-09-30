package data.assessment.project

class Outcomes {


    //NOTE: DB creates ID for table
    char outcome_category;
    String outcome_category_description;



    static constraints = {
      outcome_category blank:false, size: 1..1, unique:true
      outcome_category_description blank:false

    }
}
