package board

class Board {
    User user
    String subject
    String content
    Date dateCreated

    static constraints = {
        content nullable: true
    }

    static mapping = {
        subject length: 50
        content length: 2500
    }
}
