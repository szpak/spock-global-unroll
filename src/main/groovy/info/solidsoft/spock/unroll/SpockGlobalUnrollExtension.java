package info.solidsoft.spock.unroll;

import org.spockframework.runtime.extension.AbstractGlobalExtension;
import org.spockframework.runtime.extension.builtin.UnrollExtension;
import org.spockframework.runtime.model.SpecInfo;
import spock.lang.Unroll;

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
