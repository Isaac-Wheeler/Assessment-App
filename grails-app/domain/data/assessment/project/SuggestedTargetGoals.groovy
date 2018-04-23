package data.assessment.project

class SuggestedTargetGoals {

    //properties
    //NOTE: DB creates ID for table

    String gradeLevel;    //this string represents the grade level (freshman, sophmore etc)
    int gradeLevelTargetGoal;   //this int represents the specific target goal for the grade level


    static constraints = {
      gradeLevel blank:false
      gradeLevelTargetGoal blank:false
    }
}
