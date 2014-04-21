package es.jripoll.yaus


class ShortLinkService {

    def grailsApplication


    def convertNumberToBase62(number) {
        def characters = grailsApplication.config.shortener.chars
        if (number >= 62 )
            convertNumberToBase62(number / 62 as Integer) + characters[number % 62]
        else
            characters[number]
    }

    def generateShortLink() {
        def characters = grailsApplication.config.shortener.chars
        def maxShortLinkId = ShortLink.executeQuery("select max(id) from ShortLink")[0] ?: 0
        convertNumberToBase62(maxShortLinkId as Integer).padLeft(5, characters[0])
    }

    def getOrCreateShortLink(targetUrl) {
        def shortLink = ShortLink.findByTargetUrl(targetUrl)
        if(shortLink)
            shortLink
        else {
            new ShortLink(targetUrl: targetUrl, link: generateShortLink()).save(failOnError: true)
        }
    }


}
