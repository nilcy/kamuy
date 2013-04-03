// ========================================================================
// Copyright (C) Kamuy Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package kamuy.infra.persistence;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.googlecode.jeeunit.JeeunitRunner;
import com.googlecode.jeeunit.Transactional;
import kamuy.domain.actor.Member;
/**
 * {@link EntityManagerProducer}
 * @author nilcy
 */
@RunWith(JeeunitRunner.class)
@Transactional
@SuppressWarnings("all")
public class EntityManagerProducerTest {
    /** entity manager. */
    @Inject
    @PrimaryEntityManager
    private EntityManager entityManager;
    @Inject
    private Logger log;
    @Test
    public void test() {
        assertThat(this.entityManager, is(not(nullValue())));
        this.entityManager.persist(new Member());
        final Member m = this.entityManager.find(Member.class, 1L);
        this.log.info(m.toString());
    }
}
