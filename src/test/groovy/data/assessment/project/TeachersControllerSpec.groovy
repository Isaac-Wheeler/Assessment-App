package data.assessment.project

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

@TestFor(TeachersController)
@Mock([Outcomes, Indicators, Classes, Teacher, Measures, Document, Assessment_Documentation, Settings])
class TeachersControllerSpec extends Specification {

    def setup() {
      def newTeacher = new Teacher(firstName: "Joe", lastName: "Singer", username: "JSinger", password: "password",
                    confirm: "password", passwordHashed: "AASSHHDDSS", admin: true)
      def newTeacher2 = new Teacher(firstName: "Bob", lastName: "Riller", username: "BRiller", password: "password",
                    confirm: "password", passwordHashed: "AASSHHDDKKSS", admin: true)

      newTeacher.save(flush:true)
      newTeacher2.save(flush:true)
    }

    def cleanup() {
    }

    void "test something"() {


          expect: "Setup() ran correctly"
            Teacher.count() == 2


          when: "The index() method is invoked in the TeachersController"
          def model = controller.index()
          controller.response.reset()


          then: "model.Teacher.size() should be equal to 2"
          model.Teacher.size() == 2  //the index controller returns a map [Teacher:teachers] so we can test to make sure that teacher.list() returned the correct amount of teachers

          



    }
}
