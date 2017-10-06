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

          then: 'u.save() should work (since the fields meet the constraints) and Teacher.count() should be equal to 1'
          Teacher.count() == 1

        when: 'adding a 2nd teacher'
        def v = new Teacher(firstName:"Bob", lastName:"Smith", username:"BSmith", password:"password", confirm:"password", admin:true)
        v.passwordHashed = "aaawwsdSHJJUhS"
        v.save()

          then: 'u.save() should work (since the fields meet the constraints) and Teacher.count() should be equal to 2'
          Teacher.count() == 2

        when: 'deleting new teacher'
        u.delete()

          then: 'if we delete a teacher than Teacher.count() should decrease by 1, thus leaving us with 1 left'
          Teacher.count() == 1

        when: 'deleting new teacher'
        v.delete()

          then: 'deleting the last teacher should leave us without any teachers.'
          Teacher.count() == 0

    }

    void 'Test trying to add 2 teachers with same username'() {
        when: 'adding new teacher'
        def u = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin:true)
        u.passwordHashed = "aaawwsdSHhdhS"
        u.save()

          then: 'Since the properties are correct and do not break any constraints then new teacher should be added successfully'
          Teacher.count() == 1

        when: 'adding new teacher with already taken username'
        def v = new Teacher(firstName:"Johnny", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin:true)
        v.passwordHashed = "aaawwsdSHhdJJ"
        v.save()

          then: 'The username constraint prevents any 2 teachers from having the same username, thus v.save() should have failed and left us with only 1 teacher instead of 2'
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
    void 'Testing blank and size constraints'() {

      when: 'leaving firstName field blank'
      def u = new Teacher(firstName:" ", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin:true)
      u.passwordHashed = "aaawDHDdSHhdhS"
      u.save()

        then: 'u.save() should not work because the constraint should prevent the firstName field from being blank'
        Teacher.count() == 0

      when: 'leaving lastName field blank'
      def v = new Teacher(firstName:"John", lastName:" ", username:"JSinger", password:"password", confirm:"password", admin:true)
      v.passwordHashed = "aaawDHDdSDDHhdhS"
      v.save()

        then: 'v.save() should not work because the constraint should prevent the lastName field from being blank'
        Teacher.count() == 0

      when: 'leaving username field blank'
      def w = new Teacher(firstName:"John", lastName:"Singer", username:" ", password:"password", confirm:"password", admin:true)
      w.passwordHashed = "aaaXYySwDHDdSHhdhS"
      w.save()

        then: 'w.save() should not work because the constraint should prevent the username field from being blank'
        Teacher.count() == 0

      when: 'leaving password field blank'
      def x = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:" ", confirm:"password", admin:true)
      x.passwordHashed = "aaaXSwKKDHDdSHhdhS"
      x.save()

        then: 'x.save() should not work because the constraint should prevent the password field from being blank'
        Teacher.count() == 0

      when: 'leaving confirm field blank'
      def y = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:" ", admin:true)
      y.passwordHashed = "aaaXSwDHDdSSSHhdhS"
      y.save()

        then: 'y.save() should not work because the constraint should prevent the confirm field from being blank'
        Teacher.count() == 0

      when: 'leaving admin field blank'
      def z = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin: null)
      z.passwordHashed = "aaaXSwDHDdSShhSHhdhS"
      z.save()

        then: 'z.save() should not work because the constraint should prevent the admin field from being blank'
        Teacher.count() == 0

      when: 'Username field is less than 5 characters long'
      def aa = new Teacher(firstName:"John", lastName:"Singer", username:"JSin", password:"password", confirm:"password", admin: true)
      aa.passwordHashed = "aaaXSwDHDdSSKJhhSHhdhS"
      aa.save()

        then: 'aa.save() should not work because the constraint should prevent the username field from being less than 5 characters long blank'
        Teacher.count() == 0

      when: 'Username field is more than 15 characters long'
      def bb = new Teacher(firstName:"John", lastName:"Singer", username:"JohnSinger151515", password:"password", confirm:"password", admin: true)
      bb.passwordHashed = "aaaXSwDHDdSSKQQJhhSHhdhS"
      bb.save()

        then: 'bb.save() should not work because the constraint should prevent the username field from being more than 15 characters long blank'
        Teacher.count() == 0

      when: 'Password field is less than 5 characters long'
      def cc = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"paxd", confirm:"paxd", admin: true)
      cc.passwordHashed = "aaaXSwDHDdSSKJWWhhSHhdhS"
      cc.save()

        then: 'cc.save() should not work because the constraint should prevent the password field from being less than 5 characters long blank'
        Teacher.count() == 0

      when: 'Password field is more than 15 characters long'
      def dd = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"passwordIsTooLong", confirm:"passwordIsTooLong", admin: true)
      dd.passwordHashed = "aaaXSwDHDdSSKJWWhhSHhdhS"
      dd.save()

        then: 'dd.save() should not work because the constraint should prevent the password field from being more than 15 characters long blank'
        Teacher.count() == 0

    }

    void 'Testing that a teacher can be a non-admin'() {

      when: 'admin field is false'
      def u = new Teacher(firstName:"John", lastName:"Singer", username:"JSinger", password:"password", confirm:"password", admin: false)
      u.passwordHashed = "aaaXSwDHDdSSKJWWhhSHhdBBhS"
      u.save()

        then: 'u.save() should work because user can be a non-admin'
        Teacher.count() == 1


    }

      void 'Testing password hashing works'() {

        //still need to figure out how to import PasswordCodec to access hashing method


      }

}
