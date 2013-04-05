// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra.persistence;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import kamuy.infra.AbstractPersistenceController;
/**
 * Base class for controller objects that perform persistence operations using
 * JPA.
 * @author nilcy
 */
public class EntityController extends AbstractPersistenceController<EntityManager> {
    /** S/N. */
    private static final long serialVersionUID = -3437897138954923066L;
    /** Constructor. */
    public EntityController() {
        super();
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
    protected Query createNamedQuery(final String aQueryName) {
        return getEntityManager().createNamedQuery(aQueryName);
    }
    /**
     * Create query.
     * @param aJPQL JPQL
     * @return query
     */
    protected Query createQuery(final String aJPQL) {
        return getEntityManager().createQuery(aJPQL);
    }
    /**
     * Find by PK.
     * @param <T> entity class
     * @param aClass entity class
     * @param aPK primary key
     * @return entity
     */
    protected <T> T find(final Class<T> aClass, final Object aPK) {
        return getEntityManager().find(aClass, aPK);
    }
    /**
     * Flush.
     */
    protected void flush() {
        getEntityManager().flush();
    }
    /**
     * Get reference.
     * @param <T> entity class
     * @param aClass entity class
     * @param aPK primary key
     * @return entity
     */
    protected <T> T getReference(final Class<T> aClass, final Object aPK) {
        return getEntityManager().getReference(aClass, aPK);
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
     * @param <T> entity class
     * @param aEntity entity
     * @return entity
     */
    protected <T> T persist(final T aEntity) {
        getEntityManager().persist(aEntity);
        return aEntity;
    }
    /**
     * Merge entity.
     * @param <T> entity class
     * @param aEntity entity
     * @return entity
     */
    protected <T> T merge(final T aEntity) {
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
