package es.jripoll.yaus


class ShortLinkController {

    def shortLinkService

    def createShortLink = {
        def targetUrl = params['targetUrl']
        if(targetUrl) {
            render(
                    view: 'index',
                    model: [shortLink: shortLinkService.getOrCreateShortLink(params['targetUrl'])]
            )
        }
        else
            redirect(uri: "/")
    }

}
