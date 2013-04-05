// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra.persistence;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import kamuy.infra.AbstractPersistenceController;
/**
 * Base class for controller objects that perform persistence operations using
 * JPA.
 * @param <T> entity class
 * @author nilcy
 */
public class TypedEntityController<T> extends AbstractPersistenceController<EntityManager> {
    /** S/N. */
    private static final long serialVersionUID = -3483047020915851068L;
    /** Entity class. */
    private final Class<T> clazz;
    /**
     * Constructor.
     * @param aClass entity class
     */
    public TypedEntityController(final Class<T> aClass) {
        super();
        this.clazz = aClass;
    }
    /**
     * Get entity manager.
     * @return entity manager
     */
    public EntityManager getEntityManager() {
        return getPersistenceContext();
    }
    /**
     * Set entity manager.
     * @param aEntityManger entityManager
     */
    public void setEntityManager(final EntityManager aEntityManger) {
        setPersistenceContext(aEntityManger);
    }
    /** {@inheritDoc} */
    @Override
    protected String getPersitenceContextName() {
        return "entityManager";
    }
    /**
     * Create named query.
     * @param aQueryName query name
     * @return query
     */
    protected TypedQuery<T> createNamedQuery(final String aQueryName) {
        return getEntityManager().createNamedQuery(aQueryName, this.clazz);
    }
    /**
     * Create query.
     * @param aJPQL JPQL
     * @return query
     */
    protected TypedQuery<T> createQuery(final String aJPQL) {
        return getEntityManager().createQuery(aJPQL, this.clazz);
    }
    /**
     * Find by PK.
     * @param aPK primary key
     * @return entity
     */
    protected T find(final Object aPK) {
        return getEntityManager().find(this.clazz, aPK);
    }
    /**
     * Flush.
     */
    protected void flush() {
        getEntityManager().flush();
    }
    /**
     * Get reference.
     * @param aPK primary key
     * @return entity
     */
    protected T getReference(final Object aPK) {
        return getEntityManager().getReference(this.clazz, aPK);
    }
    /**
     * Lock entity.
     * @param aEntity entity
     * @param aLockMode lock mode
     */
    protected void lock(final Object aEntity, final LockModeType aLockMode) {
        getEntityManager().lock(aEntity, aLockMode);
    }
    /**
     * Persist entity.
     * @param aEntity entity
     * @return entity
     */
    protected T persist(final T aEntity) {
        getEntityManager().persist(aEntity);
        return aEntity;
    }
    /**
     * Merge entity.
     * @param aEntity entity
     * @return entity
     */
    protected T merge(final T aEntity) {
        return getEntityManager().merge(aEntity);
    }
    /**
     * Remove entity.
     * @param aEntity entity
     */
    protected void remove(final Object aEntity) {
        getEntityManager().remove(aEntity);
    }
    /**
     * Refresh entity.
     * @param aEntity entity
     */
    protected void refresh(final Object aEntity) {
        getEntityManager().refresh(aEntity);
    }
}
