package data.assessment.project

class BootStrap {

    def init = { servletContext ->
      environments {
        production {

          if(Teacher.count() == 0){
           def u = new Teacher(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
           u.passwordHashed = u.password.encodeAsPassword()
           u.save()
           System.out.println("added default admin")
           def settings = new Settings(academicYear:"2017-2018")
           settings.save(flush:true)
           System.out.println("added default year")
          }
        }
        development {
          def settings = new Settings(academicYear:"2017-2018")
          settings.save(flush:true)
          def u = null
          if(Teacher.count() == 0){
           u = new Teacher(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
           u.passwordHashed = u.password.encodeAsPassword()
           u.save(flush: true)
           System.out.println("added default admin")
           def t = new Teacher(firstName:"teacher", lastName:"DeleteMe", username:"teacher", password:"password", confirm:"password", admin:false)
           t.passwordHashed = t.password.encodeAsPassword()
           t.save(flush: true)
           System.out.println("added default teacher")
          }
          if (Outcomes.count() == 0 && Classes.count() == 0 && Indicators.count() == 0 && Measures.count() == 0&& Assessment_Documentation.count() == 0) {
            def a = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to...", academicYear:"2017-2018")
            def b = new Classes(title: "CS481")
            def c = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", academicYear:"2017-2018")
            def d = new Measures(measureTitle: "Exam1", measureDescription: "Student will be able to")
            def e = new Assessment_Documentation(targetGoal: 20, numberOfStudents: 40, needsImprovement: 15, meetsExpectations: 15, exceedsExpectations: 10, assessmentDocTitle: "Question1", comments:"Hello World!", summary: "Student will be able to", requiredAction: "Hello World!", resultComment: "Hello World!",  complete: false)
            a.addToIndicators(c)
            c.addToClasses(b)
            c.addToMeasures(d)
            d.addToAssessment_documents(e)
            e.setMeasure(d)

            b.addToTeachers(u)

            a.save()
            b.save()
            c.save()
            d.save()
            e.save()
            System.out.println("added test data")
        }
        }
        test {
          def settings = new Settings(academicYear:"2017-2018")
          settings.save(flush:true)
          if(Teacher.count() == 0 && Classes.count() == 0){
           def u = new Teacher(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
           u.passwordHashed = u.password.encodeAsPassword()
           u.save(flush: true)
           def b = new Classes(title: "CS481")
           b.addToTeachers(u)
           def e = new Classes(title: "CS340")
           b.save(flush: true)
           e.save(flush: true)
           System.out.println("added default admin")
          }
          if (Outcomes.count() == 0) {

            def a = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to...", academicYear:"2017-2018")
            def c = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to", academicYear:"2017-2018")
            def d = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
            a.addToIndicators(c)
            c.addToMeasures(d)
            if (a.validate()) {
              a.save(flush:true)
              }
            else {
                  a.errors.allErrors.each {
                      println it
                  }
            }
            def f = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to", academicYear:"2017-2018")
            def g = new Measures(measureTitle: "Exam1_Q2", measureDescription: "Student will be able to")

            def h = new Classes(title: "CS450")
            def i = new Classes(title: "CS452")
            h.save(flush: true)
            i.save(flush: true)
            f.addToClasses(h)
            f.addToClasses(i)


            a.addToIndicators(f)
            f.addToMeasures(g)
            if (a.validate()) {
              a.save(flush:true)
              }
            else {
                  a.errors.allErrors.each {
                      println it
                  }
            }
            System.out.println("added default outcomes/indicators/measures for test env")

          }

        }
        }
    }



    def destroy = {
    }
}
