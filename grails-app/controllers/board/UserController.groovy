package board

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured("ROLE_USER")
@Transactional(readOnly = true)
class UserController {
    def userService
    def springSecurityService
    def googleSpringSecurityOAuthService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def show() {
        def userInstance = springSecurityService.getCurrentUser()

        respond userInstance
    }

    @Transactional
    @Secured("permitAll")
    def register(User userInstance) {

        if(springSecurityService.loggedIn) {
            notFound()
            return
        }


        if (userInstance == null) {
            notFound()
            return
        }

        if(User.findByUsername(userInstance.username)) {
            flash.message = '아이디 중복'
            redirect(action: 'create')
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'register'
            return
        }

        try {
            userService.register(userInstance)
        } catch (e) {
            e.printStackTrace()
            flash.message = e.message
            redirect(action: 'create')
        }


        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }


    def edit(User userInstance) {

        if(userInstance != springSecurityService.loadCurrentUser()) {
            notFound()
            return
        }


        respond userInstance
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if(userInstance != springSecurityService.loadCurrentUser()) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush: true, failOnError: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
