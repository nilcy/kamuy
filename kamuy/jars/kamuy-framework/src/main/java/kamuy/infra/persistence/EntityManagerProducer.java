// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra.persistence;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
/**
 * Entity manager producer.
 * @author nilcy
 */
public final class EntityManagerProducer {
    /** primary repository. */
    @Produces
    @PrimaryEntityManager
    @PersistenceContext(unitName = "primary")
    private EntityManager primaryEntityManager;
    /** Constructor. */
    public EntityManagerProducer() {
        super();
    }
}
