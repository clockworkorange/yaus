package es.jripoll.yaus

import groovy.transform.EqualsAndHashCode

/**
 * @author julio@ripollmoreno.com
 */
@EqualsAndHashCode
class ShortLink {

    String targetUrl
    String link
    Date dateCreated

    static constraints = {
        targetUrl maxSize: 2000, url: true
        link unique: true
    }

    String toString() {
        "id: $id - targetUrl: $targetUrl - shortLink: $link"
    }
}