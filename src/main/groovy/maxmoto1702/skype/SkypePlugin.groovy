package maxmoto1702.skype

import maxmoto1702.skype.actions.NotifyFinishAction
import maxmoto1702.skype.actions.NotifyStartAction
import maxmoto1702.skype.extensions.SkypePluginExtension
import maxmoto1702.skype.tasks.NotifyFinish
import maxmoto1702.skype.tasks.NotifyStart
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.internal.tasks.TaskContainerInternal

class SkypePlugin implements Plugin<Project> {
    public final static SKYPE_GROUP = 'Skype'

    void apply(Project project) {
        project.extensions.create("skype", SkypePluginExtension)
        TaskContainerInternal tasks = project.tasks;
        tasks.addPlaceholderAction("notifyAboutStart", NotifyStart, new NotifyStartAction());
        tasks.addPlaceholderAction("notifyAboutFinish", NotifyFinish, new NotifyFinishAction());
    }
}