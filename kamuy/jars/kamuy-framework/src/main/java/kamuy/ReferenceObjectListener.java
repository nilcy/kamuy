// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
/**
 * Reference object listener.
 * @author nilcy
 */
@SuppressWarnings("static-method")
public class ReferenceObjectListener {
    /** LOG. */
    @Inject
    private Logger log;
    /** Constructor. */
    public ReferenceObjectListener() {
        super();
    }
    /**
     * Post-process for persist and update.
     * @param aEntity entity
     */
    @PostPersist
    @PostUpdate
    public void postSave(final Object aEntity) {
        if (aEntity instanceof ReferenceObject) {
            final ReferenceObject<?> referenceObject = (ReferenceObject<?>) aEntity;
            setPersistedOn(referenceObject);
            this.log.info("POST-SAVED! -> " + referenceObject);
        }
    }
    /**
     * Post-process for load.
     * TODO why not called. BUT persisted fields sets true. WHY?
     * @param aEntity entity
     */
    @PostLoad
    public void postLoad(final Object aEntity) {
        if (aEntity instanceof ReferenceObject) {
            final ReferenceObject<?> referenceObject = (ReferenceObject<?>) aEntity;
            setPersistedOn(referenceObject);
            this.log.info("POST-LOADED! -> " + referenceObject);
        }
    }
    /**
     * Post-process for remove.
     * @param aEntity entity
     */
    @PostRemove
    public void postRemove(final Object aEntity) {
        if (aEntity instanceof ReferenceObject) {
            final ReferenceObject<?> referenceObject = (ReferenceObject<?>) aEntity;
            setPersistedOn(referenceObject);
            this.log.info("POST-REMOVED! -> " + referenceObject);
        }
    }
    /**
     * Set persisted on.
     * @param aReferenceObject reference object
     */
    private void setPersistedOn(final ReferenceObject<?> aReferenceObject) {
        aReferenceObject.setPersisted(true);
    }
}
