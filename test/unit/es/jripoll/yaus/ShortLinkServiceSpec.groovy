package es.jripoll.yaus

import grails.plugin.spock.UnitSpec
import grails.test.mixin.Mock
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication
import spock.lang.Unroll

@Mock(ShortLink)
class ShortLinkServiceSpec extends UnitSpec {

    def shortLinkService

    def setup() {
        shortLinkService = new ShortLinkService()
        shortLinkService.grailsApplication = new DefaultGrailsApplication()
    }

    @Unroll
    void "test convert number to base62"() {
        expect:
        shortLinkService.convertNumberToBase62(number) == charResult

        where:
        number    | charResult
        0         | 'a'
        61        | '9'
        62        | 'ba'
        63        | 'bb'
        3843      | '99'
        3844      | 'baa'
        3845      | 'bab'
        238327    | '999'
        238328    | 'baaa'
        238329    | 'baab'
        14776335  | '9999'
        14776336  | 'baaaa'
        14776337  | 'baaab'
        916132831 | '99999'
    }

    @Unroll
    void "test generate ShortLink"() {
        given:
        shortLinkService.metaClass.convertNumberToBase62 = { number -> convertedNumber }

        expect:
        shortLinkService.generateShortLink() == code

        where:
        convertedNumber | code
        'b'             | 'aaaab'
        '22'            | 'aaa22'
        'abcde'         | 'abcde'
    }

    @Unroll
    void "test get or create short link"() {
        given:
        new ShortLink(targetUrl: 'http://osoco.es/', link: 'http://osoco.es/AAAAA').save(failOnError: true)
        shortLinkService.metaClass.generateShortLink = { shortCode }
        def shortLink = shortLinkService.getOrCreateShortLink(targetUrl)

        expect:
        shortLink.targetUrl == targetUrlResult
        shortLink.link == linkresult
        shortLink.id == id
        shortLink.hasErrors() == hasErrors

        where:
        targetUrl                       | shortCode | targetUrlResult                 | linkresult                     | id   | hasErrors
        'http://osoco.es/somos'         | 'BBBBB'   | 'http://osoco.es/somos'         | 'http://clientdomain.es/BBBBB' | 2    | false
        'http://osoco.es/'              | 'BBBBB'   | 'http://osoco.es/'              | 'http://osoco.es/AAAAA'        | 1    | false
        'not-url'                       | 'CCCCC'   | 'not-url'                       | 'http://clientdomain.es/CCCCC' | null | true
        "http://osoco.es/${'a' * 2000}" | 'DDDDD'   | "http://osoco.es/${'a' * 2000}" | 'http://clientdomain.es/DDDDD' | null | true
    }
}
