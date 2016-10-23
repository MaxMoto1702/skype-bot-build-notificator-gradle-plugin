package maxmoto1702.skype.actions

import maxmoto1702.skype.SkypePlugin
import maxmoto1702.skype.tasks.NotifyFinish
import org.gradle.api.Action

class NotifyFinishAction implements Action<NotifyFinish> {
    @Override
    void execute(NotifyFinish task) {
        task.description = "Send finish notification to Skype"
        task.group = SkypePlugin.SKYPE_GROUP
        task.impliesSubProjects = true
    }
}
