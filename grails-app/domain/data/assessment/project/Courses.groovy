package data.assessment.project

class Courses {

      //properties
      //NOTE: DB creates ID for table
      String title;
      int targetGoal;
      String requiredAction;



      static hasMany = [ indicators : Indicators , teachers : Teacher ]

      static mapping = {
          sort title: "asc"
          indicators cascade: 'save-update'
          teacher cascade: 'save-update'

      }

    static constraints = {

      title  blank:false, minSize: 5, unique: true
      targetGoal blank:false, nullable:true
      requiredAction nullable: true

    }
}
