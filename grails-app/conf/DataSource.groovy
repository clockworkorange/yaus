dataSource {
    pooled = true
    driverClassName = "org.hsqldb.jdbcDriver"
    dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "off" // one of 'create', 'create-drop', 'update'
            url = "jdbc:mysql://localhost/yaus"
            driverClassName = "com.mysql.jdbc.Driver"
            username = "yaus"
            password = "yaus"
            //password = "s1g4"
            dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
            //loggingSql = true
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
            }
        }
    }

    test {
        dataSource {
            dbCreate = "off"
            url = "jdbc:mysql://localhost/yausDBTest"
            driverClassName = "com.mysql.jdbc.Driver"
            username = "yaus"
            password = "yaus"
            dialect = 'org.hibernate.dialect.MySQL5InnoDBDialect'
            //loggingSql = true
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
            }
        }
    }

    production {
        def dbHost = System.getProperty('db.host', 'localhost')
        def dbPort = System.getProperty('db.port', '3306')
        def dbSchema = System.getProperty('db.schema', 'yausDB')
        def dbUsername = System.getProperty('db.username', 'yaus')
        def dbPassword = System.getProperty('db.password', 'y4u5')
        dataSource {
            dbCreate = "off"  // disabled to work with legacy databases
            url = "jdbc:mysql://${dbHost}:${dbPort}/${dbSchema}"
            driverClassName = 'com.mysql.jdbc.Driver'
            dialect = 'org.hibernate.dialect.MySQLInnoDBDialect'
            username = "${dbUsername}"
            password = "${dbPassword}"
            properties {
                maxActive = 50
                maxIdle = 25
                minIdle = 5
                initialSize = 5
                minEvictableIdleTimeMillis = 60000
                timeBetweenEvictionRunsMillis = 60000
                maxWait = 10000
            }
        }
    }
}