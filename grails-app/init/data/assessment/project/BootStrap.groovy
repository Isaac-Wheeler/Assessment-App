package data.assessment.project

class BootStrap {

    def init = { servletContext ->
      if(User.count() == 0){
       def u = new User(firstName:"admin", lastName:"DeleteMe", username:"admin", password:"password", admin:true)
       u.passwordHashed = u.password.encodeAsPassword()
       u.save()
       System.out.println("added defualt admin")
       u = new User(firstName:"teacher", lastName:"DeleteMe", username:"teacher", password:"password", admin:false)
       u.passwordHashed = u.password.encodeAsPassword()
       u.save()
       System.out.println("added default teacher")
      }
    }
    def destroy = {
    }
}
