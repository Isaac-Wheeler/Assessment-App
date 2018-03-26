package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CoursesSpec extends Specification implements DomainUnitTest<Courses> {

    def setup() {
    }

    def cleanup() {
    }

    void "Testing adding and deleting a new class"() {

      given: "A brand new class"
      def newClass = new Courses(title: "CS320")

      when: "The class is saved"
      newClass.save(flush:true)

      then: "Is saved successfully and can be found in the DB"
      newClass.errors.errorCount == 0
      newClass.id != null
      Courses.get(newClass.id).title == "CS320"

      when: "A property is changed changed"
      def foundClass = Courses.get(newClass.id)
      foundClass.title = "CS420"
      foundClass.save(flush:true)

      then: "the change should be reflected in the DB"
      Courses.get(newClass.id).title == "CS420"

      when: "Class is deleted"
      foundClass.delete(flush:true)

      then: "the Class is removed from the DB"
      !Courses.exists(foundClass.id)
      !Courses.exists(newClass.id)
      newClass.delete(flush:true)


    }

    void "Testing Clesses constraints"() {

      given: "a class has fields that fail constraints"
      def newClass = new Courses(title: " ")

      when: "class is validated"
      newClass.validate()

      then:
      !newClass.validate(['title'])
      newClass.errors['title'].code == 'nullable'   // convertEmptyStringsToNull grails property

      when: "testing validation on a new class that fails the minSize constraint on Title"
      def newClass2 = new Courses(title: "CS42")
      newClass2.validate()

      then:
      !newClass2.validate(['title'])
      newClass2.errors['title'].code == 'minSize.notmet'


      newClass.delete(flush:true)
      newClass2.delete(flush:true)


    }

    void "testing list of indicators in outcomes"() {

      when: "Creating a couple of classes, indicators, and teachers and linking them relationally"
      def newIndicator = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
      def newIndicator2 = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to")
      def newIndicator3 = new Indicators(indicatorName: "b.1", indicatorDescription: "Students will be able to")

      def newTeacher = new Teacher(firstName: "Joe", lastName: "Singer", username: "JSinger", password: "password",
                      confirm: "password", passwordHashed: "AASSHHDDSX", admin: true)
      def newTeacher2 = new Teacher(firstName: "John", lastName: "Smith", username: "JSmith", password: "password",
                      confirm: "password", passwordHashed: "AASSHHDDSS", admin: true)
      def newTeacher3 = new Teacher(firstName: "Jane", lastName: "Harley", username: "JHarley", password: "password",
                      confirm: "password", passwordHashed: "AASSHHDDST", admin: true)

      def newClass = new Courses(title: "CS320")
      def newClass2 = new Courses(title: "CS350")
      def newClass3 = new Courses(title: "CS420")

      newClass.addToIndicators(newIndicator)
      newClass2.addToIndicators(newIndicator2)
      newClass3.addToIndicators(newIndicator3)

      newClass.addToTeachers(newTeacher)
      newClass2.addToTeachers(newTeacher2)
      newClass3.addToTeachers(newTeacher3)

      newClass.save(flush:true)
      newClass2.save(flush:true)
      newClass3.save(flush:true)

        then: "the 3 classes and the 4 indicators and the 3 teachers should have been saved correctly"
        Courses.count() == 3
        Indicators.count() == 3
        Teacher.count() == 3

      when: "finding all indicators associated with their classes"
      def aa = Courses.findAllByTitle("CS320")
      def bb = Courses.findAllByTitle("CS350")
      def cc = Courses.findAllByTitle("CS420")

        then: "There should be 2 indicators associated with CS320, and 1 indicator associated with the other two classes"
        aa.indicators.size() == 1
        aa.indicators[0].indicatorName == ["a.1"]
        bb.indicators.size() == 1
        bb.indicators[0].indicatorName == ["a.2"]
        cc.indicators.size() == 1
        cc.indicators[0].indicatorName == ["b.1"]
        aa.teachers.size() == 1
        aa.teachers[0].firstName == ["Joe"]
        bb.teachers.size() == 1
        bb.teachers[0].firstName == ["John"]
        cc.teachers.size() == 1
        cc.teachers[0].firstName == ["Jane"]
        newClass.delete(flush:true)
        newClass2.delete(flush:true)
        newClass3.delete(flush:true)
        newTeacher.delete(flush:true)
        newTeacher2.delete(flush:true)
        newTeacher3.delete(flush:true)
        newIndicator.delete(flush:true)
        newIndicator2.delete(flush:true)
        newIndicator3.delete(flush:true)

    }

}
