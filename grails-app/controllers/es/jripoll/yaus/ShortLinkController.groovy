package es.jripoll.yaus


class ShortLinkController {

    def shortLinkService

    def createShortLink = {
        def targetUrl = params['targetUrl']
        if(targetUrl) {
            render(view: 'index', model: [shortLink: shortLinkService.getOrCreateShortLink(params['targetUrl'])])
        }
        else {
            flash.message = g.message(code: 'shortLink.targetUrl.empty.message')
            redirect uri: '/'
        }
    }

    def redirectToTargetUrl = {
        def shortLink = ShortLink.findByLink("${grailsApplication.config.shortener.domain}${params['shortUrl']}")
        if(shortLink)
            redirect(url: shortLink.targetUrl)
        else {
            flash.message = g.message(code: 'shortLink.link.empty.message')
            redirect uri: '/'
        }
    }
}
