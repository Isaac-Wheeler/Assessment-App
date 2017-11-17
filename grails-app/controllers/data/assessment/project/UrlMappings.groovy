package data.assessment.project

class UrlMappings {

    static mappings = {
    	  "/"(controller:"main")
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "500"(view:'/error')
        "404"(view:'/notFound')
        "/register"(controller:"User", action:"register")
        "/login"(controller:"User", action:"login")
        "/edit"(controller:"User", action:"edit")
        "/admin"(controller:"admin")
        "/client"(controller:"client")
        "/teachers"(controller:"Teachers")
        "/accessDenied"(view:'/accessDenied')
        "/outcomes/create"(view:'/outcomes/create')
        "/indicators/index"(controller:"outcomes")
        "/assessments/editAssessment"(controller:"assessments", action:"editAssessment")
        "/assessments/index"(controller:"assessments", action:"index")
    }
}
