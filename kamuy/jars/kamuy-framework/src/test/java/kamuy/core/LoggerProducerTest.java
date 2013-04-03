// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.core;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
/**
 * {@link LoggerProducer}
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class LoggerProducerTest {
    @Inject
    private Logger testee;
    @Test
    public void test() {
        assertThat(this.testee, is(not(nullValue())));
        this.testee.finest("finest message");
        this.testee.finer("finer message");
        this.testee.fine("fine message");
        this.testee.config("config message");
        this.testee.info("info message");
        this.testee.warning("warning message");
        this.testee.severe("severe message");
    }
}
