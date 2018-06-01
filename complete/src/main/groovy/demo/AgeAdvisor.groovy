// tag:ageAdvisorBegin[]
package demo

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

@Slf4j // <1>
@CompileStatic
class AgeAdvisor {

    void offerAgeAdvice(Integer age) {
        if (0 < age && age < 30 ) {
            log.info ("You are a young and vibrant!") // <2>
            log.info ("Live life to the fullest.")
        } else if (30 <= age) {
            log.warn ("It's all downhill from here, sorry.")
        }
    }
}
// end:ageAdvisorBegin[]
