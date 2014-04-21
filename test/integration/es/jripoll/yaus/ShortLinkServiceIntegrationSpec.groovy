package es.jripoll.yaus

import grails.test.spock.IntegrationSpec


class ShortLinkServiceIntegrationSpec extends IntegrationSpec {

    def shortLinkService

    void "test get shortLink max id criteria"() {
        given:
        def lastShortLink
        5.times {
            lastShortLink = new ShortLink(targetUrl: "http://osoco.es/${it}", link: "aaaa${it}").save(failOnError: true)
        }

        expect:
        shortLinkService.getShortLinkMaxId() == lastShortLink.id
    }

}
