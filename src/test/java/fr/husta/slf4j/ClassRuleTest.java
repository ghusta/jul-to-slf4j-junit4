package fr.husta.slf4j;

import org.junit.ClassRule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.bridge.SLF4JBridgeHandler;

import static org.junit.Assert.assertTrue;

public class ClassRuleTest {

    private static final Logger log = LoggerFactory.getLogger(ClassRuleTest.class);

    @ClassRule
    public static SLF4JBridgeHandlerInitializer slf4JBridgeHandlerInitializer = new SLF4JBridgeHandlerInitializer();

    @Test
    public void nothingToDo() {
        assertTrue(SLF4JBridgeHandler.isInstalled());
        System.out.println("Hello !");
        log.info("Hello (SLF4J)");
    }

}
