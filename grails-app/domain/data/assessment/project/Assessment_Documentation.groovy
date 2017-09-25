package data.assessment.project

class Assessment_Documentation {

    //NOTE: DB creates ID for table.
    int measureID;
    int targetGoal;
    //workUsed;     **leaving as a comment for now until ready to implement file uploads.
    int needsImprovement;
    int meetsExpectations;
    int exceedsExpectations;
    String summary;
    String requiredAction;
    String resultComment;
    String academicSemester;
    boolean complete;




    static constraints = {


    }
}
