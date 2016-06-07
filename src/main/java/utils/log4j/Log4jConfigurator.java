package utils.log4j;

import org.apache.log4j.xml.DOMConfigurator;

public class Log4jConfigurator {
    static {
        init();
    }

    private static void init() {
        DOMConfigurator.configure("src/Main/resources/log4j.xml");
    }
}
