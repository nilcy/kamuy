// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
/**
 * Serializable object.
 * @param <T> Serializable object type
 * @author nilcy
 */
public abstract class AbstractSerializableObject<T extends AbstractSerializableObject<T>> extends
    AbstractDataObject<T> implements SerializableObject<T> {
    /** S/N. */
    private static final long serialVersionUID = 7296934510051714094L;
    /**
     * Constructor.
     */
    public AbstractSerializableObject() {
        super();
    }
}
