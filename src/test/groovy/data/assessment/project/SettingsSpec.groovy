package data.assessment.project

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class SettingsSpec extends Specification implements DomainUnitTest<Settings> {

    def setup() {
    }

    def cleanup() {
    }

    void "testing creating and deleting a new Settings object"() {

        when: "A new settings object is given proper properties it should be created successfully"
          def newSetting = new Settings(academicYear: "2017-2018")
          newSetting.save(flush:true)

        then: "Settings.count() should equal 1"
          Settings.count() == 1

        when: "The newly created Settings object is deleted"
          newSetting.delete(flush:true)

        then: "Settings.count() should equal 0"
          Settings.count() == 0


    }

    void "testing creating and deleting a new Settings object"() {

        when: "A new settings object is attempted to be saved with academicYear being null"
          def newSetting = new Settings(academicYear: " ")
          newSetting.save(flush:true)

        then: "Settings.count() should equal 0 because the constraints prevent the academicYear from being created as a blank or null"
          Settings.count() == 0

        when: "An object is given proper properties for creation"
          def newSetting2 = new Settings(academicYear: "2017-2018")
          newSetting2.save(flush:true)

        then: "Settings.count() should equal 1"
          Settings.count() == 1

        when: "An object is given proper properties for creation"
          def newSetting3 = new Settings(academicYear: "2017-2018")
          newSetting3.save(flush:true)

        then: "Settings.count() should equal 1 because the unique constraint should prevent any creation of multiple objects with the same academicYear"
          Settings.count() == 1


    }

}
