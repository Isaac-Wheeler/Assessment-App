package data.assessment.project


import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TeacherSpec extends Specification implements DomainUnitTest<Teacher> {

    def setup() {
    }

    def cleanup() {
    }

    void 'Test adding, changing, and deleting a teacher'() {

        given: "A brand new teacher"
        def newTeacher = new Teacher(firstName: "Joe", lastName: "Singer", username: "JSinger", password: "password",
                        confirm: "password", passwordHashed: "AASSHHDDSS", admin: true)

        when: "The teacher is saved"
        newTeacher.save(flush:true)

        then: "Is saved successfully and can be found in the DB"
        newTeacher.errors.errorCount == 0
        newTeacher.id != null
        Teacher.get(newTeacher.id).username == "JSinger"

        when: "A property is changed changed"
        def foundTeacher = Teacher.get(newTeacher.id)
        foundTeacher.lastName = "Smith"
        foundTeacher.save(flush:true)

        then: "the change should be reflected in the DB"
        Teacher.get(newTeacher.id).lastName == "Smith"

        when: "Teacher is deleted"
        foundTeacher.delete(flush:true)

        then: "the teacher is removed from the DB"
        !Teacher.exists(foundTeacher.id)
        !Teacher.exists(newTeacher.id)
    }

    void "Test the firstName, lastName, and username constraint (blank/null)"() {

        given: "A teacher which fails all blank constraints"
        def newTeacher = new Teacher(firstName: " ", lastName: " ", username: " ", password: "password",
                        confirm: "password", passwordHashed: "AASSHHDDSS", admin: true)

        when: "the teacher is validated"
        newTeacher.validate()

        then:
        !newTeacher.validate(['firstName'])
        newTeacher.errors['firstName'].code == 'nullable'   // convertEmptyStringsToNull grails property
        !newTeacher.validate(['lastName'])
        newTeacher.errors['lastName'].code == 'nullable'
        !newTeacher.validate(['username'])
        newTeacher.errors['username'].code == 'nullable'


    }

    void "Test the admin blank/null constraint"() {

      given: "A teacher which fails to give admin either true or false"
      def nullAdminTeacher = new Teacher(firstName: "John", lastName: "Singer", username: "JSinger", password: "password",
                                        confirm: "password", passwordHashed: "AASSHHDDSS", admin: null)

      when: "the teacher is validated"
      nullAdminTeacher.validate()

      then:
      !nullAdminTeacher.validate(['admin'])
      nullAdminTeacher.errors['admin'].code == 'typeMismatch'   //admin needs to be either true or false, otherwise it fails

    }

    void "Test the password/confirm constraint"() {

      given: "A teacher which fails password matching"
      def newTeacher = new Teacher(firstName: "John", lastName: "Singer", username: "JSinger", password: "password",
                                        confirm: "passworddd", passwordHashed: "AASSHHDDSS", admin: true)

      when: "the teacher is validated"
      newTeacher.validate()

      then:
      !newTeacher.validate(['password'])
      newTeacher.errors['password'].code == 'teacher.password.dontmatch'    // the code shows that password failed the validator

    }

    void "Testing size constraints"() {

      given: "newTeacher and newTeacher2 that fails size constraints"
      def newTeacher = new Teacher(firstName: "John", lastName: "Singer", username: "JSin", password: "pass",
                                        confirm: "pass", passwordHashed: "AASSHHDDSS", admin: true)

      def newTeacher2 = new Teacher(firstName: "John", lastName: "Singer", username: "JohnSinger151515", password: "passwordIsMuchTooLong",
                                  confirm: "passwordIsMuchTooLong", passwordHashed: "AASSHHDDSS", admin: true)



      when: "newTeacher and newTeacher2 is validated"
      newTeacher.validate()
      newTeacher2.validate()


      then:
      !newTeacher.validate(['username'])
      newTeacher.errors['username'].code == 'size.toosmall'
      !newTeacher.validate(['password'])
      newTeacher.errors['password'].code == 'size.toosmall'
      !newTeacher2.validate(['username'])
      newTeacher2.errors['username'].code == 'size.toobig'
      !newTeacher2.validate(['password'])
      newTeacher2.errors['password'].code == 'size.toobig'


    }

    void "Testing username unique constraints"() {

      given: "newTeacher2 that fails usrename unique constraint"
      def newTeacher = new Teacher(firstName: "John", lastName: "Singer", username: "JSinger", password: "password",
                                        confirm: "password", passwordHashed: "AASSHHDDSS", admin: true)

      def newTeacher2 = new Teacher(firstName: "Jane", lastName: "Singer", username: "JSinger", password: "password",
                                    confirm: "password", passwordHashed: "AASSHHDDSSSS", admin: true)

       when: "newTeacher and newTeacher2 are saved"
       newTeacher.save(flush:true)
       newTeacher2.save(flush:true)

       then:
       Teacher.count() == 1
       !newTeacher2.save()

    }

}
