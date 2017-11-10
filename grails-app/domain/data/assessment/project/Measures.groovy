package data.assessment.project

class Measures {

      //NOTE: DB creates ID for table
      String measureTitle;
      String measureDescription;

      static belongsTo = [ indicator : Indicators ]

      static hasOne = [ assessment_documents : Assessment_Documentation ]



    static constraints = {
      measureTitle blank: false, unique:true
      measureDescription blank: false
      assessment_documents nullable:true

}
}
