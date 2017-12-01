package data.assessment.project

class Classes {

      //properties
      //NOTE: DB creates ID for table
      String title;

      static hasMany = [ indicators : Indicators , teachers : Teacher ]

      static mapping = {
          sort title: "asc"
          indicators cascade: 'save-update'
          teacher cascade: 'save-update'

      }

    static constraints = {

      title  blank:false, minSize: 5, unique:true

    }
}
