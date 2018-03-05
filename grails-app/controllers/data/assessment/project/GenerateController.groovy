package data.assessment.project

class GenerateController {

    public static int COURSE_SELECT_VALUE = 1;
    public static int YEAR_SELECT_VALUE = 2;

    def index() {
      //initialzation block
      def outcomes
      def settings = Settings.list()
      def courses
      def course

      if (request.method == 'POST') { //check if first load or reply from user
        if(params.containsKey(academicYear)){ //Selected Year
          outcomes = Outcomes.findAllByAcademicYear(Settings.get(params.academicYear).academicYear)
          [Outcomes:outcomes, Settings:settings, year:Settings.get(params.academicYear).id, SelectValue:YEAR_SELECT_VALUE]
        }else{ //Not a Selected Year
          if(params.containsKey(coursesSelect)){
            course = Classes.findAllByTitle(params.coursesSelect)
            [Course:course, Settings:settings, SelectValue:COURSE_SELECT_VALUE]
          }else{//ALL Years
            outcomes = Outcomes.list()
            [Outcomes:outcomes, Settings:settings, SelectValue:YEAR_SELECT_VALUE]
          }
        }
      }else{//page default (currrent year)
        outcomes = Outcomes.findAllByAcademicYear(Settings.first().academicYear)
        courses = Classes.list()
        [Outcomes:outcomes, Settings:settings, Courses:courses, SelectValue:YEAR_SELECT_VALUE]
      }
     }
}
