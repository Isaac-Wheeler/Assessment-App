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
    }
}
