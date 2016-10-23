package maxmoto1702.skype.bot.plugin.tasks

import maxmoto1702.skype.bot.plugin.utils.BotUtils
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class NotifyFinish extends DefaultTask {
    @TaskAction
    def sendNotification() {
        def bot = new BotUtils()
        bot.invokeFinish()
    }
}
