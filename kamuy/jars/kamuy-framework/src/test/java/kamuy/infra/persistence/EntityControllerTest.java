// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra.persistence;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import kamuy.domain.actor.Member;
/**
 * Test for {@link EntityController}.
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class EntityControllerTest {
    private final EntityController testee = new EntityController();
    @Inject
    @PrimaryEntityManager
    private EntityManager entityManager;
    @Before
    public void before() {
        this.testee.setEntityManager(this.entityManager);
        this.testee.persist(new Member());
    }
    @Test
    public void testGetPersitenceContextName() {
        assertThat(this.testee.getPersitenceContextName(), is("entityManager"));
    }
    @Test
    public void testEntityController() {
        assertThat(this.testee, is(not(nullValue())));
    }
    @Test
    public void testGetEntityManager() {
        assertThat(this.testee.getEntityManager(), is(not(nullValue())));
        assertThat(this.testee.getEntityManager(), is(this.entityManager));
    }
    @Test
    public void testSetEntityManager() {
        this.testee.setEntityManager(null);
        assertThat(this.testee.getEntityManager(), is(nullValue()));
    }
    @Test
    public void testCreateNamedQuery() {
        final Query q = this.testee.createNamedQuery("findMember");
        assertThat(q, is(not(nullValue())));
        assertThat(q.getResultList().size(), is(1));
    }
    @Test
    public void testCreateQuery() {
        final Query q = this.testee.createQuery("SELECT m FROM Member m");
        assertThat(q, is(not(nullValue())));
        assertThat(q.getResultList().size(), is(1));
    }
    @Test
    public void testFind() {
        for (final Member m : (List<Member>) this.testee.createNamedQuery("findMember")
            .getResultList()) {
            assertThat(this.testee.find(Member.class, m.getId()), is(not(nullValue())));
        }
    }
    @Test
    public void testFlush() {
        this.testee.flush();
    }
    @Test
    public void testGetReference() {
        for (final Member m : (List<Member>) this.testee.createNamedQuery("findMember")
            .getResultList()) {
            assertThat(this.testee.getReference(Member.class, m.getId()), is(not(nullValue())));
        }
    }
    @Test
    public void testLock() {
        for (final Member m : (List<Member>) this.testee.createNamedQuery("findMember")
            .getResultList()) {
            this.testee.lock(m, LockModeType.NONE);
            this.testee.lock(m, LockModeType.OPTIMISTIC);
            this.testee.lock(m, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
            this.testee.lock(m, LockModeType.PESSIMISTIC_READ);
            this.testee.lock(m, LockModeType.PESSIMISTIC_WRITE);
            this.testee.lock(m, LockModeType.PESSIMISTIC_FORCE_INCREMENT);
            this.testee.lock(m, LockModeType.READ);
            this.testee.lock(m, LockModeType.WRITE);
        }
    }
    @Test
    public void testPersist() {
        final Member m = this.testee.persist(new Member());
        assertThat(m.getId(), is(not(nullValue())));
    }
    @Test
    public void testMerge() {
        for (final Member m : (List<Member>) this.testee.createNamedQuery("findMember")
            .getResultList()) {
            m.setAccount(m.getId().toString());
            this.testee.merge(m);
        }
    }
    @Test
    public void testRemove() {
        for (final Member m : (List<Member>) this.testee.createNamedQuery("findMember")
            .getResultList()) {
            this.testee.remove(m);
        }
    }
    @Test
    public void testRefresh() {
        for (final Member m : (List<Member>) this.testee.createNamedQuery("findMember")
            .getResultList()) {
            this.testee.refresh(m);
        }
    }
}
