package maxmoto1702.skype.bot.plugin

import maxmoto1702.skype.bot.plugin.actions.NotifyFinishAction
import maxmoto1702.skype.bot.plugin.actions.NotifyStartAction
import maxmoto1702.skype.bot.plugin.extensions.SkypePluginExtension
import maxmoto1702.skype.bot.plugin.tasks.NotifyFinish
import maxmoto1702.skype.bot.plugin.tasks.NotifyStart
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