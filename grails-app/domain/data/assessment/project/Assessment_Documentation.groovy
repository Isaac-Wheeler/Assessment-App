package data.assessment.project

class Assessment_Documentation {

    //NOTE: DB creates ID for table.
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

      assessmentDocTitle blank:false
      comments blank:false
      targetGoal blank:false
      needsImprovement blank:false
      meetsExpectations blank:false
      exceedsExpectations blank:false
      summary blank:false
<<<<<<< HEAD
      requiredAction nullable: true
=======
    //  requiredAction blank:false
>>>>>>> 86b5e2e16a5d0b0df171f75eb46b002126ccf7f1
      resultComment blank:false
      academicSemester blank:false
      complete blank:false

    }
}
