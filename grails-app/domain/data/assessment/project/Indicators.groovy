package data.assessment.project

class Indicators {

      //NOTE: DB creates ID for table
      String indicatorName;
      String indicatorDescription;
      int outcomeId;
      int classesId;
      List<Integer> indicatorMeasures



    static constraints = {

      indicatorName blank:false, size: 3..4
      indicatorDescription blank:false
      outcomeId blank:false
      classesId blank:false
      indicatorMeasures nullable:true
    }
}
