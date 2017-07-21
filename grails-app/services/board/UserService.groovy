package board

import grails.transaction.Transactional

@Transactional
class UserService {
    def springSecurityService

    def register(User user) {

        new UserRole(user: user, role: Role.findByAuthority("ROLE_USER"))
        user.save(flush: true)

    }

    def AuthenticateUser(def username, def password) {

        if(User.findByUsernameAndPassword(username, password))
            return true

        false
    }
}
