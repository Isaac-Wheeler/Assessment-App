package data.assessment.project
/*
* allows for the generation of a forumal report
*/
class GenerateController {
    //static value to tell if its a course being selected
    public static int COURSE_SELECT_VALUE = 1;
    //static value to tell if its a year being selected
    public static int YEAR_SELECT_VALUE = 2;

    /*
    * all generate code since there is only the index view
    */
    def index() {
      //initialzation block
      def outcomes
      def settings = Settings.list()
      def courses = Courses.list()
      def course

      if (request.method == 'POST') { //check if first load or reply from user
        if(!BootStrap.isPerm(false, session)){
          redirect(controller:'main')
        }else{
        if(params.academicYear != 'null'){ //Selected Year
          outcomes = Outcomes.findAllByAcademicYear(Settings.get(params.academicYear).academicYear)
          [Outcomes:outcomes, Settings:settings, Courses:courses, year:Settings.get(params.academicYear).id, SelectValue:YEAR_SELECT_VALUE]
        }else{ //Not a Selected Year
          if(params.coursesSelect != 'null'){ //selected course
            course = Courses.findAllByTitle(params.coursesSelect)
            System.out.println(course)
            [Course:course, Settings:settings, Courses:courses, SelectValue:COURSE_SELECT_VALUE]
          }else{//ALL Years
            outcomes = Outcomes.list()
            [Outcomes:outcomes, Settings:settings, Courses:courses, SelectValue:YEAR_SELECT_VALUE]
          }
        }
      }
      }else{//page default (currrent year)
        outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear)

        [Outcomes:outcomes, Settings:settings, Courses:courses, SelectValue:YEAR_SELECT_VALUE]
      }
     }
}
