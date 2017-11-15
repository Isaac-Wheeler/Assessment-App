package data.assessment.project

class Settings {

    String academicSemester;




    static constraints = {
      academicSemester blank: false, nullable: false, unique: true
    }


}
