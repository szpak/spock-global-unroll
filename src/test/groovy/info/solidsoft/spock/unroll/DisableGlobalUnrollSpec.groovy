/**
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.spock.unroll

import org.junit.runner.Result

class DisableGlobalUnrollSpec extends BaseGlobalUnrollEmbeddedSpecification {

    def "should not unroll parametrized test when @DisableGlobalUnroll is used"() {
        given:
            runner.addClassImport(DisableGlobalUnroll)
        when:
            Result result = runner.runWithImports """
@DisableGlobalUnroll
class ParametrizedSpec extends Specification {
    $PARAMETRIZED_TEST
}
"""
        then:
            result.runCount == 1
    }

    def "should honor explicit @Unroll for test when @DisableGlobalUnroll is used"() {
        given:
            runner.addClassImport(DisableGlobalUnroll)
        when:
            Result result = runner.runWithImports """
@DisableGlobalUnroll
class ParametrizedSpec extends Specification {
    $PARAMETRIZED_TEST
    @Unroll
    $PARAMETRIZED_TEST2
}
"""
        then:
            result.runCount == 1 + 2
    }

}
