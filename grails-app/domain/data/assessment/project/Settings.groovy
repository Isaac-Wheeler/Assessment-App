package data.assessment.project

class Settings {

    String academicYear;




    static constraints = {
      academicYear blank: false, nullable: false, unique: true
    }


}
