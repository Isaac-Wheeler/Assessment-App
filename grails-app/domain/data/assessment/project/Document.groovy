package data.assessment.project

class Document {

  String filename;    // this property holds the name of the file that was uploaded.
  byte[] filedata;    // this property holds the byte information for the data within the file that was uploaded.
  Date dateCreated;   // this property holds the date of when the file was uploaded.



  static belongsTo = [ assessment_document : Assessment_Documentation ]   // this creates the relational mapping from Document to Assessment_Documentation so that a Document must have an Assessment_Documentation that it was uploaded to specifically.


  static constraints = {
      filename blank: false , nullable:false    //this means that the filename cannot be left as whitespace or be left NULL in order to be created.
      filedata blank: true , nullable:true, maxSize:20000000    //this means that the file can contain nothing, but it cannot be NULL and it also sets its maxSize that the file can be for uploading.
      assessment_document nullable:true   
  }

}
