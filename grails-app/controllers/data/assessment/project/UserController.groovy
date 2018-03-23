package data.assessment.project

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.oreilly.servlet.MultipartRequest;

class userController {


    def register = {
        // new user posts his registration details
        if (request.method == 'POST') {
          if(!params.submitButton.contains("Cancel")){
            // create domain object and assign parameters using data binding
            if(!BootStrap.isPerm(true, session)){
              redirect(controller:'main')
            }else{
              def u = new Teacher(params)
              u.passwordHashed = u.password.encodeAsPassword()
              if (! u.save(flush:true)) {
                // validation failed, render registration page again
                return [teacher:u]
              }
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
      if(!BootStrap.isPerm(true, session)){
        redirect(controller:'main')
      }else{
        def u = Teacher.get(params.teacher)
        u.delete(flush:true)
        redirect(controller:'teachers')
      }
    }

    def edit ={
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          // create domain object and assign parameters using data binding
          if(!BootStrap.isPerm(true, session)){
            redirect(controller:'main')
          }else{
            def u = Teacher.get(params.id)
            u.username = params.username
            u.lastName = params.lastName
            u.firstName = params.firstName
            if(params.admin){
              u.admin = params.admin
            }
            if(params.password == null){
              u.password = params.password
              u.confirm = params.confirm
              u.passwordHashed = u.password.encodeAsPassword()
            }
            if (! u.save(flush:true)) {
              // validation failed, render registration page again
                return [teacher:u, id:u.id]
              }
            }
          }
        redirect(controller:'Teachers')
      }else{
        def u = Teacher.get(params.teacher)
        return [teacher:u, id:u.id]
        redirect(view:'edit')
      }
    }

    def editFaculty ={
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          if(!BootStrap.isPerm(false, session)){
            redirect(controller:'main')
          }else{
          // create domain object and assign parameters using data binding
          def u = Teacher.get(params.id)
          u.lastName = params.lastName
          u.firstName = params.firstName
          if(params.password == null){
          u.password = params.password
          u.confirm = params.confirm
          u.passwordHashed = u.password.encodeAsPassword()
          }

          // fetch the uploaded image for assigning profile picture to teacher account

            def file = request.getFile('profilePic')
            if (file.isEmpty()) {
            }
            else {
              def documentInstance = new Document();
              documentInstance.filename = file.originalFilename
              documentInstance.filedata = file.getBytes()
              u.profilePic = documentInstance
            }


          if (! u.save(flush:true)) {
              // validation failed, render registration page again
              return [teacher:u, id:u.id]
          }

        }
      }
        redirect(controller:'main')
      }else{
        def u = Teacher.get(params.teacher)
        return [teacher:u, id:u.id]
        redirect(view:'edit')
      }
    }

    def urlSignup = {
      //localhost:8080/DAA/user/urlSignup?teacher=1
      if (request.method == 'POST') {
        if(!params.submitButton.contains("Cancel")){
          // create domain object and assign parameters using data binding
          def u = Teacher.get(params.id)
          u.lastName = params.lastName
          u.firstName = params.firstName
          if(params.password == null){
          u.password = params.password
          u.confirm = params.confirm
          u.passwordHashed = u.password.encodeAsPassword()
          }

          // fetch the uploaded image for assigning profile picture to teacher account

            def file = request.getFile('profilePic')
            if (file.isEmpty()) {
            }
            else {
              def documentInstance = new Document();
              documentInstance.filename = file.originalFilename
              documentInstance.filedata = file.getBytes()
              u.profilePic = documentInstance
            }

            u.urlSignup = false;
          if (! u.save(flush:true)) {
              // validation failed, render registration page again
              return [teacher:u, id:u.id]
          }

        }
        redirect(controller:'main')
      }else{
        def u = Teacher.get(params.teacher)
        if(!u.urlSignup){
          redirect(controller:'main')
        }
        return [teacher:u, id:u.id]
        redirect(view:'edit')
      }
    }
}
