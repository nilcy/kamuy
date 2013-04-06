// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.app;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
/**
 * Watcher application.
 * @author nilcy
 */
@Singleton
@Lock(LockType.READ)
@Startup
public class Watcher {
    /** Logger. */
    @Inject
    private Logger logger;
    /** Constructor. */
    public Watcher() {
        super();
    }
    /** Post constructer. */
    @PostConstruct
    public void postConstruct() {
        this.logger.info("Kamuy is started.");
    }
    /** Post constructer. */
    @PreDestroy
    public void preDestroy() {
        this.logger.info("Kamuy is stopped.");
    }
}
