package data.assessment.project

class Assessment_Documentation {

    //NOTE: DB creates ID for table.
    int measureID;
    int targetGoal;
    //workUsed;     **leaving as a comment for now until ready to implement file uploads.
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




    static constraints = {

      measureID blank:false
      assessmentDocTitle blank:false
      comments blank:false
      targetGoal blank:false
      needsImprovement blank:false
      meetsExpectations blank:false
      exceedsExpectations blank:false
      summary blank:false
      requiredAction blank:false
      resultComment blank:false
      academicSemester blank:false
      complete blank:false

    }
}
