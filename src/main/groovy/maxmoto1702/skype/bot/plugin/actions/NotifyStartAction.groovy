package maxmoto1702.skype.bot.plugin.actions

import maxmoto1702.skype.bot.plugin.SkypePlugin
import maxmoto1702.skype.bot.plugin.tasks.NotifyStart
import org.gradle.api.Action

class NotifyStartAction implements Action<NotifyStart> {
    @Override
    void execute(NotifyStart task) {
        task.description = "Send init and start notification to Skype and wait pause requests"
        task.group = SkypePlugin.SKYPE_GROUP
        task.impliesSubProjects = true
    }
}
