package fr.husta.slf4j.utils;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Installation of {@link SLF4JBridgeHandler} which will
 * bridge/route all JUL log records to the SLF4J API.
 * <p>
 * See also documentation : <a href="https://www.slf4j.org/legacy.html#jul-to-slf4j">jul-to-slf4j bridge</a>.
 * </p>
 */
public class SLF4JBridgeHandlerUtils {

    private static AtomicBoolean isAlreadyInit = new AtomicBoolean(false);

    public static synchronized void initSLF4JBridgeHandler() {
        if (!isAlreadyInit.get()) {
            // Optionally remove existing handlers attached to j.u.l root logger
            SLF4JBridgeHandler.removeHandlersForRootLogger();  // (since SLF4J 1.6.5)

            // add SLF4JBridgeHandler to j.u.l's root logger, should be done once during
            // the initialization phase of your application
            SLF4JBridgeHandler.install();

            isAlreadyInit.set(true);
        }
    }

}
