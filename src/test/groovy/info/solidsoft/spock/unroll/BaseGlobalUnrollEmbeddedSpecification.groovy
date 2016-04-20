/**
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.spock.unroll

import org.junit.runner.notification.RunListener

abstract class BaseGlobalUnrollEmbeddedSpecification extends EmbeddedSpecification {

    protected static final PARAMETRIZED_TEST = """
def "parametrized test #number"() {
    expect:
        true
    where:
        number << [1, 2]
}
"""
    protected static final PARAMETRIZED_TEST2 = PARAMETRIZED_TEST.replace('test', 'test2')

    protected static final NOT_PARAMETRIZED_TEST = """
def "not parametrized test"() {
    expect:
        true
}
"""

    protected RunListener listener = Mock()

    void setup() {
        runner.listeners << listener
    }
}
