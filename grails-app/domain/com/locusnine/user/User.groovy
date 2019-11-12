package com.locusnine.user

/**
 * Domain class to hold database schema for the User table.
 *
 * @author Ankit Kumar Singh
 */
class User {

    static constraints = {
        name maxSize: 30, blank: false
        mobile blank: false, nullable: true, size: 5..15
        emailID maxSize: 50, email: true, blank: false
    }

    static mapping = {
        roleType enumType: "identity"
        emailID unique: true
        mobile unique: true
    }

    String name
    String emailID
    String mobile

    RoleType roleType
    Status status
}

enum RoleType {
    ADMIN((byte) 1),
    CUSTOMER_EXECUTIVE((byte) 2)

    final byte id

    RoleType(byte id) {
        this.id = id
    }
}

enum Status {
    ACTIVE((byte) 1),
    IN_ACTIVE((byte) 2),
    PENDING((byte) 3)

    final byte id

    Status(byte id) {
        this.id = id
    }
}
