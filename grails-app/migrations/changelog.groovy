databaseChangeLog = {

    changeSet(author: "ankit18singh (generated)", id: "1573390727971-1") {
        createTable(tableName: "user") {
            column(autoIncrement: "true", name: "id", type: "BIGINT") {
                constraints(primaryKey: "true", primaryKeyName: "userPK")
            }

            column(name: "version", type: "BIGINT") {
                constraints(nullable: "false")
            }

            column(name: "mobile", type: "VARCHAR(15)")

            column(name: "name", type: "VARCHAR(30)") {
                constraints(nullable: "false")
            }

            column(name: "emailid", type: "VARCHAR(50)") {
                constraints(nullable: "false")
            }

            column(name: "role_type", type: "TINYINT") {
                constraints(nullable: "false")
            }

            column(name: "status", type: "VARCHAR(255)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "ankit18singh (generated)", id: "1573390727971-2") {
        addUniqueConstraint(columnNames: "emailid", constraintName: "UC_USEREMAILID_COL", tableName: "user")
    }

    changeSet(author: "ankit18singh (generated)", id: "1573390727971-3") {
        addUniqueConstraint(columnNames: "mobile", constraintName: "UC_USERMOBILE_COL", tableName: "user")
    }
}
