package data.assessment.project

class Settings {

    String academicYear;    //this property holds the current academicYear for the settings in regards to the web application.

    String toString(){    // this function allows for an easier way for the UI to return the academicYear
        return academicYear
    }


    static constraints = {
      academicYear blank: false, nullable: false, unique: true    //this means that the academicYear cannot be left as whitespace or NULL, and all acadeicYears have to different so that an academic year cannot be created twice.
    }


}
