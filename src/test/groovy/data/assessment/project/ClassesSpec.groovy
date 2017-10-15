package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ClassesSpec extends Specification implements DomainUnitTest<Classes> {

    def setup() {
    }

    def cleanup() {
    }

    void "Testing adding and deleting a new class"() {

      when: 'Adding a new class with valid permissions'
      def u = new Classes(title: "CS101")
      u.save()

        then: 'New class should be saved successfully'
        Classes.count() == 1

      when: 'deleting a class'
      u.delete()

        then: 'Class should be deleted successfully'
        Classes.count() == 0


    }

    void "Testing Clesses constraints"() {

      when: 'Adding a new class with blank title'
      def u = new Classes(title: " ")
      u.save()

        then: 'New class should not be saved successfully'
        Classes.count() == 0

      when: 'Adding a new class with less than 5 characters in the title'
      def v = new Classes(title: "CS10")
      v.save()

        then: 'New class should not be saved successfully'
        Classes.count() == 0

      when: 'Adding a new class with more than 6 characters in the title'
      def w = new Classes(title: "ECE1010")
      w.save()

        then: 'New class should not be saved successfully'
        Classes.count() == 1

        //start of test for uniqueness in title
      when: 'Adding a new class with valid properties'
      def x = new Classes(title: "CS101")
      x.save()

        then: 'New class should be saved successfully'
        Classes.count() == 2

      when: 'Adding a new class with a title that matches an already saved class'
      def y = new Classes(title: "CS101")
      y.save()

        then: 'New class should not be saved successfully'
        Classes.count() == 2



    }

}
