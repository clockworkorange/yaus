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
        def shortLinkMaxId = getShortLinkMaxId() ?: 0
        convertNumberToBase62(shortLinkMaxId as Integer).padLeft(
                grailsApplication.config.shortener.lengthCode, characters[0])
    }

    def getOrCreateShortLink(targetUrl) {
        def shortLink =  (ShortLink.findByTargetUrl(targetUrl) ?: new ShortLink(
                targetUrl: targetUrl,
                link: "${grailsApplication.config.shortener.domain}${generateShortLink()}"))
        if(shortLink.validate())
            shortLink.save(failOnError: true)

        shortLink
    }

    def getShortLinkMaxId() {
        ShortLink.createCriteria().get {
            projections {
                max('id')
            }
        }
    }
}
