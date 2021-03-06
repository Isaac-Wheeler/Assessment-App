package data.assessment.project

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import com.oreilly.servlet.MultipartRequest;


/*
* controller that handles all items to due with user/teacher methods
*/
class userController {

    /*
    * handles creating a new teacher item in the database (admin only)
    */
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

    /*
    * handles teacher login
    */
    def login = {
        if (request.method == 'POST') {
            def passwordHashed = params.password.encodeAsPassword()
            def u = Teacher.findByUsernameAndPasswordHashed(params.username, passwordHashed)
            if (u) {
                // username and password match -> log in
                session.teacher = u
                session.profilePic = session.teacher.profilePic
                u.lastLogin = new Date()
                if(!u.save(flush:true)){
                  //todo:add error thorwing
                }
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

    /*
    * handles logout of teachers
    */
    def logout = {
        session.invalidate()
        redirect(controller:'main')
    }

    /*
    * handles deleting of a teacher/user
    */
    def delete = {
      if(!BootStrap.isPerm(true, session)){ //checks if callie has perms to delete
        redirect(controller:'main')
      }else{
        def u = Teacher.get(params.teacher)
        u.delete(flush:true)
        redirect(controller:'teachers')
      }
    }

    /*
    * handles editing of a teacher admin only.
    */
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
            if(params.password){ //if a password was entered then make it the new password for the account.
            u.password = params.password
            u.confirm = params.confirm
            u.passwordHashed = u.password.encodeAsPassword()
            }
            else {
            }
            if(params.urlSignup){
              u.urlSignup = params.urlSignup
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

    /*
    * handles editing of there own teacher user info
    */
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
          if(params.password){    //if a password was entered then make it the new password for the account.
          u.password = params.password
          u.confirm = params.confirm
          u.passwordHashed = u.password.encodeAsPassword()
          }
          else {
          }


            def file = request.getFile('profilePic')              // fetch the uploaded image for assigning profile picture to teacher account
            if (file.isEmpty()) {
            }
            else {
              def documentInstance = new Document();
              documentInstance.filename = file.originalFilename
              documentInstance.filedata = file.getBytes()
              u.profilePic = documentInstance
              if(! documentInstance.save(flush:true)){
                System.out.println("error") //todo:fix
              }
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

    /*
    *allows for the teacher to use a url to edit there teacher info enabled at
    * admin's discresion code is highly similer to edit except missing session id requirement
    */

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
