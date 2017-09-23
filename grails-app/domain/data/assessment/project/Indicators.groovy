package data.assessment.project

class Indicators {

      int indicator_id;
      String indicator_name;
      String indicator_description;
      int[] outcome_id;
      int[] classes_id;



    static constraints = {

      indicator_id  unique:true
      indicator_name  maxSize: 4


    }
}
