package data.assessment.project

class Measures {

      //NOTE: DB creates ID for table
      String measureTitle;
      String measureDescription;
      int indicatorId;
      int assessmentDoc;





    static constraints = {
      measureDescription blank: false
      indicatorId blank:false
      measureTitle blank: false
      assessmentDoc blank:false

}
}
