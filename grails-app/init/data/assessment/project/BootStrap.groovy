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
          }
        }
        development {
          if(Teacher.count() == 0){
           def u = new Teacher(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
           u.passwordHashed = u.password.encodeAsPassword()
           u.save(flush: true)
           System.out.println("added default admin")
          }
          if (Outcomes.count() == 0 && Classes.count() == 0 && Indicators.count() == 0 && Measures.count() == 0) {
            def a = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to...")
            def b = new Classes(title: "CS481")
            def c = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
            def d = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
            a.addToIndicators(c)
            c.addToMeasures(d)
            a.save()
            b.save()
            c.save()
            d.save()
            System.out.println("added test data")
        }
        }
        test {
          if(Teacher.count() == 0){
           def u = new Teacher(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
           u.passwordHashed = u.password.encodeAsPassword()
           u.save(flush: true)
           System.out.println("added default admin")
          }
          if (Outcomes.count() == 0 && Classes.count() == 0 && Indicators.count() == 0 && Measures.count() == 0) {
            def a = new Outcomes(outcomeCategory: 'A', outcomeCategoryDescription: "Students will learn how to...")
            def b = new Classes(title: "CS481")
            def c = new Indicators(indicatorName: "a.1", indicatorDescription: "Students will be able to")
            def d = new Measures(measureTitle: "Exam1_Q1", measureDescription: "Student will be able to")
            a.addToIndicators(c)
            c.addToMeasures(d)
<<<<<<< HEAD
            a.save(flush: true)
            b.save(flush: true)
            def e = new Classes(title: "CS340")
            def f = new Indicators(indicatorName: "a.2", indicatorDescription: "Students will be able to")
            def g = new Measures(measureTitle: "Exam1_Q2", measureDescription: "Student will be able to")
            a.addToIndicators(f)
            f.addToMeasures(g)
            e.save(flush: true)
        }
        }
=======
            a.save()
            b.save()
            c.save()
            d.save()
            System.out.println("added test data")
>>>>>>> 0d8d3480d8639265d68ef5b935ef271f71e5580d
    }
  }
}

    def destroy = {
    }
}
