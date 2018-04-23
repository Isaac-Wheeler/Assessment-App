package data.assessment.project

class Measures {

      //NOTE: DB creates ID for table
      String measureTitle;    //this property holds the name for the measure
      String measureDescription;    // this property holds the descrption for what the measure is.
      String academicYear;    //this property holds what the academic year was when this measure was created.


      static belongsTo = [ indicator : Indicators ]   //this creates the relational mapping that a measure needs to be linked to a specific measure in order to be created.

      static hasOne = [ assessment_documents : Assessment_Documentation ]   // this creates the relational mapping that a measure can only have one assessment_documents.


      def addToAssessment_documents(Assessment_Documentation ad) {    // this function allows for an easier ability for the controller to add a created assessment_documents to the measure.
            assessment_documents = ad
      }


    static constraints = {
      measureTitle blank: false    //this means that the measureTitle cannot be left as whitespace.
      measureDescription blank: false   //this means that the measureDescription cannot be left as whitespace.
      assessment_documents nullable:true    // this means that there does not have to be assessment_document linked to the measure in order to be created.
      academicYear nullable:true    // this means that the academicYear property can be left as NULL for creation.
    }
}
