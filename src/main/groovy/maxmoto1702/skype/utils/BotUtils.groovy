package maxmoto1702.skype.utils

class BotUtils {
    private final static INIT_ENDPOINT = '/api/deploy/init'
    private final static START_ENDPOINT = '/api/deploy/start'
    private final static FINISH_ENDPOINT = '/api/deploy/finish'
    private final static WAITINGS_ENDPOINT = '/api/pauses'

    static existsPauses = false

    def invokeInit(message = null) {
        println 'NotifyStart deploy'
    }

    def invokeStart(message = null) {
        println 'Start deploy'
    }

    def invokeFinish(message = null) {
        println 'Finish deploy'
    }

    def listPauses() {
        println 'Get pauses'
        if (existsPauses) return []
        existsPauses = true
        [
                [
                        id      : 1,
                        start   : System.currentTimeSeconds() - 5,
                        expires : System.currentTimeSeconds() + 5,
                        duration: 10,
                        user    : [
                                id  : 'test-user-1',
                                name: 'Test User #1'
                        ]
                ], [
                        id      : 1,
                        start   : System.currentTimeSeconds() - 5,
                        expires : System.currentTimeSeconds() + 10,
                        duration: 15,
                        user    : [
                                id  : 'test-user-2',
                                name: 'Test User #2'
                        ]
                ]
        ]
    }
}
