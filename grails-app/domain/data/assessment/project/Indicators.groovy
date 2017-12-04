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

      indicatorName blank:false
      indicatorDescription blank:false
      academicYear nullable:true
    }

    String toString(){
      String toStringDescription = indicatorName + " From Outcome: " + outcome.outcomeCategory
      if (classes != null) {
        toStringDescription = toStringDescription + ", And Course(s): "
        if (classes.size() == 1) {
          toStringDescription = toStringDescription + classes.get(0).title
        }
        else {
          classes.each { course ->
            toStringDescription = toStringDescription + course.title + ", "
          }
          toStringDescription = toStringDescription.substring(0, toStringDescription.length() - 2)
        }
      }
      return toStringDescription;
    }
}
