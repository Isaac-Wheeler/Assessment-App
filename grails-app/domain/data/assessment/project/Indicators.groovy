package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicatorName;
      String indicatorDescription;

      static belongsTo = [ outcome : Outcomes, class : Classes ]

      static hasMany = [ measures : Measures ]



    static constraints = {

      indicatorName blank:false, unique: true
      indicatorDescription blank:false


    }
}
