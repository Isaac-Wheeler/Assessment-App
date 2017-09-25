package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicator_name;
      String indicator_description;
      int outcome_id;
      int classes_id;




    static constraints = {

      indicator_name  maxSize: 4


    }
}
