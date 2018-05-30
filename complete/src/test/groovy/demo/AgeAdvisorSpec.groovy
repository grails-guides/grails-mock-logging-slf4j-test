package demo

import com.google.common.collect.ImmutableList
import spock.lang.Shared
import spock.lang.Specification
import uk.org.lidalia.slf4jext.Level
import uk.org.lidalia.slf4jtest.LoggingEvent
import uk.org.lidalia.slf4jtest.TestLogger
import uk.org.lidalia.slf4jtest.TestLoggerFactory

class AgeAdvisorSpec extends Specification {

    @Shared
    AgeAdvisor ageAdvisor = new AgeAdvisor()

    def cleanup() {
        TestLoggerFactory.clear()
    }

    void "verify young age logs"() {
        when:
        TestLogger logger = TestLoggerFactory.getTestLogger("demo.AgeAdvisor")

        ageAdvisor.offerAgeAdvice(15)

        ImmutableList<LoggingEvent> loggingEvents = logger.getLoggingEvents()

        then:
        loggingEvents.size() == 2
        loggingEvents[0].message == "You are a young and vibrant!"
        loggingEvents[0].level == Level.INFO
        loggingEvents[1].message == "Live life to the fullest."
        loggingEvents[1].level == Level.INFO
    }

    void "verify old age logs"() {
        when:
        TestLogger logger = TestLoggerFactory.getTestLogger("demo.AgeAdvisor")

        ageAdvisor.offerAgeAdvice(31)

        ImmutableList<LoggingEvent> loggingEvents = logger.getLoggingEvents()

        then:
        loggingEvents.size() == 1
        loggingEvents[0].message == "It's all downhill from here, sorry."
        loggingEvents[0].level == Level.WARN
    }
}
