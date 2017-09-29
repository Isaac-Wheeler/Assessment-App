package data.assessment.project

class BootStrap {

    def init = { servletContext ->
      if(Teacher.count() == 0){
       def u = new Teacher(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
       u.passwordHashed = u.password.encodeAsPassword()
       u.save()
       System.out.println("added default admin")
      }
    }
    def destroy = {
    }
}
