package data.assessment.project

class Classes {

      //properties
      //int classes_id;   *may not need. It looks like grails creates tables with id calumn automatically
      String title;


    static constraints = {

      title  blank:false, maxSize: 5, unique:true
      classes_id  unique:true

    }
}
