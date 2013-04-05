// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.domain;
import java.io.Serializable;
/**
 * Base class for persistence controller objects.
 * @param <T> the persistence context class
 * @author nilcy
 */
public abstract class AbstractController<T> implements Serializable {
    /** S/N. */
    private static final long serialVersionUID = -2773660556216624186L;
    /** Constructor. */
    public AbstractController() {
        super();
    }
}
