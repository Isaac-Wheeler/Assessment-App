package data.assessment.project

class Measures {

      //NOTE: DB creates ID for table
      String measureTitle;
      String measureDescription;


      static belongsTo = [ indicator : Indicators ]

      static hasOne = [ assessment_documents : Assessment_Documentation ]


      def addToAssessment_documents(Assessment_Documentation ad) {
            assessment_documents = ad
      }


    static constraints = {
      measureTitle blank: false
      measureDescription blank: false
      assessment_documents nullable:true

}
}
