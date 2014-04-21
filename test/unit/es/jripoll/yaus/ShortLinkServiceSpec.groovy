package es.jripoll.yaus

import grails.plugin.spock.UnitSpec
import org.codehaus.groovy.grails.commons.DefaultGrailsApplication
import spock.lang.Unroll


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
        number  |   charResult
        0       |   'a'
        61      |   '9'
        62      |   'ba'
        63      |   'bb'
        3843    |   '99'
        3844    |   'baa'
        3845    |   'bab'
    }


}
