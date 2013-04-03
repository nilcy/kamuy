// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
/**
 * Logger Test.
 * @author nilcy
 */
@SuppressWarnings("all")
public class LoggerTest {
    private static Logger logger = Logger.getGlobal();
    @Test
    public void test() {
        Logger.getGlobal().setLevel(Level.INFO);
        System.out.println(logger.getLevel());
        logger.finest("finest message");
        logger.finer("finer message");
        logger.fine("fine message");
        logger.config("config message");
        logger.info("info message");
        logger.warning("warning message");
        logger.severe("severe message");
    }
}
