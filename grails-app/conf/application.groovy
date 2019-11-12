grails {
    profile = "rest-api"
    codegen {
        defaultPackage = "com.locusnine.backend"
    }
    gorm {
        reactor {
            // Whether to translate GORM events into Reactor events
            // Disabled by default for performance reasons
            events: false
        }
    }
    cors {
        enabled = true
    }
    mime {
        disable {
            accept {
                header {
                    userAgents = [
                            "Gecko",
                            "WebKit",
                            "Presto",
                            "Trident"
                    ]
                }
            }
        }
        types {
            all = "*/*"
            atom = "application/atom+xml"
            css = "text/css"
            csv = "text/csv"
            form = "application/x-www-form-urlencoded"
            html = [
                    "text/html",
                    "application/xhtml+xml"
            ]
            js = "text/javascript"
            json = [
                    "application/json",
                    "text/json"
            ]
            multipartForm = "multipart/form-data"
            pdf = "application/pdf"
            rss = "application/rss+xml"
            text = "text/plain"
            hal = [
                    "application/hal+json",
                    "application/hal+xml"
            ]
            xml = [
                    "text/xml",
                    "application/xml"
            ]
        }
    }
    urlmapping {
        cache {
            maxsize = 1000
        }
    }
    controllers {
        defaultScope = "singleton"
        upload {
            maxFileSize = 10000000   // 10 Mb
            maxRequestSize = 10000000  // 10 Mb
        }
    }
    converters {
        encoding = "UTF-8"
    }
    views {
        "default" {
            codec = "html"
        }
        gsp {
            encoding = "UTF-8"
            htmlcodec = "xml"
            codecs {
                expression = "html"
                scriptlets = "html"
                taglib = "none"
                staticparts = "none"
            }
        }
    }

    web.url.converter = "hyphenated"
}

info {
    app {
        name = "@info.app.name@"
        version = "@info.app.version@"
        grailsVersion = "@info.app.grailsVersion@"
    }
}

spring {
    main {
        main["banner-mode"] = "off"
    }
    groovy {
        template {
            template["check-template-location"] = false
        }
    }
}

endpoints {
    enabled = false
    jmx {
        enabled = true
    }
}

hibernate {
    cache {
        queries = false
        use_second_level_cache = false
    }
}

dataSource {
    // Grails database-migration plugin will now maintain the DB schema
    dbCreate = "none"
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
    username = "root"
    password = "root"

    //noinspection GroovyAssignabilityCheck
    properties {
        jmxEnabled = true
        initialSize = 5
        maxActive = 50
        minIdle = 5
        maxIdle = 25
        maxWait = 10000
        maxAge = 600000
        timeBetweenEvictionRunsMillis = 5000
        minEvictableIdleTimeMillis = 60000
        validationQuery = "SELECT 1"
        validationQueryTimeout = 3
        validationInterval = 15000
        testOnBorrow = true
        testWhileIdle = true
        testOnReturn = false
        jdbcInterceptors = "ConnectionState"
        defaultTransactionIsolation = 2
    }
}

environments {
    development {
        dataSource {
            url = "jdbc:mysql://localhost:3306/locusnine_dev?autoReconnect=true&useSSL=false"
        }
    }
}
