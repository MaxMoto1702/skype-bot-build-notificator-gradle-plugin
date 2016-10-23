package maxmoto1702.skype.bot.plugin

import maxmoto1702.skype.bot.plugin.tasks.NotifyFinish
import maxmoto1702.skype.bot.plugin.tasks.NotifyStart
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

class SkypePluginTest {
    @Test
    public void skypePluginAddsNotifyTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'maxmoto1702.skype'

        project.skype {
            recipient = [
                    id  : 'test-id',
                    name: 'test-name'
            ]
        }

        assertTrue(project.tasks.notifyAboutStart instanceof NotifyStart)
        assertTrue(project.tasks.notifyAboutFinish instanceof NotifyFinish)
    }
}
