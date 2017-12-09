package data.assessment.project

class userController {


    def register = {
        // new user posts his registration details
        if (request.method == 'POST') {
          if(!params.submitButton.contains("Cancel")){
            // create domain object and assign parameters using data binding
            def u = new Teacher(params)
            u.passwordHashed = u.password.encodeAsPassword()
            if (! u.save(flush:true)) {
                // validation failed, render registration page again
                return [teacher:u]
            } else {
                redirect(controller:'main')
            }

        }
        redirect(controller:'main')
      }
    }

    def login = {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def u = Teacher.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            if (u) {
                // username and password match -> log in
                session.teacher = u
                redirect(controller:'main')
            } else {
                flash.error = "User/Password not found"
                redirect(controller:'main')
            }
        } else if (session.teacher) {
            // don't allow login while user is logged in
            redirect(controller:'main')
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller:'main')
    }

    def delete = {
      def u = Teacher.get(params.teacher)
      u.delete(flush:true)
      redirect(controller:'teachers')
    }

    def edit ={
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          // create domain object and assign parameters using data binding
          def u = Teacher.get(params.id)
          u.username = params.username
          u.lastName = params.lastName
          u.firstName = params.firstName
          u.admin = params.admin
          if(params.password == null){
          u.password = params.password
          u.confirm = params.confirm
          u.passwordHashed = u.password.encodeAsPassword()
          }
          if (! u.save(flush:true)) {
              // validation failed, render registration page again
              return [teacher:u, id:u.id]
          } else {
              redirect(controller:'Teachers')
          }
        }
      }else{
        def u = Teacher.get(params.teacher)
        return [teacher:u, id:u.id]
        redirect(view:'edit')
      }
    }
}
