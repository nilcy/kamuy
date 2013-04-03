// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
import java.io.Serializable;
/**
 * Serializable object I/F.
 * @param <T> Serializable object type
 * @author nilcy
 */
public interface SerializableObject<T extends SerializableObject<T>> extends DataObject<T>,
    Serializable {
}
