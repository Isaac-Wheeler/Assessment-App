package data.assessment.project

class Settings {

    String academicYear;

    String toString(){
        return academicYear
    }


    static constraints = {
      academicYear blank: false, nullable: false, unique: true
    }


}
