package data.assessment.project

/*
* controller for the main view
*/
class MainController {

    /*
    * index for main, this is ran at least once each log in, redirects users
    * to ether client or admin side of the program depending on session/Admin status
    */
    def index() {
      if(session.teacher){
        if(session.teacher.admin == true){
          redirect(controller:"Admin")
        }else if (session.teacher.admin == false){
          redirect(controller:"client")
        }
      }
     }

     /*
     * allows switching of current year from any page
     */
     def changeYear() {
       def setYear = params.setYear
       session.year = setYear
       //redirect user back to there page
       redirect(uri:params.location.drop(4))
     }

     /*
     * abandoned work on trying to get a image to display from the database
     */
     def displayImage() {
       System.out.println(params.id)
       System.out.println("it is testing")
       def photosInstance = Document.get(params.id)
       response.contentType = 'image/jpeg'
       response.contentLength = photosInstance.photo.size()
       OutputStream out = response.outputStream
       out.write(photosInstance.photo)
       out.close()
     }
}
