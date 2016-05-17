/**
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.spock.unroll;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Disables global parametrized tests unrolling provided by {@link SpockGlobalUnrollExtension} for a particular class.
 * <p>
 * The annotation can be only put at the class (specification) level.
 * <p>
 * Please note that the @{@link spock.lang.Unroll Unroll} annotations manually placed at the test (feature) level can be used
 * to unroll particular tests anyway.
 *
 * @author Marcin Zajączkowski
 * @since 0.5.1
 *
 * @see SpockGlobalUnrollExtension
 * @see DisableGlobalUnroll
 * @see spock.lang.Unroll Unroll
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface Roll {
}
