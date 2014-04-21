package es.jripoll.yaus


class ShortLinkController {

    def shortLinkService

    def createShortLink = {
        render(
                view: 'index',
                model: [shortLink: shortLinkService.getOrCreateShortLink(params['targetUrl'])]
        )
    }

}
