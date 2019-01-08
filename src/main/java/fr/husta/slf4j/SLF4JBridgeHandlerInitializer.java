package fr.husta.slf4j;

import fr.husta.slf4j.utils.SLF4JBridgeHandlerUtils;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * Class-level {@link TestRule}.
 */
public class SLF4JBridgeHandlerInitializer
        implements TestRule {

    /**
     * Singleton instance.
     */
    public static SLF4JBridgeHandlerInitializer INSTANCE = new SLF4JBridgeHandlerInitializer();

    @Override
    public Statement apply(Statement base, Description description) {
        return statement(base);
    }

    private Statement statement(final Statement base) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                before();
                try {
                    base.evaluate();
                } finally {
                    after();
                }
            }
        };
    }

    private void before() {
        initSLF4JBridgeHandler();
    }

    private void after() {
        // do nothing
    }

    private static void initSLF4JBridgeHandler() {
        SLF4JBridgeHandlerUtils.initSLF4JBridgeHandler();
    }

}
