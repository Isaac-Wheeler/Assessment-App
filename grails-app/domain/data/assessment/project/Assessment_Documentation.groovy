package data.assessment.project

class Assessment_Documentation {

    //NOTE: DB creates ID for table.
    int targetGoal;
    int numberOfStudents;
    int needsImprovement;
    int meetsExpectations;
    int exceedsExpectations;
    String comments;
    String requiredAction;
    String resultComment;
    boolean complete;

    static belongsTo = [ measure : Measures ]

    static hasMany = [ documents : Document ]



    static constraints = {

      comments blank:false
      targetGoal blank:true
      needsImprovement blank:false
      meetsExpectations blank:false
      exceedsExpectations blank:false
      requiredAction nullable: true
      resultComment blank:false
      complete blank:false
      measure blank:true, nullable:true
    }
}
