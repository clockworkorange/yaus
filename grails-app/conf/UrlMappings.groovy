class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/shortLink/index")
        "/$shortUrl"(controller: "shortLink", action: "redirectToTargetUrl", params: [shortUrl: shortUrl])
        "500"(view:'/error')
	}
}
