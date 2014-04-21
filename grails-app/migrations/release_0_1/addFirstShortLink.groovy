package release_0_1

databaseChangeLog = {

    changeSet(author: "julio@ripollmoreno.com", id: "1398009886909-3") {
        grailsChange {
            change {
                def today = new Date()
                def firstShortLink = [
                        version: 1,
                        targetUrl: 'http://osoco.es/',
                        link: application.config.shortener.domain + 'aaaa',
                        date: today]

                sql.executeUpdate """insert into short_link (version, target_url, link, date_created) values
                    ($firstShortLink.version, $firstShortLink.targetUrl, $firstShortLink.link, $firstShortLink.date)"""
            }
        }
    }
}