package data.assessment.project

class Document {

  String filename;
  byte[] filedata;
  Date dateCreated;



  static belongsTo = [ assessment_document : Assessment_Documentation ]


  static constraints = {
      filename blank: false , nullable:false
<<<<<<< HEAD
      filedata blank: true , nullable:true, maxSize:20000000
=======
      filedata blank: true , nullable:true, maxSize:10000
>>>>>>> db5b91eef32852e2357be2cfd45f0fbc3e5f4c2f
      assessment_document nullable:true
  }

}
