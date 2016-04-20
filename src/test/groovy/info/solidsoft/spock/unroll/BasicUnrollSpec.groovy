package info.solidsoft.spock.unroll

import org.junit.runner.Result

class BasicUnrollSpec extends BaseGlobalUnrollEmbeddedSpecification {

    def "should unroll parametrized test (without annotation)"() {
        when:
            Result result = runner.runSpecBody """
$PARAMETRIZED_TEST
"""
        then:
            result.runCount == 2
    }

    def "should expand test description parametrized test (without annotation)"() {
        when:
            runner.runSpecBody """
$PARAMETRIZED_TEST
"""
        then:
            1 * listener.testFinished { it.methodName == "parametrized test 1"}
            1 * listener.testFinished { it.methodName == "parametrized test 2"}
    }

    def "should unroll parametrized test with @Unroll annotation"() {
        when:
            Result result = runner.runSpecBody """
@Unroll
$PARAMETRIZED_TEST
"""
        then:
            result.runCount == 2
    }

    def "should unroll parametrized test with @Unroll at specification level"() {
        when:
            Result result = runner.runWithImports """
@Unroll
class ParametrizedSpec extends Specification {
    $PARAMETRIZED_TEST
}
"""
        then:
            result.runCount == 2
    }

    def "should unroll all parametrized tests"() {
        when:
            Result result = runner.runWithImports """
class ParametrizedSpec extends Specification {
    $PARAMETRIZED_TEST
    $PARAMETRIZED_TEST2
}
"""
        then:
            result.runCount == 4
    }

    def "should not fail on not parametrized tests"() {
        when:
            Result result = runner.runSpecBody """
$NOT_PARAMETRIZED_TEST
"""
        then:
            result.runCount == 1
    }
}
