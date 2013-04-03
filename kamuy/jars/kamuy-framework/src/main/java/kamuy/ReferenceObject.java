// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
/**
 * Reference Object I/F.
 * @param <T> Reference Object Type
 * @author nilcy
 */
public interface ReferenceObject<T extends ReferenceObject<T>> extends SerializableObject<T> {
    /**
     * Get ID.
     * @return ID
     */
    Long getId();
    /**
     * Set ID.
     * @param aId ID
     */
    void setId(Long aId);
    /**
     * Get persisted.
     * @return persisted
     */
    boolean isPersisted();
    /**
     * Set persisted.
     * @param persisted persisted
     */
    void setPersisted(final boolean persisted);
}
