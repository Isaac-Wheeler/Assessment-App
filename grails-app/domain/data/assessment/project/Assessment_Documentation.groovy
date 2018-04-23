package data.assessment.project

class Assessment_Documentation {

    //NOTE: DB creates ID for table.
    int targetGoal;   //this property holds the value for the targetGoal in relation to what is expected for students to meet.
    int numberOfStudents;   //this property is the number of students being assessed in the assessment in regards to the measure.
    int needsImprovement;   //this property holds the number of students that were below the expectation (target goal).
    int meetsExpectations;    //this property holds the number of students that met the expectation (target goal).
    int exceedsExpectations;    //this property holds the number of students that were above the expectation (target goal).
    String comments;      //this property holds any information that the professor wants to make in regards to how the assessment went.
    String requiredAction;    //this property holds the information in regards to what the professor may want to do about how the assessment went.
    String resultComment;   //this property holds the information in regards to any comments on specifically how the assessment resulted by the professor.
    boolean complete;   //this property marks whether or not the created assessment has been completed or not yet.

    static belongsTo = [ measure : Measures ]   //this holds the belongTo relational mapping from Assessment_Documentation to Measures. This creates the relation in the database that a Measure contains an assessment.

    static hasMany = [ documents : Document ]   //this creates the relational mapping to the database that an Assessment_Documentation can have many Documents which is the class that contains the information for uploading and downloading the assessment information (PDFs for example)



    static constraints = {

      comments blank:false    // this means that the comments property cannot be left with a single whitespace (not the same thing as being left NULL or empty).
      targetGoal blank:true   // this means that the targetGoal can be left blank and this is for if the professor starts an assessment but does not finish it.
      needsImprovement blank:false  // this means that the needsImprovement property cannot be left with a single whitespace (not the same thing as being left NULL or empty).
      meetsExpectations blank:false   // this means that the meetsExpectations property cannot be left with a single whitespace (not the same thing as being left NULL or empty).
      exceedsExpectations blank:false   // this means that the exceedsExpectations property cannot be left with a single whitespace (not the same thing as being left NULL or empty).
      requiredAction nullable: true   // this means that the requiredAction property can be left null or empty because the professor does not have to give any comments on requiredAction
      resultComment blank:false   // this means that the resultComment property cannot be left with single whitespace but can be left NULL if the professor doe snot want to leave any comments.
      complete blank:false    // this means that the complete property cannot be left with a single whitespace, because it has to be either null (not complete) or it is marked as complete.
      measure blank:true, nullable:true 
    }
}
