// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import org.apache.commons.lang3.builder.HashCodeBuilder;
/**
 * Reference object.
 * @param <T> Reference object type
 * @author nilcy
 */
@MappedSuperclass
@EntityListeners(ReferenceObjectListener.class)
public abstract class AbstractReferenceObject<T extends AbstractReferenceObject<T>> extends
    AbstractSerializableObject<T> implements ReferenceObject<T> {
    /** S/N. */
    private static final long serialVersionUID = 771905993499015976L;
    /** ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /** Keyword. */
    @Transient
    private String keyword;
    /** persisted. */
    @Transient
    private boolean persisted;
    /** Constructor. */
    public AbstractReferenceObject() {
        super();
    }
    @Override
    public Long getId() {
        return this.id;
    }
    @Override
    public void setId(final Long aId) {
        this.id = aId;
    }
    @Override
    public String getKeyword() {
        return this.keyword;
    }
    @Override
    public void setKeyword(final String aKeyword) {
        this.keyword = aKeyword;
    }
    @Override
    public boolean isPersisted() {
        return this.persisted;
    }
    @Override
    public void setPersisted(final boolean aPersisted) {
        this.persisted = aPersisted;
    }
    /**
     * {@inheritDoc} based on ID.
     * @param aThat {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object aThat) {
        if (this == aThat) {
            return true;
        } else if ((aThat == null) || (!(aThat instanceof AbstractReferenceObject))) {
            return false;
        }
        return this.getId().equals(((AbstractReferenceObject<?>) aThat).getId());
    }
    /**
     * {@inheritDoc} based on ID.
     * @return {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        if (this.getId() == null) {
            return HashCodeBuilder.reflectionHashCode(this);
        }
        return HashCodeBuilder.reflectionHashCode(this.getId());
    }
}
