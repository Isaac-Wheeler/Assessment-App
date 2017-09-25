package data.assessment.project

class Measures {

      //int measure_id;       *may not need. It looks like grails creates tables with id calumn automatically
      String measure_title;
      String measure_description;
      int[] indicator_id;
      int target_goal;
      int needs_improvement;
      int meets_expectations;
      int exceeds_expectations;
      String measure_summary;
      String required_action;
      String measure_comments;
      String academic_semester;
      boolean measure_complete;

    static constraints = {

        measure_id  unique:true
        target_goal  blank:false
        needs_improvement  blank:false
        meets_expectations  blank:false
        exceeds_expectations  blank:false
        academic_semester  blank:false


    }
}
