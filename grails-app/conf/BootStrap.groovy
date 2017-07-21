import board.Role
import board.User
import board.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findByAuthority("ROLE_ADMIN") ?: new Role(authority: "ROLE_ADMIN").save(flush: true)
        def userRole = Role.findByAuthority("ROLE_USER") ?: new Role(authority: "ROLE_USER").save(flush: true)

        if(!User.findByUsername("admin")) {
            def adminUser = new User(username: 'admin', password: '1234')
            assert adminUser.save(flush: true)
            UserRole.create adminUser, adminRole, true
        }

        if(!User.findByUsername('user1')) {
            def user1 = new User(username: 'user1', password: '1234')
            assert user1.save(flush: true)
            UserRole.create user1, userRole, true
        }
    }

    def destroy = {
    }
}
