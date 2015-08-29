package bartender.service.impl

import bartender.service.BreweryService
import groovyx.net.http.HTTPBuilder
import net.sf.json.groovy.JsonSlurper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

import static groovyx.net.http.ContentType.TEXT

@Repository
class BreweryServiceImpl implements BreweryService {

    @Value('${brewery.apikey')
    String apiKey

    def baseUrl = 'http://api.brewerydb.com/v2/'

    String[] getListOfBeers()
    {
        def url = "${baseUrl}/SOME/ENDPOINT/HERE${getKeyQueryParam()}"
        def client = new HTTPBuilder(url)
        client.setHeaders(Accept: 'application/json')
        def response = new JsonSlurper().parse(client.get(contentType: TEXT))

        response['value'] as String[]
    }

    String getKeyQueryParam() {
        "?key=${apiKey}"
    }
}
