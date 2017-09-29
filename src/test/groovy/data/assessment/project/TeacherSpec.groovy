package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TeacherSpec extends Specification implements DomainUnitTest<Teacher> {

    def setup() {
    }

    def cleanup() {
    }

    void 'Test adding Teacher and deleting Teacher'() {
        when: 'adding new teacher'
        def u = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin:true)
        u.passwordHashed = "aaawwsdSHhdhS"
        u.save()

        then:
        Teacher.count() == 1

        when: 'adding a 2nd teacher'
        def v = new Teacher(firstName:"Bob", lastName:"Smith", username:"BSmith", password:"password", confirm:"password", admin:true)
        v.passwordHashed = "aaawwsdSHJJUhS"
        v.save()

        then:
        Teacher.count() == 2

        when: 'deleting new teacher'
        u.delete()

        then:
        Teacher.count() == 1

        when: 'deleting new teacher'
        v.delete()

        then:
        Teacher.count() == 0

    }

    void 'Test trying to add 2 teachers with same username'() {
        when: 'adding new teacher'
        def u = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin:true)
        u.passwordHashed = "aaawwsdSHhdhS"
        u.save()

        then:
        Teacher.count() == 1

        when: 'adding new teacher with already taken username'
        def v = new Teacher(firstName:"Johnny", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin:true)
        v.passwordHashed = "aaawwsdSHhdJJ"
        v.save()

        then:
        Teacher.count() == 1

    }

    void 'Testing password must match contraint'() {

      when: 'attempting to add a user without matching password'
      def u = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:"passwordd", admin:true)
      u.passwordHashed = "aaawwsdSHhdhS"
      u.save()

      then: 'u.save() should not work because passwords mis-matched and thus count == 0'
      Teacher.count() == 0



    }

}
