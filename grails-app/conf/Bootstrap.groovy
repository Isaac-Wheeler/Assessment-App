import data.assessment.project.User
class BootStrap {
    def init = { servletContext ->
        if (User.count() == 0) {
            new User(firstName: 'John', lastName: 'Doe', dateCreated: 12/27/17).save()
            new User(firstName: 'Jane', lastName: 'Smith', dateCreated: 12/27/18).save()
            new User(firstName: 'Scott', lastName: 'Robinson', dateCreated: 12/27/19).save()
        }
    }
    def destroy = {
    }
}