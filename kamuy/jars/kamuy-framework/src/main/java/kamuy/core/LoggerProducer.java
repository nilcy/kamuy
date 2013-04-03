// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.core;
import java.util.logging.Logger;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
/**
 * Logger producer.
 * @author nilcy
 */
public class LoggerProducer {
    /** Constructor. */
    public LoggerProducer() {
        super();
    }
    /**
     * Create Logger.
     * @param aInjectionPoint injection point
     * @return Logger
     */
    @SuppressWarnings("static-method")
    @Produces
    @Default
    public Logger createLogger(final InjectionPoint aInjectionPoint) {
        return Logger.getLogger(aInjectionPoint.getMember().getDeclaringClass().getName());
    }
}
