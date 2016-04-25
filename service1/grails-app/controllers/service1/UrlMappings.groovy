package service1

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/account/$id/traditionalDeposit"(controller: "account", action: "traditionalDeposit")
        "/account/$id/reactiveDeposit"(controller: "account", action: "reactiveDeposit")

        "/"(controller: 'application', action: 'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
