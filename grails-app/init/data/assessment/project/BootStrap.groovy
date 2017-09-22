package data.assessment.project

class BootStrap {

    def init = { servletContext ->
      if(User.count() == 0){
       def u = new User(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", confirm:"password", admin:true)
       u.passwordHashed = u.password.encodeAsPassword()
       u.save()
       System.out.println("added defualt admin")
      }
    }
    def destroy = {
    }
}
