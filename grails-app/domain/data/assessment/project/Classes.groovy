package data.assessment.project

class Classes {

      //properties
      //NOTE: DB creates ID for table
      String title;


    static constraints = {

      title  blank:false, maxSize: 5, unique:true

    }
}
