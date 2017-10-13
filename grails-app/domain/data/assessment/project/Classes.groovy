package data.assessment.project

class Classes {

      //properties
      //NOTE: DB creates ID for table
      String title;

      static hasMany = [ indicators : Indicators ]

    static constraints = {

      title  blank:false, size: 0..6, unique:true

    }
}
