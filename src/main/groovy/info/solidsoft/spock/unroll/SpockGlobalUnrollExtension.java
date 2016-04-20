/**
 * Copyright (C) 2016 Marcin Zajączkowski.
 *
 * Licensed under the Apache License, Version 2.0.
 */
package info.solidsoft.spock.unroll;

import org.spockframework.runtime.extension.AbstractGlobalExtension;
import org.spockframework.runtime.extension.builtin.UnrollExtension;
import org.spockframework.runtime.model.SpecInfo;
import spock.lang.Unroll;

/**
 * Spock global extension automatically enabling parametrized tests unrolling in the whole project.
 * <p>
 * All parametrized tests (features) will unrolled automatically as the @{@link Unroll} annotation would be put on it.
 * It is enough to put spock-gradle-unroll on a classpath. No additional configuration is required.
 * <p>
 * To override default test name expanding (with #placeHolders in a test name) @{@link Unroll} annotation with
 * a custom text can used on top of a feature method or at the specification level.
 * <p>
 * To disable unrolling for a particular test class (specification) @{@link DisableGlobalUnroll} can be placed at the class level.
 *
 * @see DisableGlobalUnroll
 * @see Unroll
 *
 * @author Marcin Zajączkowski
 */
public class SpockGlobalUnrollExtension extends AbstractGlobalExtension {

    @Unroll
    private static final class FakeSpecToGetDefaultUnrollAnnotationInstance {}

    private static final Unroll unroll = FakeSpecToGetDefaultUnrollAnnotationInstance.class.getAnnotation(Unroll.class);

    private final UnrollExtension extension;

    public SpockGlobalUnrollExtension() {
        extension = new UnrollExtension();
    }

    @Override
    public void visitSpec(SpecInfo spec) {
        //TODO: Add property to disable it globally in configuration - if requested
        if (spec.getAnnotation(DisableGlobalUnroll.class) == null) {
            extension.visitSpecAnnotation(unroll, spec);
        }
    }
}
