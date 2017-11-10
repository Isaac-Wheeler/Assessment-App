package data.assessment.project

class Assessment_Documentation {

    //NOTE: DB creates ID for table.
    Measures measure;
    int targetGoal;
    int numberOfStudents;
    int needsImprovement;
    int meetsExpectations;
    int exceedsExpectations;
    String assessmentDocTitle;
    String comments;
    String summary;
    String requiredAction;
    String resultComment;
    String academicSemester;
    boolean complete;

    static belongsTo = [ measure : Measures ]

    static hasMany = [ documents : Document ]



    static constraints = {

      assessmentDocTitle blank:false
      comments blank:false
      targetGoal blank:false
      needsImprovement blank:false
      meetsExpectations blank:false
      exceedsExpectations blank:false
      summary blank:false
      requiredAction nullable: true
      resultComment blank:false
      academicSemester blank:false
      complete blank:false
      measure blank:true, nullable:true
    }
}
