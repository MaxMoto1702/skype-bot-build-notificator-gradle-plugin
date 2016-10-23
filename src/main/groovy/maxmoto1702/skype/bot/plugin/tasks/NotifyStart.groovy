package maxmoto1702.skype.bot.plugin.tasks

import maxmoto1702.skype.bot.plugin.utils.BotUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class NotifyStart extends DefaultTask {
    @TaskAction
    def sendNotification() {
        BotUtils.invokeInit()
        def pauses
        while (pauses = BotUtils.listPauses()) {
            pauses.each { pause ->
                println "User '${pause.user.name}' requested pause: ${pause.duration} seconds. Wait ${pause.expires - System.currentTimeSeconds()} seconds..."
                sleep((pause.expires - System.currentTimeSeconds()) * 1_000)
            }
        }
        BotUtils.invokeStart()
    }
}
