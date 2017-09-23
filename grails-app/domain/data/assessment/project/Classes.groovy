package data.assessment.project

class Classes {

      //properties
      int classes_id;
      String title;

    static constraints = {

      title  blank:false, maxSize: 5, unique:true
      classes_id  unique:true

    }
}
