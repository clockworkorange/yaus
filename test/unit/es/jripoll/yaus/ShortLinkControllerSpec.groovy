package es.jripoll.yaus



import grails.test.mixin.*
import spock.lang.*

@TestFor(ShortLinkController)
@Mock(ShortLink)
class ShortLinkControllerSpec extends Specification {

    def shortLinkService = Mock(ShortLinkService)

    @Unroll
    void "test create valid shortLink"() {
        given:
        controller.shortLinkService = shortLinkService
        params.targetUrl = targetUrl

        when:
        controller.createShortLink()

        then:
        invocationsToShortLinkService * shortLinkService.getOrCreateShortLink(targetUrl) >> [
                new ShortLink(targetUrl: targetUrl, link: 'http://clientdomain.es/aaaaa')
        ]
        if (invocationsToShortLinkService)
            view.endsWith(landingURL)
        else
            response.redirectedUrl == landingURL

        where:
        targetUrl          | invocationsToShortLinkService | landingURL
        'http://osoco.es/' | 1                             | "/shortLink/index"
        null               | 0                             | "/"
    }

    @Unroll
    void "test redirect to target Url"() {
        given:
        new ShortLink(targetUrl: 'http://osoco.es/', link: 'http://clientdomain.es/AAAAA').save(failOnError: true)
        params.shortUrl = shortUrl

        when:
        controller.redirectToTargetUrl()

        then:
        response.redirectedUrl == redirectUrl

        where:
        shortUrl | redirectUrl
        'AAAAA'  | 'http://osoco.es/'
        'BBBBB'  | '/'

    }


}
