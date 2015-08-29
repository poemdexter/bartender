package bartender.service.impl

import bartender.service.M2XService
import groovyx.net.http.HTTPBuilder
import net.sf.json.groovy.JsonSlurper
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository

import static groovyx.net.http.ContentType.TEXT

@Repository
class M2XServiceImpl implements M2XService {

    @Value('${m2x.masterkey}')
    String masterKey

    @Value('${m2x.device.id}')
    String deviceId

    def baseUrl = 'http://api-m2x.att.com/v2'

    Double getLatestTemperature() {
        def url = "${baseUrl}/devices/${deviceId}/streams/temperature"
        def client = new HTTPBuilder(url)
        client.setHeaders([Accept: 'application/json', 'X-M2X-KEY': masterKey])
        def response = new JsonSlurper().parse(client.get(contentType: TEXT))

        response['value'] as Double
    }
}