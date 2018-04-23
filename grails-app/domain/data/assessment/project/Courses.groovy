package data.assessment.project

class Courses {

      //properties
      //NOTE: DB creates ID for table
      String title;   //this property holds the information for the name of the course (ex CS330).
      int targetGoal; // this property holds the information for what the specifics courses targetGoal is for its assessments
      String requiredAction;  // this property holds the information for if the professor thinks there should be some kind of requiredAction for how to change the course.



      static hasMany = [ indicators : Indicators , teachers : Teacher ]   //this creates the relational mapping that courses can have many indicators and teachers attached relationally to it.

      static mapping = {    //this simply creates a specific kind of mapping to the database. The titles are organied in Ascending order, and the cascading affect only updates on save.
          sort title: "asc"
          indicators cascade: 'save-update'
          teacher cascade: 'save-update'

      }

    static constraints = {

      title  blank:false, minSize: 5, unique: true    //this means that the title of a course cannot be left as a single whitespace, every title has to be different than the rest, and the title has to be at a minimum of 5 characters in length.
      targetGoal blank:false, nullable:true   // this means that the targetGoal cannot be left as a single whitespace but it can be left blank for creation.
      requiredAction nullable: true   // this means that requiredAction does not have to be filled out by the professor for creation and completeness.

    }
}
