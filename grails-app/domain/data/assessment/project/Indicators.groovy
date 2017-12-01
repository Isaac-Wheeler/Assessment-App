package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicatorName;
      String indicatorDescription;
      String academicYear;

      static hasMany = [ measures : Measures , classes : Classes ]

      static belongsTo = [ outcome : Outcomes, class : Classes ]


      static mapping = {
          measures sort: 'measureTitle', order: 'asc'
      }

    static constraints = {

      indicatorName blank:false, unique: true
      indicatorDescription blank:false
      academicYear nullable:true
    }

    String toString(){
      return indicatorName + " From Outcome: " + outcome.outcomeCategory + ", And Course: " + classes.title
    }
}
