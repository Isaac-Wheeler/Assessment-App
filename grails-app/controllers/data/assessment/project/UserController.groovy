package data.assessment.project

class UserController {


    def register = {
        // new user posts his registration details
        if (request.method == 'POST') {
            // create domain object and assign parameters using data binding
            def u = new User(params)
            u.passwordHashed = u.password.encodeAsPassword()
            if (! u.save()) {
                // validation failed, render registration page again
                return [user:u]
            } else {
                redirect(controller:'main')
            }

        }
    }

    def login = {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def u = User.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            if (u) {
                // username and password match -> log in
                session.user = u
                redirect(controller:'main')
            } else {
                flash.error = "User/Password not found"
                redirect(controller:'main')
            }
        } else if (session.user) {
            // don't allow login while user is logged in
            redirect(controller:'main')
        }
    }

    def logout = {
        session.invalidate()
        redirect(controller:'main')
    }

    def delete = {
      def u = User.get(params.teacher)
      u.delete(flush:true)
      redirect(controller:'teachers')
    }
}
