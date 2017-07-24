package board

class User {

	transient springSecurityService

	String username
	String password
	String email
	String fullName
	String nickname

	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
		email blank: false
		fullName blank: false
		nickname blank: false, unique: true
	}

	static mapping = {
		password column: '`password`'
	}

	static hasMany = [oAuthIDs: OAuthID]

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
