package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicatorName;   //this property holds the name given to the indicator (EX A.1)
      String indicatorDescription;    //this property holds the description of what the indicator is assessing.
      String academicYear;    // this property holds the acadeic year that the indicator was creating in order to help track and copy over indicators into the next academic year for ease.

      static hasMany = [ measures : Measures , courses : Courses ]    // this creates the relational mapping that indicators can have many measures and many courses linked to it.

      static belongsTo = [ outcome : Outcomes , class : Courses ]   // this creates the relational mapping that an indicator belongs to an outcome and a course, because an indicator needs to be linked to both of them.


      static mapping = {    // this create the way in which indicators are mapped to the database because we want to pull the indicators' measures in ascending order.
          measures sort: 'measureTitle', order: 'asc'

      }

    static constraints = {

      indicatorName blank:false   // this means that the indicatorName property cannot be left as whitespace.
      indicatorDescription blank:false    // this means that the indicatorDescription cannot be left as whitespace.
      academicYear nullable:true    // this means that the academicYear can be left as NULL for creation.
    }

    String toString(){    //this function simply helps display the information in regards to what the indicaor is and where it came from (which outcome and class) in a nice way to the front end.
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
