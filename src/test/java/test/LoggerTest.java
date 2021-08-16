package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LoggerTest {

    Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void loggingLevelsTest() {
        logger.fatal("Уровень - fatal");
        logger.error("Уровень - error");
        logger.warn("Уровень - warn");
        logger.info("Уровень - info");
        logger.debug("Уровень - debug");
        logger.trace("Уровень - trace");
    }
}
