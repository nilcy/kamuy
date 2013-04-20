// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Data object.
 * @param <T> Data object type
 * @author nilcy
 */
public abstract class AbstractDataObject<T extends AbstractDataObject<T>> implements DataObject<T> {
    /** Constructor. */
    public AbstractDataObject() {
        super();
    }
    /**
     * See {@link EqualsBuilder#reflectionEquals(Object, Object, boolean)}.
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object aThat) {
        return EqualsBuilder.reflectionEquals(this, aThat, false);
    }
    /**
     * See {@link HashCodeBuilder#reflectionHashCode(Object, boolean)}.
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }
    /**
     * See
     * {@link ToStringBuilder#reflectionToString(Object, ToStringStyle, boolean)}
     * . {@inheritDoc}
     */
    @Override
    public final String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, true);
    }
}
