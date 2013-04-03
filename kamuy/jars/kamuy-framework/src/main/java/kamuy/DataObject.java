// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
/**
 * Data object I/F.
 * @param <T> Data object type
 * @author nilcy
 */
public interface DataObject<T extends DataObject<T>> {
    /**
     * Get keyword.
     * @return keyword
     */
    String getKeyword();
    /**
     * Set keyword.
     * @param aKeyword keyword
     */
    void setKeyword(String aKeyword);
}
