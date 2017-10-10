package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicatorName;
      String indicatorDescription;

      static belongsTo = [ outcome : Outcomes, class : Classes ]

      static hasMany = [ measures : Measures ]



    static constraints = {

      indicatorName blank:false, size: 3..4, unique: true
      indicatorDescription blank:false

    }
}
