package board

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured("permitAll")
@Transactional(readOnly = true)
class BoardController {
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Board.list(params), model:[boardInstanceCount: Board.count()]
    }

    def show(Board boardInstance) {

        boardInstance.content = boardInstance.content?.replaceAll("\\r\\n", "<br />")

        def user = springSecurityService?.loadCurrentUser()

        respond boardInstance, model: [user: user]

    }

    @Secured("hasRole('ROLE_USER')")
    def create() {
        respond new Board()
    }

    @Transactional
    @Secured("hasRole('ROLE_USER')")
    def save(Board boardInstance) {
        if (boardInstance == null) {
            notFound()
            return
        }

        if (boardInstance.hasErrors()) {
            respond boardInstance.errors, view:'create'
            return
        }

        boardInstance.user = springSecurityService.getCurrentUser()

        boardInstance.save(flush:true)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'board.label', default: 'Board'), boardInstance.id])
                redirect boardInstance
            }
            '*' { respond boardInstance, [status: CREATED] }
        }
    }

    @Secured("hasRole('ROLE_USER')")
    def edit(Board boardInstance) {

        if(boardInstance.user != springSecurityService.getCurrentUser()) {
            notFound()
            return
        }

        respond boardInstance
    }


    @Transactional
    @Secured("hasRole('ROLE_USER')")
    def update(Board boardInstance) {
        if (boardInstance == null) {
            notFound()
            return
        }

        if(boardInstance.user != springSecurityService.getCurrentUser()) {
            notFound()
            return
        }

        if (boardInstance.hasErrors()) {
            respond boardInstance.errors, view:'edit'
            return
        }

        boardInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Board.label', default: 'Board'), boardInstance.id])
                redirect boardInstance
            }
            '*'{ respond boardInstance, [status: OK] }
        }
    }

    @Transactional
    @Secured("hasRole('ROLE_USER')")
    def delete(Board boardInstance) {

        if (boardInstance == null) {
            notFound()
            return
        }

        if(boardInstance.user != springSecurityService.getCurrentUser()) {
            notFound()
            return
        }

        boardInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Board.label', default: 'Board'), boardInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'board.label', default: 'Board'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
