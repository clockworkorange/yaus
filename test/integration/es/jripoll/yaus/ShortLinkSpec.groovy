package es.jripoll.yaus

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll


class ShortLinkSpec extends IntegrationSpec {

    @Unroll
    void "test SortLink domain class validation"() {
        given:
        new ShortLink(
                targetUrl: 'https://github.com/osoco/extra-codenarc-rules',
                link: 'aaaaa').save(failOnError: true)

        def shortLinkToTest = new ShortLink(targetUrl: targetUrl, link: link)
        shortLinkToTest.validate()

        expect:
        shortLinkToTest.hasErrors()
        shortLinkToTest.errors.getFieldError("${fieldError}").code == errorCode

        where:
        targetUrl                                            | link      | fieldError  | errorCode
        'https://github.com/osoco/grails-android-gcm-plugin' | 'aaaaa'   | 'link'      | 'unique'
        'not-url'                                            | 'bbbbb'   | 'targetUrl' | 'url.invalid'
        "http://toLongUrl.com/${'a' * 2000}"                 | 'bbbbb'   | 'targetUrl' | 'maxSize.exceeded'

    }
}