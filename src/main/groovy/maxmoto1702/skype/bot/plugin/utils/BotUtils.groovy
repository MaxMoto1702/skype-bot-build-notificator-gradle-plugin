package maxmoto1702.skype.bot.plugin.utils

import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.StringEntity
import org.apache.http.impl.client.HttpClients

class BotUtils {
    private final static URL = 'https://serebryanskiy.site/skype-bot/'
    private final static INIT_ENDPOINT = 'api/deploy/init'
    private final static START_ENDPOINT = 'api/deploy/start'
    private final static FINISH_ENDPOINT = 'api/deploy/finish'
    private final static PAUSES_ENDPOINT = 'api/pauses'

    static def invokeInit() {
        HttpClients.createDefault()
                .execute(new HttpPost("$URL$INIT_ENDPOINT"))
    }

    static def invokeStart() {
        HttpClients.createDefault()
                .execute(new HttpPost("$URL$START_ENDPOINT"))
    }

    static def invokeFinish(params = null) {
        HttpClients.createDefault()
                .execute(new HttpPost(URI: "$URL$FINISH_ENDPOINT".toURI(), entity: new StringEntity(JsonOutput.toJson([revision: params?.revision, commits: params?.commits]))))
    }

    static def listPauses() {
        new JsonSlurper().parseText(new URL("$URL$PAUSES_ENDPOINT").text)
    }
}
