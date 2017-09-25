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
        "/adminProfileAssessmentGoals"(view:'/adminProfileAssessmentGoals')
        "/admin"(controller:"admin")
        "/client"(controller:"client")
        "/createOutcome"(view:'/assessments/createOutcome')
        "/editOutcome"(view:'/assessments/editOutcome')
        "/teachers"(controller:"Teachers")
        "/accessDenied"(view:'/accessDenied')
    }
}
