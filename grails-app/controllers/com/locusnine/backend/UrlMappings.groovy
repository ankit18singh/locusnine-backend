package com.locusnine.backend

class UrlMappings {

    static mappings = {

        "/$namespace/$controller/$action?/$id?" {
        }

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
