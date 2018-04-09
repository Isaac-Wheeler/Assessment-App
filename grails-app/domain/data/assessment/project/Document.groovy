package data.assessment.project

class Document {

  String filename;
  byte[] filedata;
  Date dateCreated;



  static belongsTo = [ assessment_document : Assessment_Documentation ]


  static constraints = {
      filename blank: false , nullable:false
      filedata blank: true , nullable:true, maxSize:10000
      assessment_document nullable:true
  }

}
