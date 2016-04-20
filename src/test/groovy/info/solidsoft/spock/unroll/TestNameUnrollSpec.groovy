package info.solidsoft.spock.unroll

class TestNameUnrollSpec extends BaseGlobalUnrollEmbeddedSpecification {

    def "should expand test name for parametrized test (without annotation)"() {
        when:
            runner.runSpecBody """
$PARAMETRIZED_TEST
"""
        then:
            1 * listener.testFinished { it.methodName == "parametrized test 1"}
            1 * listener.testFinished { it.methodName == "parametrized test 2"}
    }

    def "should honor test name in @Unroll for parametrized test"() {
        when:
            runner.runSpecBody """
@Unroll('Unroll #number')
$PARAMETRIZED_TEST
"""
        then:
            1 * listener.testFinished { it.methodName == "Unroll 1"}
            1 * listener.testFinished { it.methodName == "Unroll 2"}
    }

    def "should honor test name in @Unroll (at specification level) for description parametrized test"() {
        when:
            runner.runWithImports """
@Unroll('Unroll #number')
class ParametrizedSpec extends Specification {
    $PARAMETRIZED_TEST
}
"""
        then:
            1 * listener.testFinished { it.methodName == "Unroll 1"}
            1 * listener.testFinished { it.methodName == "Unroll 2"}
    }

    def "should use standard name for parametrized test without name placeholder"() {
        when:
            runner.runSpecBody """
@Unroll
def "parametrized test without placeholder"() {
    expect:
        true
    where:
        number << [1, 2]
}
"""
        then:
            interaction {
                def count = 0
                2 * listener.testFinished { it.methodName == "parametrized test without placeholder[${count++}]"}
            }
    }
}
