package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicatorName;
      String indicatorDescription;
      String academicYear;

      static hasMany = [ measures : Measures , courses : Courses ]

      static belongsTo = [ outcome : Outcomes , class : Courses ]


      static mapping = {
          measures sort: 'measureTitle', order: 'asc'

      }

    static constraints = {

      indicatorName blank:false
      indicatorDescription blank:false
      academicYear nullable:true
    }

    String toString(){
      def toStringDescription = indicatorName + " From Outcome: " + outcome.outcomeCategory
      if (courses != null) {
        toStringDescription = toStringDescription + " Course(s): "
        if (courses.size() == 1) {
          toStringDescription = toStringDescription + courses.first().title
        }
        else {
          courses.each { course ->
            toStringDescription = toStringDescription + course.title + ", "
          }
          toStringDescription = toStringDescription.substring(0, toStringDescription.length() - 2)
        }
      }
      return toStringDescription
    }
}
