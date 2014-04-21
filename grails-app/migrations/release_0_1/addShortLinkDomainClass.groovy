package release_0_1

databaseChangeLog = {

    changeSet(author: "julio@ripollmoreno.com", id: "1398009886909-1") {
        createTable(tableName: "short_link") {
            column(autoIncrement: "true", name: "id", type: "bigint") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "short_linkPK")
            }

            column(name: "version", type: "bigint") {
                constraints(nullable: "false")
            }

            column(name: "target_url", type: "varchar(2000)") {
                constraints(nullable: "false")
            }

            column(name: "link", type: "varchar(255)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "datetime") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "julio@ripollmoreno.com", id: "1398009886909-2") {
        createIndex(indexName: "link_uniq_1398009886887", tableName: "short_link", unique: "true") {
            column(name: "link")
        }
    }
}