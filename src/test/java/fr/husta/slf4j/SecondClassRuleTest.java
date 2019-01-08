package fr.husta.slf4j;

import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.bridge.SLF4JBridgeHandler;

import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

public class SecondClassRuleTest {

    private static final Logger log = Logger.getLogger(SecondClassRuleTest.class.getName());

    @ClassRule
    public static SLF4JBridgeHandlerInitializer slf4JBridgeHandlerInitializer = SLF4JBridgeHandlerInitializer.INSTANCE;

    @Test
    public void nothingToDo() {
        assertTrue(SLF4JBridgeHandler.isInstalled());
        System.out.println("Hello !");
        log.info("Hello (JUL)");
    }

}
