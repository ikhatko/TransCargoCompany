package utils.log4j;

import org.apache.log4j.xml.DOMConfigurator;

/**
 * The type Log 4 j configurator.
 */
public class Log4jConfigurator {
    static {
        init();
    }

    private static void init() {
        DOMConfigurator.configure("src/Main/resources/log4j.xml");
    }
}
