package board

class Board {
    String subject
    String content
    User user
    Date dateCreated


    static constraints = {
        content nullable: true
    }

    static mapping = {
        subject length: 50
        content length: 2500
    }
}
