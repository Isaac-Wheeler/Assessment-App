package data.assessment.project

class LoadDomainItemTagLib {
    static defaultEncodeAs = "raw"
    static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def loadSettings = {
      def settings = Settings.list()
      settings.each {
        if(session.year != null & it.academicYear != session.year){
          out << g.render(template:"/layouts/optionSettings", model:[i:it.academicYear])
        }else{
          out << g.render(template:"/layouts/optionsSettingsSelected", model:[i:it.academicYear])
        }
      }
    }


    def loadCourses = {
      def c = Classes.list()
      c.each{
        out << g.render(template:"/layouts/optionSettings", model:[i:it.title])
      }
    }

}
