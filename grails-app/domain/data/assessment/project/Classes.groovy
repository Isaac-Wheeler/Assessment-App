package data.assessment.project

class Classes {

      //properties
      //NOTE: DB creates ID for table
      String title;
      int[] classIndicators


    static constraints = {

      title  blank:false, size: 5..6, unique:true
      classIndicators nullable:true

    }
}
