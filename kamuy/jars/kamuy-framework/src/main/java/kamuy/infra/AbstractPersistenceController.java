// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra;
import java.io.Serializable;
/**
 * Base class for controller objects which require a persistence context object.
 * @param <T> persistence context class
 * @author nilcy
 */
public abstract class AbstractPersistenceController<T> implements Serializable {
    /** S/N. */
    private static final long serialVersionUID = 750084317756410372L;
    /** Persistence context. */
    private T persistenceContext;
    /** Constructor. */
    public AbstractPersistenceController() {
        super();
    }
    /**
     * Get {@link #persistenceContext}.
     * @return {@link #persistenceContext}
     */
    public T getPersistenceContext() {
        return this.persistenceContext;
    }
    /**
     * Set {@link #persistenceContext}.
     * @param aPersitenceContext {@link #persistenceContext}
     */
    public void setPersistenceContext(final T aPersitenceContext) {
        this.persistenceContext = aPersitenceContext;
    }
    /**
     * Get persistence context name.
     * @return persistence context name
     */
    protected abstract String getPersitenceContextName();
}
